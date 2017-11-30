package com.example.poison101.edutrack;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CodeTride on 2017/08/14.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {



    Context context;
    List<ContactRecycler> contactRecyclersList;

    public RecyclerAdapter() {
    }

    public RecyclerAdapter(Context context, List<ContactRecycler> contactRecyclersList) {
        this.context = context;
        this.contactRecyclersList = contactRecyclersList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_line,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //allows us to take on of textviews
        final ContactRecycler contactRecycler;
        contactRecycler = contactRecyclersList.get(position);

        holder.name.setText(contactRecycler.getmName());
        holder.surname.setText(contactRecycler.getmSurname());
        holder.feedback.setText(contactRecycler.getmFeedback());
        holder.terms.setText(contactRecycler.getmTerm());


    }

    @Override
    public int getItemCount() {
        return contactRecyclersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, surname, feedback, terms;
        CardView cards;
        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            surname = (TextView) itemView.findViewById(R.id.surname);
            feedback = (TextView) itemView.findViewById(R.id.feedback);
            terms = (TextView) itemView.findViewById(R.id.terms);
        }
    }
}
