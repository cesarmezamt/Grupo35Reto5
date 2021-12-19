package usa.reto.reto5.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.CustomZoomButtonsController;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

import usa.reto.reto5.BuildConfig;
import usa.reto.reto5.R;


public class Fragment_Mapa extends Fragment {


    View v;

    private MapView miMapa;
    private MapController miMapaControlador;
    GeoPoint bogota, suc1,suc2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fragment__mapa, container, false);

        miMapa =(MapView) v.findViewById(R.id.openmapview);
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        bogota = new GeoPoint(4.60971,-74.08175);
        suc1= new GeoPoint(4.670894673053206, -74.05471097305816);
        suc2= new GeoPoint(4.602938975570107, -74.10287030250603);

        miMapa.getZoomController().setVisibility(CustomZoomButtonsController.Visibility.ALWAYS);
        //miMapa.setBuiltInZoomControls(true);
        miMapaControlador = (MapController) miMapa.getController();
        miMapaControlador.setCenter(bogota);
        miMapaControlador.setZoom(12);
        miMapa.setMultiTouchControls(true);

        /*---------hilo----------*/
        final MyLocationNewOverlay myLocationoverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getContext()), miMapa);
        miMapa.getOverlays().add(myLocationoverlay); //No añadir si no quieres una marca
        myLocationoverlay.enableMyLocation();
        myLocationoverlay.runOnFirstFix(new Runnable() {
            public void run() {
                miMapaControlador.animateTo(myLocationoverlay.getMyLocation());
            }
        });
        /*----------------------------*/

        /*-----------marcas-------------*/
        ArrayList<OverlayItem> puntos = new ArrayList<OverlayItem>();
        puntos.add(new OverlayItem("Colombia - Bogotá", "Bogotá D.C", bogota));
        puntos.add(new OverlayItem("Norte", "Principal", suc1));
        puntos.add(new OverlayItem("Centro", "Av.Dorado", suc2));

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };
        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(getContext(), puntos, tap);
        capa.setFocusItemsOnTap(true);
        miMapa.getOverlays().add(capa);

        return v;
    }
}