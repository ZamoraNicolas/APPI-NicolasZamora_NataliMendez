package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2, e3, e4, e5;
    Button buscar;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relacionamosVistas();

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarUsuarios("http://192.168.20.174/Android/Buscar.php?ID="+e5.getText()+"");
            }
        });
    }

    public void relacionamosVistas() {
        e1 = findViewById(R.id.cubica);
        e2 = findViewById(R.id.dos);
        e3 = findViewById(R.id.cuadrada);
        e4 = findViewById(R.id.tres);
        e5 = findViewById(R.id.id);
        buscar = findViewById(R.id.Buscar);
    }

    public void buscarUsuarios(String URL) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    if (response.length() > 0) {
                        JSONObject jsonObject = response.getJSONObject(0);
                        e1.setText(jsonObject.optString("Raiz_2"));
                        e2.setText(jsonObject.optString("Raiz_3"));
                        e3.setText(jsonObject.optString("Potencia_2"));
                        e4.setText(jsonObject.optString("Potencia_3"));
                    } else {
                        mostrarMensaje("No se encontraron resultados.");
                    }
                } catch (JSONException e) {
                    mostrarMensaje("Error de conexion.");
                    Log.e("Error", e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mostrarMensaje("Error de conexión con el servidor.");
                Log.e("Error", error.toString());
            }
        });

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(this);
        }
        
        requestQueue.add(jsonArrayRequest);
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (requestQueue != null) {
            requestQueue.cancelAll(this);
            requestQueue = null;
        }
    }
}

