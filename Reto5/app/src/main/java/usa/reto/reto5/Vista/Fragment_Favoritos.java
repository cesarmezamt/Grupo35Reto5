package usa.reto.reto5.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import usa.reto.reto5.Modelo.Adaptador;
import usa.reto.reto5.Modelo.BaseDatos.MotorBaseDatosSQLite;
import usa.reto.reto5.Modelo.Entidad;
import usa.reto.reto5.R;


public class Fragment_Favoritos extends Fragment {


    View v;
    ListView listafavoritos;
    Adaptador adaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__favoritos, container, false);

        listafavoritos = (ListView) v.findViewById(R.id.lista_favoritos);
        adaptador = new Adaptador(tablafavoritos(), getContext());
        //adaptador = new Adaptador(GetListItems(), getContext());
        listafavoritos.setAdapter(adaptador);

        return v;
    }

    private ArrayList<Entidad> tablafavoritos() {
        ArrayList<Entidad> lista = new ArrayList<>();
        MotorBaseDatosSQLite conector = new MotorBaseDatosSQLite(getContext(),"ChaquetasReto",null,1);
        SQLiteDatabase leer_bd = conector.getReadableDatabase();
        Cursor cursor = leer_bd.rawQuery("SELECT * FROM favoritos", null);
        while(cursor.moveToNext()){
            //lista.add(new Entidad(Uri.parse(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            lista.add(new Entidad(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
        }
        return lista;
    }


}