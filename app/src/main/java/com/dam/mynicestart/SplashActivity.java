package com.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Ventana de bienvenida con una animación y una scrim
 * @author micaela18
 * @see LoginActivity
 */
public class SplashActivity extends AppCompatActivity {

    TextView tvFrase;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    ImageView hueso;
//ObjectAnimator ---> Nos proporciona soporte para animar nuestras objetos
    private ObjectAnimator animatorTodo;
    private ObjectAnimator animatorRotation;
    private ObjectAnimator animatorAlpha;

    //AnimatorSet----> Reproduce un conjunto de ObjectAnimator en un orden específico. Las animaciones pueden ser todas a la vez
    private AnimationSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //esto es para que  sea full screeam y no se vea la parte de arriba
        setContentView(R.layout.activity_splash);

        openApp(true);
        tvFrase = findViewById(R.id.tvFrase);
        img1 = findViewById(R.id.punto1);
        img2 = findViewById(R.id.punto2);
        img3 = findViewById(R.id.punto3);
        img4 = findViewById(R.id.punto4);
        img5 = findViewById(R.id.punto5);
        img6 = findViewById(R.id.punto6);
        img7 = findViewById(R.id.punto7);
        img8 = findViewById(R.id.punto8);
        hueso = findViewById(R.id.hueso);

        TextView mySubtitle = (TextView) findViewById(R.id.eslogan);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        tvFrase.startAnimation(myanim);
        mySubtitle.startAnimation(myanim);

        openApp(true);

        //Agregar animaciones
        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.rotar_alpha);
        Animation animacion3 = AnimationUtils.loadAnimation(this, R.anim.rotar_alpha2);
        Animation animacion4 = AnimationUtils.loadAnimation(this, R.anim.rotar_alpha3);
        Animation animacion5 = AnimationUtils.loadAnimation(this, R.anim.rotar_alpha4);
        Animation animacion6 = AnimationUtils.loadAnimation(this, R.anim.rotar_alpha5);
        Animation animacion7 = AnimationUtils.loadAnimation(this, R.anim.rotar_alpha6);
        Animation animacion8 = AnimationUtils.loadAnimation(this, R.anim.rotar_alpha7);
        Animation animacion9 = AnimationUtils.loadAnimation(this, R.anim.rotar_alpha8);
        img1.setAnimation(animacion2);
        img2.setAnimation(animacion3);
        img3.setAnimation(animacion4);
        img4.setAnimation(animacion5);
        img5.setAnimation(animacion6);
        img6.setAnimation(animacion7);
        img7.setAnimation(animacion8);
        img8.setAnimation(animacion9);

        hueso.setAnimation(animacion1);



    }


    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity
                        .this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }

}