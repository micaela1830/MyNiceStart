package com.dam.mynicestart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.snackbar.Snackbar;

/**
 * Ventana con un bar
 * @author micaela18
 */

public class MainActivity extends AppCompatActivity {

    ImageView imgPerro2;
    SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPerro2 = findViewById(R.id.Perro2);

        //******Expandable Card*******
        ExpandableCardView card = findViewById(R.id.profile);
        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                Toast.makeText(MainActivity.this, isExpanded ? "Expanded!" : "Collapsed!", Toast.LENGTH_SHORT).show();
            }
        });

        // Swip Layout
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        ImageView mycontext = findViewById(R.id.Perro2);
        registerForContextMenu(mycontext);
        //       cast al Layout SWIPEREFRESH con el que rodeamos la vista en el xml y le colocamos un listener

        //*******Glide
        Glide.with(this)
                .load(R.drawable.perro2)
                .centerCrop()
                .circleCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                // .placeholder(new ColorDrawable(this.getResources().getColor(R.color.colorPrimaryDark)))
//                .placeholder(R.drawable.bg2)
                .into(imgPerro2);


    }
    // *** SWIPEREFRESH con SNACKBAR ***

    //    construimos el Swipe y aplicamos un Listener que lanza un SnackBar y desactiva a continuación del Swipe la animación
    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            final ConstraintLayout mLayout = findViewById(R.id.activity_main_context);

            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();
            swipeLayout.setRefreshing(false);
        }
    };


    public void ok(View view) {

        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
    // *** MENU CONTEXTUAL ***

    //    inflamos el menu contextual con los items del menu xml correspondiente
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);

    }

    //    creamos una lista de eventos para los items del menus contextual
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.edit:
                Toast toast = Toast.makeText(this, "going CONTEXT EDIT", Toast.LENGTH_LONG);
                toast.show();
                break;

            case R.id.delete:
                Toast toast2 = Toast.makeText(this, "going CONTEXT DELETE", Toast.LENGTH_LONG);
                toast2.show();
                break;
        }
        return super.onContextItemSelected(item);
    }
    // *** MENU APPBAR ***

    //    inflamos el menu del AppBar con los items del recurso xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //    creamos una lista de eventos para los items del menu del AppBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;

        } if (id == R.id.heart) {
            Toast toast = Toast.makeText(this, "going Favorites", Toast.LENGTH_LONG);
            toast.show();

            showAlertDialogButtonClicked(MainActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }

    // *** DIALOGO MODAL ***
    public void showAlertDialogButtonClicked(MainActivity view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
//        builder.setTitle("Achtung!");
//        builder.setMessage("Where do you go?");
//        builder.setIcon(R.drawable.ic_action_name_dark);
//        un XML a medida para el diálogo

        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view,
                null));

        // add the buttons
        builder.setPositiveButton("Glide", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });
        builder.setNegativeButton("ChatBot", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });

        builder.setNeutralButton("MotionLayout", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}