package com.itbenevides.frutosazonal.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Onnet on 28/10/2015.
 */
public class Tipofruto  implements DAO.IDAO{

    public long codigo;
    public String descricao;
    public static int CODIGO_TODOS=0;
    public static int CODIGO_FRUTA=1;
    public Tipofruto() {
        this.codigo=0;
        this.descricao="";
    }


    @Override
    public String getTabela() {
        return "tipofrutos";
    }

    @Override
    public long getId_() {
        return codigo;
    }

    @Override
    public void setId_(long id_) {
        this.codigo=id_;
    }

    @Override
    public ContentValues getContentValues() {
        // TODO Auto-generated method stub
        ContentValues contentvalues = new ContentValues();



        contentvalues.put("descricao", descricao);

        return contentvalues;
    }
    public static void onCreate(SQLiteDatabase sqlitedatabase, int versao) {
        sqlitedatabase.execSQL("drop table if exists tipofrutos");
        String sql = "CREATE TABLE tipofrutos (codigo integer primary key" +
                ",descricao text null)";

        sqlitedatabase.execSQL(sql);
    }

    private static Tipofruto carregar(Cursor cursor) {
        Tipofruto tfruto = new Tipofruto();

        tfruto.setId_(cursor.getInt(0));
        tfruto.setDescricao(cursor.getString(1));


        return tfruto;
    }

    public static List<Tipofruto> consultar(DAO dao) {
        List<Tipofruto> list = null;
        Cursor cursor = null;

        try {
            String sql = "select * from tipofrutos ";
            cursor = dao.getWritableDatabase().rawQuery(sql, null);

            list = new ArrayList<Tipofruto>();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
