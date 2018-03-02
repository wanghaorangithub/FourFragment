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

        Note getItemWhichWillRemoved(int position);
    }

    interface Model {
        void requestNotesToAddNote();

        void requestNotesToRemoveNote(int position);

        void requestNotesToUpdateNote();

        void addNoteToDatabase(String text);

        void removeNoteFormDatabase(Note note);

        void initObjectBox();
    }

    interface Presenter {
        void start();

        void tryToAddNote();

        void tryToRemoveNote(int position);

    }

    interface Callback {
        void requestNotesToAddNoteSuccess(List<Note> notes);

        void requestNotesToRemoveNoteSuccess(List<Note> notes, int position);

        void requestNotesToUpdateNoteSuccess(List<Note> notes);

    }
}
