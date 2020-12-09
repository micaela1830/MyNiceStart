package com.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * Ventana con boton cancelar que vuelve a tras
 * @author micaela18
 */

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void cancelar(View view) {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }
}