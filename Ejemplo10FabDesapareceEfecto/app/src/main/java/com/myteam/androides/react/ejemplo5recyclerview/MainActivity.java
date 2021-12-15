package com.myteam.androides.react.ejemplo5recyclerview;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    String[] data = {"Element 1","Element 2","Element 3","Element 4","Element 5",
                        "Element 6","Element 7","Element 8","Element 9","Element 10",
                        "Element 11","Element 12","Element 13","Element 14","Element 15"};
    String[] subTitle = {"Element 1","Element 2","Element 3","Element 4","Element 5",
            "Element 6","Element 7","Element 8","Element 9","Element 10",
            "Element 11","Element 12","Element 13","Element 14","Element 15"};

    //Creacion del tab layout
    TabLayout tab;

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

        //Layout tabs
        /**
        tab = (TabLayout)findViewById(R.id.tabs);
        tab.setTabMode(TabLayout.MODE_FIXED);
        tab.addTab(tab.newTab().setText("Tab 1"));
        tab.addTab(tab.newTab().setText("Tab 2"));
        tab.addTab(tab.newTab().setText("Tab 3"));
        tab.addTab(tab.newTab().setText("Tab 4"));
         */


        //Proceso del adaptador
        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //Uso mi recycler adapter
        adapter = new RecyclerAdapter(data,subTitle);
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
}
