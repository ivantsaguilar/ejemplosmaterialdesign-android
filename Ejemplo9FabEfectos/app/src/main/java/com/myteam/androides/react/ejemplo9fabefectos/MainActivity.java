package com.myteam.androides.react.ejemplo9fabefectos;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton fab;
    private boolean expanded = false;

    //3 mini botones
    private View fabMini1, fabMini2, fabMini3;
    ViewGroup fabContainer;
    private float offset1, offset2,offset3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fabContainer = (ViewGroup)findViewById(R.id.fab_container);
        fab = (ImageButton)findViewById(R.id.fab);

        fabMini1 = findViewById(R.id.fab_action_1);
        fabMini2 = findViewById(R.id.fab_action_2);
        fabMini3 = findViewById(R.id.fab_action_3);

        fabMini1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"click 1", Toast.LENGTH_SHORT).show();
            }
        });

        fabMini2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"click 2", Toast.LENGTH_SHORT).show();
            }
        });

        fabMini3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"click 3", Toast.LENGTH_SHORT).show();
            }
        });



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //depende del estado del button es cuando vamos a cambiar de posicion
                /*fab.setSelected(!fab.isSelected());
                fab.setImageResource(fab.isSelected() ? R.drawable.animated_plus : R.drawable.animated_minus);
                Drawable drawable = fab.getDrawable();
                if(drawable instanceof Animatable){
                    ((Animatable)drawable).start();
                }*/
                expanded = !expanded;
                if(expanded){
                    expandFab();
                }else{
                    collapseFab();
                }
            }
        });

        fabContainer.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                fabContainer.getViewTreeObserver().removeOnPreDrawListener(this);
                offset1 = fab.getY() - fabMini1.getY();
                fabMini1.setTranslationY(offset1);
                offset2 = fab.getY() - fabMini2.getY();
                fabMini2.setTranslationY(offset2);
                offset3 = fab.getY() - fabMini3.getY();
                fabMini3.setTranslationY(offset3);
                return true;
            }
        });



        /**
       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
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

    private void collapseFab(){
        fab.setImageResource(R.drawable.animated_plus);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(createCollapseAnimator(fabMini1,offset1),
                                    createCollapseAnimator(fabMini2,offset2),
                                    createCollapseAnimator(fabMini3,offset3)
        );
        animatorSet.start();
        animateFab();

    }

    private void expandFab(){
        fab.setImageResource(R.drawable.animated_minus);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(createExpandAnimator(fabMini1,offset1),
                createExpandAnimator(fabMini2,offset2),
                createExpandAnimator(fabMini3,offset3)
        );
        animatorSet.start();
        animateFab();

    }

    private static final String TRASLATION_Y = "translationY";

    private Animator createCollapseAnimator(View view, float offset){
        return ObjectAnimator.ofFloat(view, TRASLATION_Y,0,offset)
                .setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));
    }

    private Animator createExpandAnimator(View view, float offset){
        return ObjectAnimator.ofFloat(view, TRASLATION_Y,offset,0)
                .setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));
    }

    //Obtenemos los dibujos del button fab
    private void animateFab(){
        Drawable drawable = fab.getDrawable();
        if(drawable instanceof Animatable){
            ((Animatable)drawable).start();
        }
    }
}
