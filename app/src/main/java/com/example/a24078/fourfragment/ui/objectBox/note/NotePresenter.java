package com.example.a24078.fourfragment.ui.objectBox.note;

import java.util.List;

/**
 * Created by haoran on 2018/3/1.
 */

class NotePresenter implements NoteContract.Presenter, NoteContract.Callback {
    private NoteContract.View view;
    private NoteContract.Model model;

    NotePresenter(NoteContract.View view) {
        this.view = view;
        model = new NoteModel(this, view.getFuckingActivity());
    }

    //Presenter
    @Override
    public void start() {
        view.setUpView();
        model.initObjectBox();
    }

    @Override
    public void tryToAddNote() {
        model.addNoteToDatabase(view.getEditTextText());
        view.setEditTextBlank();
    }

    @Override
    public void tryToRemoveNote(Note note) {
        model.removeNoteFromDatabase(note);
    }

    @Override
    public void addNoteToDatabaseSuccess() {
        model.requestDataFromDatabase();
    }

    @Override
    public void removeNoteFromDatabaseSuccess() {
        model.requestDataFromDatabase();
    }

    @Override
    public void requestDataFromDatabaseSuccess(List<Note> notes) {
        view.setDataInRecyclerView(notes);
    }

}
