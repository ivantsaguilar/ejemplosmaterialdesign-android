package com.myteam.androides.react.ejemplo5recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ivants on 4/12/16.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private String[] myData;
    private String[] myDataSon;

    //Primero le declaramos un contructor
    public RecyclerAdapter(String[] data,String[] subTitle){
        myData = data;
        myDataSon = subTitle;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //¿de donde vamos a sacar la vista de los elementos
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //vamos a actualizar los datos del ViewHolder
        //elementos ViewHolder
        holder.title.setText(myData[position]);
        holder.subTitle.setText(myDataSon[position]);
    }

    @Override
    public int getItemCount() {
        return myData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView subTitle;

        //aqui es donde le vamos a decir cuales son los datos de cada item
        public ViewHolder(View itemView){
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            subTitle = (TextView)itemView.findViewById(R.id.subTitle);
        }
    }
}
