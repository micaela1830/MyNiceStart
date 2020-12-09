package com.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Verntana de registro con botón diferente
 * @author micaela18
 * @see LoginActivity
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