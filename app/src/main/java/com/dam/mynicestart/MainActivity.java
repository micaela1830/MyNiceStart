package com.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Ventana que lanza a otra mediante un boton
 * @author micaela18
 * @see  MainActivity2
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ok(View view) {

        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}