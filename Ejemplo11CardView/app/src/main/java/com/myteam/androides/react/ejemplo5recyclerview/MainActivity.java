package com.myteam.androides.react.ejemplo5recyclerview;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    //RecyclerView.Adapter adapter;
    RecyclerAdapter adapter;

    //Lista de elementos
    List<User> userList;

    //Collapsing toolbar
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Eliminamos el titulo del activity
        //aquí podemos poner el nombre del usuario cuando el collapsing este minimizado
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        //Modificamos el nombre del collapsing
        //aqui pondremos el nombre del proyecto
        collapsingToolbarLayout.setTitle("");


        //Proceso del adaptador
        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        initializeData();

        //Uso mi recycler adapter
        adapter = new RecyclerAdapter(userList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initializeData(){

        //Los datos pueden venir de donde sea
        userList = new ArrayList<>();
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img1));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img2));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img3));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img4));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img5));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img6));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img7));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img8));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img9));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img10));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img11));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img12));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img13));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img14));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img15));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img16));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img17));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img18));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img19));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img5));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img6));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img7));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img8));
        userList.add(new User("Title test",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, qui dolores ipsum libero quod ex totam quia blanditiis id. Ratione necessitatibus odio aperiam amet suscipit voluptates eius, unde nobis autem.",
                R.drawable.img9));
    }
}
