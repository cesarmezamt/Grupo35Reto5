package usa.reto.reto5.Vista;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

import usa.reto.reto5.Modelo.Adaptador;
import usa.reto.reto5.Modelo.Entidad;
import usa.reto.reto5.R;


public class Fragment_Productos extends Fragment {



    View v;
    ListView listaProductos;
    Adaptador adaptador;
    TextView titulo;
    ImageView img;


    // Conexion a base de datos en la nube: instancia APEX de SQL en Oracle Cloud

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__productos, container, false);
        //-----------------------------------------------------------------------------
        listaProductos = (ListView) v.findViewById(R.id.lista_productos);
        img=(ImageView) v.findViewById(R.id.imagen1_colec);
        adaptador = new Adaptador(TablaProductos(), getContext());
        listaProductos.setAdapter(adaptador);
       // prueba = (TextView) v.findViewById(R.id.prueba);
        titulo = (TextView) v.findViewById(R.id.tituloproductos);
        //-----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> TablaProductos(){
        ArrayList<Entidad> listaProductos = new ArrayList<>();

        /* ================================================================================================== */
        /* url productos */
        String url = "https://g1ac92d9645ef7b-db202112141529.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/chaquetas/productos";
        /* url servicios */
        //String url = "https://g1ac92d9645ef7b-db202112141529.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/chaquetas/servicios";
        /* url sucursales */
        //String url = "https://g1ac92d9645ef7b-db202112141529.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/chaquetas/sucursales";

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //***********************************************************
                try {
                    JSONArray jsonArray = response.getJSONArray("items");

                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String imagen = jsonObject.getString("imagen");
                        String titulo = jsonObject.getString("titulo");
                        String descripcion = jsonObject.getString("descripcion");
                        String precio = String.valueOf(jsonObject.getInt("precio"));
                        listaProductos.add(new Entidad(imagen, titulo, descripcion,precio));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //***********************************************************
                titulo.setText("Colecciones:" +"\n");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
        //Toast.makeText(getContext(), "lista " + listaProductos.size(), Toast.LENGTH_SHORT).show();
        /* ================================================================================================== */
        return listaProductos;
    }

}