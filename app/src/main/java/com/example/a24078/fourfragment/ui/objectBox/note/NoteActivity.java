package com.example.a24078.fourfragment.ui.objectBox.note;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a24078.fourfragment.R;
import com.example.a24078.fourfragment.ui.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class NoteActivity extends BaseActivity implements NoteContract.View {
    @BindView(R.id.obj_act_editText1)
    protected EditText editText;

    @BindView(R.id.obj_act_button1)
    protected View addNoteButton;

    @BindView(R.id.obj_act_recyclerView1)
    protected RecyclerView recyclerView;

    private NotesAdapter notesAdapter;

    private NoteContract.Presenter presenter;

    //click item event
    public void setOnItemClickListener() {
        notesAdapter.setOnItemClickListener(new NotesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Note note=getItemWhichWillRemoved(position);
                presenter.tryToRemoveNote(note);
            }
        });
    }

    //click add button
    @OnClick(R.id.obj_act_button1)
    public void onAddButtonClick(View view) {
        presenter.tryToAddNote();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_objectbox;
    }

    @Override
    protected void created(Bundle bundle) {
        presenter = new NotePresenter(this);
        presenter.start();
        setOnItemClickListener();
    }

    @Override
    protected void resumed() {
    }

    private void setUpAddButton(boolean enabled) {
        addNoteButton.setEnabled(enabled);
    }

    private void setUpEditText() {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    presenter.tryToAddNote();
                    return true;
                }
                return false;
            }
        });
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean enable = s.length() != 0;
                setUpAddButton(enable);
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

    private void setUpRecyclerView() {
        notesAdapter = new NotesAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(notesAdapter);
    }

    @Override
    public void setUpView() {
        setUpRecyclerView();
        setUpAddButton(false);
        setUpEditText();
    }

    @Override
    public Activity getFuckingActivity() {
        return this;
    }

    @Override
    public void setDataInRecyclerView(List<Note> notes) {
        notesAdapter.setNotes(notes);
    }

    @Override
    public void setEditTextBlank() {
        editText.setText("");
    }

    @Override
    public String getEditTextText() {
        return editText.getText().toString();
    }

    private Note getItemWhichWillRemoved(int position) {
        return notesAdapter.getItem(position);
    }

}
