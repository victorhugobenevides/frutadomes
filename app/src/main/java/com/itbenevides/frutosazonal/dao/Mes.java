package com.itbenevides.frutosazonal.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Onnet on 27/10/2015.
 */
public class Mes   implements DAO.IDAO{
    public long codigo;
    public String nome;


    public Mes() {
        this.codigo=0;
        this.nome = "";

    }

    @Override
    public ContentValues getContentValues() {
        // TODO Auto-generated method stub
        ContentValues contentvalues = new ContentValues();


        contentvalues.put("nome", nome);

        return contentvalues;
    }


    public static void onCreate(SQLiteDatabase sqlitedatabase, int versao) {
        sqlitedatabase.execSQL("drop table if exists mes");
        String sql = "CREATE TABLE mes (codigo integer primary key" +
                ",nome text null)";

        sqlitedatabase.execSQL(sql);
    }

    public static List<Mes> consultar(DAO dao) {
        List<Mes> list = null;
        Cursor cursor = null;

        try {
            String sql = "select * from mes ";
            cursor = dao.getWritableDatabase().rawQuery(sql, null);

            list = new ArrayList<Mes>();
            while (cursor.moveToNext()) {
                list.add(carregar(cursor));
            }

        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return list;
    }


    private static Mes carregar(Cursor cursor) {
        Mes mes = new Mes();

        mes.setId_(cursor.getInt(0));
        mes.setNome(cursor.getString(1));


        return mes;
    }


    @Override
    public String getTabela() {
        return "mes";
    }

    @Override
    public long getId_() {
        return codigo;
    }

    @Override
    public void setId_(long id_) {
        this.codigo=id_;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
