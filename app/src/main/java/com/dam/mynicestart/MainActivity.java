package com.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Ventana con un bar
 * @author micaela18
 */

public class MainActivity extends AppCompatActivity {

    ImageView imgPerro2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPerro2 = findViewById(R.id.Perro2);

        //*******Glide
        ImageView mycontext = findViewById(R.id.Perro2);
        registerForContextMenu(mycontext);

        Glide.with(this)
                .load(R.drawable.perro2)
                .circleCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                // .placeholder(new ColorDrawable(this.getResources().getColor(R.color.colorPrimaryDark)))
//                .placeholder(R.drawable.bg2)
                .into(imgPerro2);

        //******Expandable Card*******
        ExpandableCardView card = findViewById(R.id.profile);
        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                Toast.makeText(MainActivity.this, isExpanded ? "Expanded!" : "Collapsed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ok(View view) {

        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}