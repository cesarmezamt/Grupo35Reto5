package usa.reto.reto5.Vista;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import usa.reto.reto5.R;


public class Fragment_Inicio extends Fragment {

    View v;
    Drawable drawable;
    ImageView imagenini;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment__inicio, container, false);
        //*****carga imagenes******//

        Resources ima1 = getResources();
        drawable = ima1.getDrawable(R.drawable.inicioimg, v.getContext().getTheme());
        imagenini = (ImageView) v.findViewById(R.id.imagenini_fini);
        imagenini.setImageDrawable(drawable);
        return v;
    }

}