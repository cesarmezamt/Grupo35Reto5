package usa.reto.reto5.Modelo.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MotorBaseDatosSQLite extends SQLiteOpenHelper {

        private SQLiteDatabase sqLDatabase;


        public MotorBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, "ChaquetasReto", null, 1);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            // tabla favoritos
            db.execSQL("CREATE TABLE favoritos (imagen TEXT, titulo TEXT,descripcion TEXT,precio TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
              db.execSQL("DROP TABLE IF EXISTS favoritos");
            onCreate(db);
        }

    /**
     Uri img1, img2, img3, img4, img5, img6, img7, img8, img9, img10,img11;
     img1 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.cham1);
     img2 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.cham2);
     img3 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.cham3);
     img4 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.chah1);
     img5 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.chah2);
     img6 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.chah3);
     img7 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.medidas);
     img8 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.domicilio);
     img9 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.almacen1);
     img10 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.almacen2);
     img11 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.ic_icono);
     */
    /**
     //Imagenes productos
     img1 = Uri.parse("android.resource://usa.reto.reto3/2131230824");
     img2 = Uri.parse("android.resource://usa.reto.reto3/2131230825");
     img3 = Uri.parse("android.resource://usa.reto.reto3/2131230826");
     img4 = Uri.parse("android.resource://usa.reto.reto3/2131230821");
     img5 = Uri.parse("android.resource://usa.reto.reto3/2131230822");
     img6 = Uri.parse("android.resource://usa.reto.reto3/2131230823");
     //Imagenes servicios
     img7 = Uri.parse("android.resource://usa.reto.reto3/2131230869");
     img8 = Uri.parse("android.resource://usa.reto.reto3/2131230832");
     //Imagenes sucursales
     img9 = Uri.parse("android.resource://usa.reto.reto3/2131230806");
     img10 = Uri.parse("android.resource://usa.reto.reto3/2131230807");
     */

    /**
     * imagenes en FLICKR
     * medidas https://live.staticflickr.com/65535/51754590059_19a640fe2b_m.jpg
     * 		    https://live.staticflickr.com/65535/51754608309_ce69dca37f_q.jpg
     * inicioimg https://live.staticflickr.com/65535/51754819500_6375dedfc8_m.jpg
     * domicilio https://live.staticflickr.com/65535/51754184998_9ef7066a92_m.jpg
     * cham1 https://live.staticflickr.com/65535/51753118102_0864612306_m.jpg
     * cham2 https://live.staticflickr.com/65535/51754590099_fd6cf1524b_m.jpg
     * cham3 https://live.staticflickr.com/65535/51754185008_3cd95e538d_m.jpg
     * chah1 https://live.staticflickr.com/65535/51753947386_ee59b6fe90_m.jpg
     * chah2 https://live.staticflickr.com/65535/51753947366_581ffc5b18_m.jpg
     * chah3 https://live.staticflickr.com/65535/51754185068_67ba21d057_m.jpg
     * almacen1 https://live.staticflickr.com/65535/51754185103_67151b11c0_m.jpg
     * almacen2 https://live.staticflickr.com/65535/51753947391_8218ec8cee_m.jpg
     */




}
