package com.example.a24078.fourfragment.ui.objectBox.demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a24078.fourfragment.R;
import com.example.a24078.fourfragment.ui.base.BaseActivity;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.Query;

/**
 * Created by haoran on 2018/2/8.
 */

public class NoteActivity extends BaseActivity {
    @BindView(R.id.obj_act_editText1)
    protected EditText editText;

    @BindView(R.id.obj_act_button1)
    protected View addNoteButton;

    @BindView(R.id.obj_act_recyclerView1)
    protected RecyclerView recyclerView;

    private Box<Note> notesBox;
    private Query<Note> notesQuery;
    private NotesAdapter notesAdapter;

    //click item event
    public void setOnItemClickListener() {
        notesAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                removeNote(position);
            }
        });
    }

    //click add button
    @OnClick(R.id.obj_act_button1)
    public void onAddButtonClick(View view) {
        addNote();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_objectbox;
    }

    @Override
    protected void created(Bundle bundle) {
        setUpViews();
        initObjectBox();
        updateNotes();
        setOnItemClickListener();
    }

    @Override
    protected void resumed() {
    }

    private void initObjectBox() {
        BoxStore boxStore = ((App) getApplication()).getBoxStore();
        notesBox = boxStore.boxFor(Note.class);
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        notesQuery = notesBox.query().order(Note_.text).build();
    }

    private void updateNotes() {
        List<Note> notes = notesQuery.find();
        notesAdapter.setNotes(notes);
    }

    protected void setUpViews() {
        notesAdapter = new NotesAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(notesAdapter);
        addNoteButton.setEnabled(false);
        editText = findViewById(R.id.obj_act_editText1);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    addNote();
                    return true;
                }
                return false;
            }
        });
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean enable = s.length() != 0;
                addNoteButton.setEnabled(enable);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                editText.removeTextChangedListener(this);
                //do something
                editText.addTextChangedListener(this);
            }
        });

    }


    private void addNote() {
        String noteText = editText.getText().toString();
        //输入结束之后清空editText
        editText.setText("");
        //得到创建时间
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        String comment = "Added on " + df.format(new Date());
        //将数据传入note
        Note note = new Note();
        note.setText(noteText);
        note.setComment(comment);
        note.setDate(new Date());
        //将note传入数据库
        notesBox.put(note);
        Log.d(App.TAG, "Inserted new note, ID: " + note.getId());

        updateNotes();
    }

    private void removeNote(int position) {
        Note note = notesAdapter.getItem(position);
        notesBox.remove(note);
        Log.d(App.TAG, "Deleted note, ID: " + note.getId());
        updateNotes();
    }
}
