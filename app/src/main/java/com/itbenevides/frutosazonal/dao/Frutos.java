package com.itbenevides.frutosazonal.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class Frutos implements DAO.IDAO,Cloneable {

    public long codigo;
    public String nome;
    public int codigotipo;
    public Frutos() {
        this.codigo=0;
        this.nome = "";
        this.codigotipo=1;
    }

    @Override
    public ContentValues getContentValues() {
        // TODO Auto-generated method stub
        ContentValues contentvalues = new ContentValues();


        contentvalues.put("nome", nome);
        contentvalues.put("codigotipo", codigotipo);

        return contentvalues;
    }

    public static List<Frutos> consultar(DAO dao,String codigotipo,String filtroepoca,String tipofruto,String tiposafra) {
        List<Frutos> list = null;
        Cursor cursor = null;

        try {
            String sql = "select * from frutos " +
                    "inner join epoca on epoca.codigoFruta=frutos.codigo " +
                    "inner join mes on mes.codigo = epoca.codigoMes " +
                    "where frutos.codigotipo='"+codigotipo+"'";

            if(tiposafra.equals("Alta")){
                sql=sql+"  and epoca.nivel = '1' ";
            }else if(tiposafra.equals("Média")){
                sql=sql+"  and epoca.nivel = '2' ";
            }else if(tiposafra.equals("Sem safra")){
                sql=sql+"  and epoca.nivel = '3' ";
            }else{
                sql=sql+"  and epoca.nivel != '3' ";
            }

            if(!tipofruto.equals(String.valueOf(Tipofruto.CODIGO_TODOS))){
                sql=sql+" and frutos.codigotipo='"+tipofruto+"'  ";
            }

            if(filtroepoca.equalsIgnoreCase("todos")){
                sql=sql+" GROUP BY frutos.codigo order by frutos.nome";
            }else{
                sql=sql+" and mes.nome='"+filtroepoca+"'  GROUP BY frutos.codigo order by frutos.nome ";
            }

            cursor = dao.getWritableDatabase().rawQuery(sql, null);

            list = new ArrayList<Frutos>();
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


    public static void onCreate(SQLiteDatabase sqlitedatabase, int versao) {
        sqlitedatabase.execSQL("drop table if exists frutos");
        String sql = "CREATE TABLE frutos (codigo integer primary key" +
                ",nome text null" +
                ",codigotipo integer null)";

        sqlitedatabase.execSQL(sql);
    }
    private static Frutos carregar(Cursor cursor) {
        Frutos fruto = new Frutos();

        fruto.setId_(cursor.getInt(0));
        fruto.setNome(cursor.getString(1));
        fruto.setCodigotipo(cursor.getInt(2));

        return fruto;
    }

    @Override
    public String getTabela() {
        return "frutos";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public long getId_() {
        return codigo;
    }

    @Override
    public void setId_(long id_) {
        this.codigo=id_;
    }

    public int getCodigotipo() {
        return codigotipo;
    }

    public void setCodigotipo(int codigotipo) {
        this.codigotipo = codigotipo;
    }



}
