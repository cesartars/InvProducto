package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class InvenBD extends SQLiteOpenHelper {


    private static final String NOMBRE_BD = "inven.bd";
    private static final int VERSION_BD = 1;
    private static final String TABLA_CURSOS = "CREATE TABLE INVENTARIO(CODIGO TEXT PRIMARY KEY, PRODUCTO TEXT, DUEÑO TEXT)";

    public InvenBD(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_CURSOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA_CURSOS);
        sqLiteDatabase.execSQL(TABLA_CURSOS);
    }

    public void agregarInventario(String codigo, String producto, String dueño) {

        SQLiteDatabase bd = getWritableDatabase();
        if (bd != null) {
            bd.execSQL("INSERT INTO INVENTARIO VALUES('" + codigo + "','" + producto + "','" + dueño + "')");
            bd.close();
        }
    }


    public List<CursoModelo> mostrarCurso() {
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM INVENTARIO", null);
        List<CursoModelo> inventario = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                inventario.add(new CursoModelo(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        return inventario;
    }

    public CursoModelo buscarCurso(CursoModelo inventario, String codigo) {
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM INVENTARIO WHERE CODIGO='" + codigo + "'", null);
        if (cursor.moveToFirst()) {
            do {
                inventario.setProducto(cursor.getString(1));
                inventario.setDueño(cursor.getString(2));

            } while (cursor.moveToNext());
        }
        return inventario;

    }


        public void editarInventario(String codigo, String producto, String dueño) {
            SQLiteDatabase bd=getWritableDatabase();
            if (bd!=null){
                bd.execSQL("UPDATE INVENTARIO SET PRODUCTO='"+producto+"',DUEÑO='"+dueño+"' WHERE CODIGO='"+codigo+"'");
                bd.close();
            }
        }

        public void eliminarInventario(String codigo){

            SQLiteDatabase bd=getWritableDatabase();
            if (bd!=null){
                bd.execSQL("DELETE FROM INVENTARIO WHERE CODIGO='"+codigo+"'");
                bd.close();
            }
        }

    }






