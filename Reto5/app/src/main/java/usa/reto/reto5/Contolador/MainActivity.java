package usa.reto.reto5.Contolador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import usa.reto.reto5.R;
import usa.reto.reto5.Vista.Fragment_Favoritos;
import usa.reto.reto5.Vista.Fragment_Inicio;
import usa.reto.reto5.Vista.Fragment_Productos;
import usa.reto.reto5.Vista.Fragment_Servicios;
import usa.reto.reto5.Vista.Fragment_Sucursales;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    Fragment pntinicial, pntproducto,pntservicio,pntsucursal,pntfavorito;
    FragmentTransaction pntcambio;

    /**
     *
     * @autor César Alberto Meza Gonzélez
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //**** icono en barra***//
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_foreground);
        //**** icono en barra***//

        pntinicial= new Fragment_Inicio();
        pntproducto = new Fragment_Productos();
        pntservicio = new Fragment_Servicios();
        pntsucursal = new Fragment_Sucursales();
        pntfavorito = new Fragment_Favoritos();


        getSupportFragmentManager().beginTransaction().add(R.id.contenedorpro, pntinicial).commit();

        //*** def botones ***//

        btn1= (Button) findViewById(R.id.btnproductos);
        btn2= (Button) findViewById(R.id.btnservicios);
        btn3= (Button) findViewById(R.id.btnsucursales);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pntcambio = getSupportFragmentManager().beginTransaction();
                pntcambio.replace(R.id.contenedorpro,pntproducto).addToBackStack(null).commit();
                Toast.makeText(getApplicationContext(),"Nuevos Productos Próximamente",Toast.LENGTH_LONG).show();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pntcambio = getSupportFragmentManager().beginTransaction();
                pntcambio.replace(R.id.contenedorpro,pntservicio).addToBackStack(null).commit();
                Toast.makeText(getApplicationContext(),"Nuevos Servicios Próximamente",Toast.LENGTH_LONG).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pntcambio = getSupportFragmentManager().beginTransaction();
                pntcambio.replace(R.id.contenedorpro,pntsucursal).addToBackStack(null).commit();
                Toast.makeText(getApplicationContext(),"Nuevas Sucursales Próximamente",Toast.LENGTH_LONG).show();
            }
        });

    }


    //**** menu  ***//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id ==R.id.inicio){
            pntcambio = getSupportFragmentManager().beginTransaction();
            pntcambio.replace(R.id.contenedorpro,pntinicial).addToBackStack(null).commit();

        }
        if (id ==R.id.productos){
            pntcambio = getSupportFragmentManager().beginTransaction();
            pntcambio.replace(R.id.contenedorpro,pntproducto).addToBackStack(null).commit();

        }
        if (id ==R.id.servicios){
            pntcambio = getSupportFragmentManager().beginTransaction();
            pntcambio.replace(R.id.contenedorpro,pntservicio).addToBackStack(null).commit();

        }
        if (id ==R.id.sucursales){
            pntcambio = getSupportFragmentManager().beginTransaction();
            pntcambio.replace(R.id.contenedorpro,pntsucursal).addToBackStack(null).commit();

        }

        if (id ==R.id.favoritos){
            pntcambio = getSupportFragmentManager().beginTransaction();
            pntcambio.replace(R.id.contenedorpro,pntfavorito).addToBackStack(null).commit();

        }
        return super.onOptionsItemSelected(item);
    }



    /********
    Fragment subPantalla1, subPantalla2, subPantalla3, subPantalla4, subPantallaInicio;
    FragmentTransaction intercambio;

    Button boton1, boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subPantalla1 = new Fragment_Productos();
        subPantalla2 = new Fragment_Servicios();
        subPantalla3 = new Fragment_Sucursales();
        subPantalla4 = new Fragment_Favoritos();
        subPantallaInicio = new Fragment_Inicio();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragments, subPantallaInicio).commit();

        boton1 = (Button)findViewById(R.id.btnproductos);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intercambio = getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor_fragments, subPantalla1).commit();
            }
        });

        boton2 = (Button)findViewById(R.id.btnservicios);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intercambio = getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor_fragments, subPantalla2).commit();
            }
        });


    }

    //****************************************** MENU DE OPCIONES ***************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.opcion1){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla4).commit();
        }
        if (id == R.id.opcion2){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla1).commit();
        }
        if (id == R.id.opcion3){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla2).commit();
        }
        if (id == R.id.opcion4){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla3).commit();
        }
        return super.onOptionsItemSelected(item);
    }
    //******************************************************************************************************************/

}