package com.example.examenparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SeniorAnillosActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_anillos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button img1 = findViewById(R.id.btnImg1);
        Button img2 = findViewById(R.id.btnImg2);
        Button img3 = findViewById(R.id.btnImg3);
        Button img4 = findViewById(R.id.btnImg4);
        
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);

        mostrarImg1();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnImg1:
                System.out.println("img1");
                mostrarImg1();
                break;
            case R.id.btnImg2:
                mostrarImg2();
                break;
            case R.id.btnImg3:
                mostrarImg3();
                break;
            case R.id.btnImg4:
                mostrarImg4();
                break;
        }
    }

    private void mostrarImg4() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new Fragment4())
                .commit();
    }
    private void mostrarImg3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new Fragment3())
                .commit();
    }

    private void mostrarImg2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new Fragment2())
                .commit();
    }

    private void mostrarImg1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new Fragment1())
                .commit();
    }
}