package com.itbenevides.frutosazonal.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Onnet on 27/10/2015.
 */
public class Epoca  implements DAO.IDAO{


    public long codigo;
    public long codigoMes;
    public long codigoFruta;
    public int nivel;
    public String descricao;
    public Epoca() {
        this.codigo=0;
        this.codigoMes=0;
        this.codigoFruta=0;
        this.nivel=0;
        this.descricao="";
    }

    @Override
    public ContentValues getContentValues() {
        // TODO Auto-generated method stub
        ContentValues contentvalues = new ContentValues();


        contentvalues.put("codigoMes", codigoMes);
        contentvalues.put("codigoFruta", codigoFruta);
        contentvalues.put("nivel", nivel);
        return contentvalues;
    }
    @Override
    public String getTabela() {
        // TODO Auto-generated method stub
        return "epoca";
    }

    @Override
    public long getId_() {
        return codigo;
    }

    @Override
    public void setId_(long id_) {
        this.codigo=id_;
    }

    public static void onCreate(SQLiteDatabase sqlitedatabase, int versao) {
        sqlitedatabase.execSQL("drop table if exists epoca");
        String sql = "CREATE TABLE epoca (codigo integer primary key" +
                ",codigoMes   integer null" +
                ",codigoFruta integer null" +
                ",nivel integer null)";

        sqlitedatabase.execSQL(sql);
    }

    public static List<Epoca> consultar(DAO dao,String codigo,String nivel) {
        List<Epoca> list = null;
        Cursor cursor = null;

        try {
            String sql = "select epoca.*,mes.nome from epoca inner join mes on epoca.codigoMes=mes.codigo where epoca.codigoFruta='"+codigo+"' and epoca.nivel = '"+nivel+"'";
            cursor = dao.getWritableDatabase().rawQuery(sql, null);

            list = new ArrayList<Epoca>();
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


    private static Epoca carregar(Cursor cursor) {
        Epoca epoca = new Epoca();

        epoca.setId_(cursor.getInt(0));
        epoca.setCodigoMes(cursor.getInt(1));
        epoca.setCodigoFruta(cursor.getInt(2));
        epoca.setNivel(cursor.getInt(3));
        epoca.setDescricao(cursor.getString(4));
        return epoca;
    }


    public long getCodigoMes() {
        return codigoMes;
    }

    public void setCodigoMes(long codigoMes) {
        this.codigoMes = codigoMes;
    }

    public long getCodigoFruta() {
        return codigoFruta;
    }

    public void setCodigoFruta(long codigoFruta) {
        this.codigoFruta = codigoFruta;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
