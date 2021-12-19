package usa.reto.reto5.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import usa.reto.reto5.Modelo.BaseDatos.MotorBaseDatosSQLite;
import usa.reto.reto5.R;


public class Adaptador extends BaseAdapter {

    ArrayList<Entidad> lista_items;
    Context context;
    //--coneccion a base--//
    MotorBaseDatosSQLite conectar;

    public Adaptador(ArrayList<Entidad> lista_items, Context context) {
        this.lista_items = lista_items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista_items.size(); // Devuelve cuantos elelmentos hay en la lista
    }

    @Override
    public Object getItem(int posicion) {
        return lista_items.get(posicion); // devuelve la posicion del item;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int posicion, View v, ViewGroup viewGroup) {

        Entidad datosItem = (Entidad) getItem(posicion);
        v = LayoutInflater.from(context).inflate(R.layout.item, null);
        //-------------------------------------------------------------------

        TextView titulo = (TextView)v.findViewById(R.id.titulo_colec);
        ImageView imagen = (ImageView)v.findViewById(R.id.imagen1_colec);
        TextView descripcion = (TextView)v.findViewById(R.id.descripcion_colec);
        TextView precio=(TextView)v.findViewById(R.id.precio_colec);
        CheckBox favorito = (CheckBox) v.findViewById(R.id.favorito_colec);
        Button boton =(Button) v.findViewById(R.id.btnseleccion);

        String imruta = datosItem.getImagen();
        Picasso.get().load(imruta).fit().error(R.mipmap.ic_launcher_foreground).into(imagen);

        //imagen.setImageResource(datosItem.getImagen());
        //imagen.setImageURI(datosItem.getImagen());
        titulo.setText(datosItem.getTitulo());
        descripcion.setText(datosItem.getDescripcion());
        precio.setText(datosItem.getPrecio());


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(favorito.isChecked()){
                    conectar = new MotorBaseDatosSQLite(context,"ChaquetasReto",null,1);
                    SQLiteDatabase escribir_bd = conectar.getWritableDatabase();
                    //conectar.onUpgrade(escribir_bd,1,2);
                     escribir_bd.execSQL("INSERT INTO favoritos VALUES ('"+ datosItem.getImagen() +"','"+ datosItem.getTitulo()+"','"+ datosItem.getDescripcion()+"','"+datosItem.getPrecio()+"')");
                }
                favorito.setChecked(false);
            }




        });

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto5" + R.drawable.cham1);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto5" + R.drawable.cham2);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto5" + R.drawable.cham3);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto5" + R.drawable.chah1);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto5" + R.drawable.chah2);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto5" + R.drawable.chah3);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto5" + R.drawable.medidas);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto5" + R.drawable.domicilio);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto5" + R.drawable.almacen1);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto5" + R.drawable.almacen2);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto5" + R.drawable.ic_icono);
                //Toast.makeText(context, "imagen: " + img.get(0), Toast.LENGTH_LONG ).show();

                //String imagen;
                //imagen=uriImage.toString();
                //Toast.makeText(context, "imagen:" +imagen, Toast.LENGTH_LONG ).show();
                /*---------------*/
            }
        });

        //-------------------------------------------------------------------
        return v;
    }
}


    /**
    ArrayList<Entidad> lista_items;
    Context context;

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conectar;



    public Adaptador(ArrayList<Entidad> lista_items, Context context) {
        this.lista_items = lista_items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista_items.size(); // Devuelve cuntos elelmentos hay en la lista
    }

    @Override
    public Object getItem(int posicion) {
        return lista_items.get(posicion); // devuelve la posicion del item
    }

    @Override
    public long getItemId(int posicion) {
        return 0; // No lo vamos a trabajar
    }

    /*
    Este es el metodo mas importante, aqui vamos a asignar el item y lo elementos y valores a
    cada item.
     */
    /**
    @Override
    public View getView(int posicion, View v, ViewGroup viewGroup) {

        Entidad datosItem = (Entidad) getItem(posicion);

        v = LayoutInflater.from(context).inflate(R.layout.item, null);
        //-------------------------------------------------------------------

        ImageView imagen = (ImageView)v.findViewById(R.id.imagen1_colec);
        TextView titulo = (TextView)v.findViewById(R.id.titulo_colec);
        TextView descripcion = (TextView)v.findViewById(R.id.descripcion_colec);


        //---------------------------------------------------------------------------------
        conectar = new MotorBaseDatosSQLite(context,"TiendaProductos", null, 1);
        SQLiteDatabase db_escribir = conectar.getWritableDatabase();
        conectar.onUpgrade(db_escribir, 1, 2);
        //---------------------------------------------------------------------------------

        Button boton1 = (Button) v.findViewById(R.id.btnseleccion);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Guardado en favoritos", Toast.LENGTH_LONG).show();
                db_escribir.execSQL("INSERT INTO favoritos VALUES (1, '"+datosItem.getTitulo()+"', '"+datosItem.getTitulo()+"')");
            }
        });

        CheckBox favoritos = (CheckBox) v.findViewById(R.id.favorito_colec);*/

        /***
        Pongo los datos de cada item desde la clase Entidad dentro de cada elemento xml
         */
        /***
        imagen.setImageResource(datosItem.getImagen());
        titulo.setText(datosItem.getTitulo());
        descripcion.setText(datosItem.getDescripcion());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "item:" + titulo.getText(), Toast.LENGTH_LONG ).show();
            }
        });

        //-------------------------------------------------------------------
        return v;
    }
*/

