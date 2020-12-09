package com.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Ventana que redirecciona a signup
 * @author micaela18
 * @see SignUpActivity
 */
public class LoginActivity extends AppCompatActivity {

    ImageView imgPerro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imgPerro = findViewById(R.id.Perro);

        TextView mSignUpTextview = (TextView)findViewById(R.id.signup_text);

        mSignUpTextview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);


            }
        });
       // String url = "https://images.unsplash.com/photo-1603755043619-9b94c368f4db?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80";

        Glide.with(this)
                .load(R.drawable.perrito)
                .circleCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.colorPrimaryDark)))
//                .placeholder(R.drawable.bg2)
                .into(imgPerro);
    }

    public void login(View view) {
        Intent i = new Intent(this, MainActivity.class);
        //esto es para que cuando le demos al boton de volver desaparezca el login y no vuelva nos aparezca nunca más
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}