package com.example.basesdatos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public EditText mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void borrarDatos(View view) {
        AdmBaseDatosSQLite admin = new AdmBaseDatosSQLite(MainActivity.this,
                "Lukas", null, 1);
        //Abrimos la base de datos
        SQLiteDatabase baseDeDatos = admin.getReadableDatabase();

        baseDeDatos.execSQL("DELETE FROM futbolistas");
        mensaje = findViewById(R.id.editTextTextPersonName);
        mensaje.setText("Futbolistas borrados");
    }

    public void insertarDatos(View view) {
        AdmBaseDatosSQLite admin = new AdmBaseDatosSQLite(MainActivity.this,
                "Lukas", null, 1);
        //Abrimos la base de datos
        SQLiteDatabase baseDeDatos = admin.getReadableDatabase();

        // Creo un dato de tipo ContentValues que almacena los datos a insertar de cada objeto
        ContentValues registro = new ContentValues();

        // Inserto el jugador 1
        // registro.put("id", 1);
        registro.put("nombre","Lamine Yamal");
        registro.put("equipo","Barcelona");
        baseDeDatos.insert("futbolistas",null, registro);

        // Inserto el jugador 2
        // registro.put("id", 2);
        registro.put("nombre","Bellingham");
        registro.put("equipo","Real Madrid");
        baseDeDatos.insert("futbolistas",null, registro);

        // Inserto el jugador 3
        //registro.put("id", 3);
        registro.put("nombre","Griezmann");
        registro.put("equipo","Atletico");
        baseDeDatos.insert("futbolistas",null, registro);

        mensaje = findViewById(R.id.editTextTextPersonName);
        mensaje.setText("Futbolistas insertados");
    }

    public void consultarDatos(View view) {
        AdmBaseDatosSQLite admin = new AdmBaseDatosSQLite(MainActivity.this,
                "Lukas", null, 1);
        //Abrimos la base de datos
        SQLiteDatabase baseDeDatos = admin.getReadableDatabase();

        String query ="SELECT * from futbolistas";
        Cursor c = baseDeDatos.rawQuery(query,null);

        int j=0;
        while (c.moveToNext()) {
            @SuppressLint("Range") String name = c.getString(c.getColumnIndex("nombre"));
            @SuppressLint("Range") String team= c.getString(c.getColumnIndex("equipo"));
            System.out.println("El futbolista " + name + " juega en el equipo " + team);
            j++;
        }
        mensaje = findViewById(R.id.editTextTextPersonName);
        mensaje.setText("Hay "+ j + " registros");
    }
}