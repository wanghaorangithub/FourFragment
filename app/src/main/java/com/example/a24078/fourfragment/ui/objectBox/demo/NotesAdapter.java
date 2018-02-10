package com.example.a24078.fourfragment.ui.objectBox.demo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a24078.fourfragment.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> implements View.OnClickListener {

    private List<Note> dataset;
    private OnItemClickListener onItemClickListener;


    static class NoteViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewNoteText)
        public TextView text;
        @BindView(R.id.textViewNoteComment)
        TextView comment;

        NoteViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    NotesAdapter() {
        this.dataset = new ArrayList<>();
    }

    void setNotes(List<Note> notes) {
        dataset = notes;
        notifyDataSetChanged();
    }


    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_note, viewGroup, false);
        view.setOnClickListener(this);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder noteViewHolder, int position) {
        Note note = getItem(position);
        noteViewHolder.text.setText(note.getText());
        noteViewHolder.comment.setText(note.getComment());

        //将position保存在itemView的Tag中，以便点击时进行获取
        noteViewHolder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


    Note getItem(int position) {
        return dataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //传入onItemClickListener后调用onItemClick方法，这个onItemClick方法在Activity中定义
    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            //注意这里使用getTag方法获取position
            onItemClickListener.onItemClick(view, (int) view.getTag());
        }
    }

    //将在activity中调用，返回OnItemClickListener
    void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
