package com.example.a24078.fourfragment.ui.objectBox.note;

import android.app.Activity;

import java.util.List;

/**
 * Created by haoran on 2018/3/1.
 *
 */

public interface NoteContract {
    interface View {
        void setUpView();

        Activity getFuckingActivity();

        void setDataInRecyclerView(List<Note> notes);

        void setEditTextBlank();

        String getEditTextText();

    }

    interface Model {
        void requestDataFromDatabase();

        void addNoteToDatabase(String text);

        void removeNoteFromDatabase(Note note);

        void initObjectBox();
    }

    interface Presenter {
        void start();

        void tryToAddNote();

        void tryToRemoveNote(Note note);

    }

    interface Callback {
        void addNoteToDatabaseSuccess();

        void removeNoteFromDatabaseSuccess();

        void requestDataFromDatabaseSuccess(List<Note> notes);

    }
}
