package com.myteam.androides.react.ejemplo5recyclerview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ivants on 4/12/16.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    //¿Que tipo de dato vamos a manejar dentro de nuestro recycler?
    List<User> users;
    Context context;
    static int lastPosition = -1;

    //Primero le declaramos un contructor
    public RecyclerAdapter(List<User> users, Context context){
        this.users = users;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //¿de donde vamos a sacar la vista de los elementos
        //hacemos referencia al layout de los item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //vamos a actualizar los datos del ViewHolder
        //elementos ViewHolder
        holder.title.setText(users.get(position).title);
        holder.twitter.setText((users.get(position).twitter).substring(0,150));
        holder.image.setImageResource(users.get(position).photoID);

        setAnimation(holder.cardView,position);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView twitter;
        public ImageView image;
        public CardView cardView;

        //aqui es donde vamos a definir lo que vamos a trabajar en el xml
        public ViewHolder(View itemView){
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardview);
            title = (TextView)itemView.findViewById(R.id.title);
            twitter = (TextView)itemView.findViewById(R.id.twitter);
            image = (ImageView)itemView.findViewById(R.id.image);
        }
    }

    public void setAnimation(View viewToAnimate, int position){

        //validamos si podemos poner la animacion
        if(position > lastPosition){
            Animation animation = AnimationUtils.loadAnimation(context,R.anim.left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }

    }
}
