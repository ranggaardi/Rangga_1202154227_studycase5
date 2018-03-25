package com.example.android.rangga_1202154227_modul5;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

/**
 * Created by ranggaardi on 3/25/2018.
 */

public class adapter extends RecyclerView.Adapter<adapter.RecyclerViewHolder> {
    private LinkedList<Model> WordList;
    private LayoutInflater Inflater;

    public adapter(Context context, LinkedList<Model> wordList) {
        Inflater = LayoutInflater.from(context);
        this.WordList = wordList;
    }

    @Override
    public adapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View ItemView = Inflater.inflate(R.layout.list, parent, false);
        return new RecyclerViewHolder(ItemView, this);
    }

    @Override
    public void onBindViewHolder(adapter.RecyclerViewHolder holder, int position) {
        holder.NameView.setText(WordList.get(position).getName());
        holder.DescView.setText(WordList.get(position).getDesc());
        holder.PriorityView.setText(WordList.get(position).getPriority());
    }

    @Override
    public int getItemCount() {
        return WordList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public final TextView NameView, DescView, PriorityView;
        final adapter Adapter;

        public RecyclerViewHolder(View itemView, adapter adapter) {
            super(itemView);

            NameView = (TextView) itemView.findViewById(R.id.nm);
            DescView = (TextView) itemView.findViewById(R.id.dc);
            PriorityView = (TextView) itemView.findViewById(R.id.jml);

            this.Adapter = adapter;
        }
    }
    public void hpsData(int pos){
        DataHelper db = new DataHelper(Inflater.getContext());
        boolean deleted = db.delete(WordList.get(pos));
        if (deleted){
            WordList.remove(pos);
            this.notifyItemRemoved(pos);
            Toast.makeText(Inflater.getContext(),"Deleted Success",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(Inflater.getContext(),"Deleted Failed",Toast.LENGTH_SHORT).show();
        }
    }
}