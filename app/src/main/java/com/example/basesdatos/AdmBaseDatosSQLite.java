package com.example.basesdatos;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdmBaseDatosSQLite extends SQLiteOpenHelper {
    public AdmBaseDatosSQLite(@Nullable Runnable context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super((Context) context, name, factory, version);
    }
    public AdmBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public AdmBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE futbolistas(id INT PRIMARY KEY AUTOINCREMENT, nombre TEXT, equipo TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
