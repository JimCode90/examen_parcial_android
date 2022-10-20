package com.example.examenparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_senior_anillos:
                mostrarSeniorAnillos();
                return true;
            case R.id.nav_vengadores:
                mostrarVengadores();
                return true;
            case R.id.nav_ayuda:
                mostrarAyuda();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void mostrarAyuda() {
        startActivity(new Intent(this, AyudaActivity.class));
    }

    private void mostrarVengadores() {
        startActivity(new Intent(this, VengadoresActivity.class));
    }

    private void mostrarSeniorAnillos() {
        startActivity(new Intent(this, SeniorAnillosActivity.class));
    }
}