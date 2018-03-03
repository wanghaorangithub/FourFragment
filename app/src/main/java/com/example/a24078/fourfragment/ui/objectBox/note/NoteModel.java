package com.example.a24078.fourfragment.ui.objectBox.note;

import android.app.Activity;
import android.util.Log;

import com.example.a24078.fourfragment.utils.App;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.Query;

/**
 * Created by haoran on 2018/3/1.
 *
 */

public class NoteModel implements NoteContract.Model {
    private NoteContract.Callback callback;
    private Box<Note> notesBox;
    private Query<Note> notesQuery;
    private Activity activity;


    NoteModel(NoteContract.Callback callback, Activity activity) {
        this.callback = callback;
        this.activity = activity;
    }

    @Override
    public void initObjectBox() {
        BoxStore boxStore = ((App) activity.getApplication()).getBoxStore();
        notesBox = boxStore.boxFor(Note.class);
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        notesQuery = notesBox.query().order(Note_.text).build();
    }


    @Override
    public void requestDataFromDatabase() {
        List<Note> notes = notesQuery.find();
        callback.requestDataFromDatabaseSuccess(notes);
    }


    @Override
    public void addNoteToDatabase(String noteText) {
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
        callback.addNoteToDatabaseSuccess();
        Log.d(App.TAG, "Inserted new note, ID: " + note.getId());
    }

    @Override
    public void removeNoteFromDatabase(Note note) {
        notesBox.remove(note);
        callback.removeNoteFromDatabaseSuccess();
        Log.d(App.TAG, "Deleted note, ID: " + note.getId());
    }
}
