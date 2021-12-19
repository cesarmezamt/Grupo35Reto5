package usa.reto.reto5.Vista;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
import org.osmdroid.config.Configuration;
import org.osmdroid.library.BuildConfig;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

import usa.reto.reto5.Modelo.Adaptador;
import usa.reto.reto5.Modelo.Entidad;
import usa.reto.reto5.R;


public class Fragment_Sucursales extends Fragment {

    View v;
    ListView listaProductos;
    Adaptador adaptador;
    TextView titulo;
    Button btn1;
    Fragment pntmapa;
    ImageView img;

    // Conexion a base de datos en la nube: instancia APEX de SQL en Oracle Cloud

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__sucursales, container, false);
        //-----------------------------------------------------------------------------
        listaProductos = (ListView) v.findViewById(R.id.lista_sucursales);
        img=(ImageView) v.findViewById(R.id.imagen1_colec);
        adaptador = new Adaptador(TablaSucursales(), getContext());
        listaProductos.setAdapter(adaptador);
        // prueba = (TextView) v.findViewById(R.id.prueba);
        titulo = (TextView) v.findViewById(R.id.titulosucursales);
        //----------------- Mapa --------------------------------------------------
        btn1= (Button) v.findViewById(R.id.btnmapa);
        pntmapa= new Fragment_Mapa();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentManager manager = getParentFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.contenedorpro, pntmapa).addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext().getApplicationContext(),"Mapas",Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }

    private ArrayList<Entidad> TablaSucursales(){
        ArrayList<Entidad> listaProductos = new ArrayList<>();

        /* ================================================================================================== */
        /* url productos */
        //String url = "https://g1ac92d9645ef7b-db202112141529.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/chaquetas/productos";
        /* url servicios */
        //String url = "https://g1ac92d9645ef7b-db202112141529.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/chaquetas/servicios";
        /* url sucursales */
        String url = "https://g1ac92d9645ef7b-db202112141529.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/chaquetas/sucursales";


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
                        //Picasso.get().load(imagen).fit().error(R.mipmap.ic_launcher_foreground).into(img);
                        //listaProductos.add(new Entidad(titulo, descripcion,precio));
                        //listaProductos.add(new Entidad(Uri.parse(imagen), titulo, descripcion,precio));
                        listaProductos.add(new Entidad(imagen, titulo, descripcion,precio));
                        //prueba.setText(" " + '\n');

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //***********************************************************
                titulo.setText("Sucursales:" +"\n");
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