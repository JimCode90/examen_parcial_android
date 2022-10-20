package com.example.examenparcial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.examenparcial.adapters.ProductoAdapter;
import com.example.examenparcial.databinding.ActivityVengadoresBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VengadoresActivity extends AppCompatActivity implements ProductoAdapter.OnItemClickListener {

    private ActivityVengadoresBinding binding;
    ArrayList arrayList = new ArrayList<HashMap<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVengadoresBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        leerDatos();
    }

    private void leerDatos() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://servicios.campus.pe/servicioproductostodos.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("DATOS",response);
                        llenarLista(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DATOSERROR",error.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    private void llenarLista(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);
            for(int i = 0; i< jsonArray.length(); i++ ){
                String idproducto = jsonArray.getJSONObject(i).getString("idproducto");
                String nombre = jsonArray.getJSONObject(i).getString("nombre");
                String precio = jsonArray.getJSONObject(i).getString("precio");
                String imagenchica = jsonArray.getJSONObject(i).getString("imagenchica");
                HashMap<String,String> map = new HashMap<>();
                map.put("idproducto",idproducto);
                map.put("nombre",nombre);
                map.put("precio",precio);
                map.put("imagenchica",imagenchica);
                arrayList.add(map);
            }

            ProductoAdapter productoAdapter = new ProductoAdapter(arrayList);
            binding.rvProductos.setAdapter(productoAdapter);
            binding.rvProductos.setLayoutManager(new LinearLayoutManager(this));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onItemClick(int position) {
        //Log.d("POS-ACTI", String.valueOf(position));
//        HashMap<String,String> map = (HashMap<String, String>) arrayList.get(position);
//        String nombre = map.get("nombre");
//        String idtipo = map.get("idtipo");
//        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show();
//
//        Bundle bundle = new Bundle();
//        bundle.putString("idtipo",idtipo);
//        bundle.putString("nombre",nombre);
//
//        Intent intent = new Intent(this, CoffeDetalleActivity.class);
//        intent.putExtras(bundle);
//        startActivity(intent);
    }
}