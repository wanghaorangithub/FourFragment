package com.example.a24078.fourfragment.ui.objectBox.note;

import java.util.List;

/**
 * Created by haoran on 2018/3/1.
 *
 *
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
        model.requestNotesToAddNote();
        model.requestNotesToUpdateNote();
        view.setEditTextBlank();
    }

    @Override
    public void tryToRemoveNote(int position) {
        model.requestNotesToRemoveNote(position);
        model.requestNotesToUpdateNote();
    }

    //Callback
    @Override
    public void requestNotesToAddNoteSuccess(List<Note> notes) {
        model.addNoteToDatabase(view.getEditTextText());
    }

    @Override
    public void requestNotesToRemoveNoteSuccess(List<Note> notes, int position) {
        Note note = view.getItemWhichWillRemoved(position);
        model.removeNoteFormDatabase(note);
    }

    @Override
    public void requestNotesToUpdateNoteSuccess(List<Note> notes) {
        view.setDataInRecyclerView(notes);
    }

}
