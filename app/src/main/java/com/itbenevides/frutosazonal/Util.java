package com.itbenevides.frutosazonal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.itbenevides.frutosazonal.dao.DAO;
import com.itbenevides.frutosazonal.dao.Epoca;
import com.itbenevides.frutosazonal.dao.Frutos;
import com.itbenevides.frutosazonal.dao.Mes;
import com.itbenevides.frutosazonal.dao.Tipofruto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Onnet on 27/10/2015.
 */
public class Util {

    private String nome;
    long codigoEpoca=1;
    long codigo=1;
    List<Frutos> frutas ;
    List<Mes> mes;
    List<Epoca> epocas;

    public void geraBancoFrutas(SQLiteDatabase sqlitedatabase){
        sqlitedatabase.beginTransaction();
    try {

        carregaTodasNivel1(sqlitedatabase);
        carregaTodasNivel2(sqlitedatabase);
        carregaTodasNivel3(sqlitedatabase);
        sqlitedatabase.setTransactionSuccessful();
    }catch (Exception e){

    }finally {
        sqlitedatabase.endTransaction();
    }

    }


    public List<Frutos> carregaTodasNivel1(SQLiteDatabase sqlitedatabase){


        frutas = new ArrayList<Frutos>();
        mes = new ArrayList<Mes>();
        epocas = new ArrayList<Epoca>();

        Tipofruto tipofruto = new Tipofruto();
        tipofruto.codigo=Tipofruto.CODIGO_FRUTA;
        tipofruto.descricao="Frutas";

        tipofruto.setId_(sqlitedatabase.insert(tipofruto.getTabela(), null, tipofruto.getContentValues()));

        Mes mesobj = new Mes();
        mesobj.codigo=1;
        mesobj.nome="Janeiro";
        mes.add(mesobj);
        for(String fruta:frutasJan){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=1;
                    epocas.add(epoca);
                    break;
                }
            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=1;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=2;
        mesobj.nome="Fevereiro";
        mes.add(mesobj);
        for(String fruta:frutasFev){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=1;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=1;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=3;
        mesobj.nome="Março";
        mes.add(mesobj);
        for(String fruta:frutasMar){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=1;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=1;
                epocas.add(epoca);
                frutas.add(f);
            }
        }

        mesobj = new Mes();
        mesobj.codigo=4;
        mesobj.nome="Abril";
        mes.add(mesobj);
        for(String fruta:frutasAbr){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=1;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=1;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=5;
        mesobj.nome="Maio";
        mes.add(mesobj);
        for(String fruta:frutasMai){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=1;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=1;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=6;
        mesobj.nome="Junho";
        mes.add(mesobj);
        for(String fruta:frutasJun){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=1;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=1;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=7;
        mesobj.nome="Julho";
        mes.add(mesobj);
        for(String fruta:frutasJul){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=1;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=1;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=8;
        mesobj.nome="Agosto";
        mes.add(mesobj);
        for(String fruta:frutasAgo){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=1;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=1;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=9;
        mesobj.nome="Setembro";
        mes.add(mesobj);
        for(String fruta:frutasSet){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=1;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=1;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=10;
        mesobj.nome="Outubro";
        mes.add(mesobj);
        for(String fruta:frutasOut){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=1;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=1;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=11;
        mesobj.nome="Novebro";
        mes.add(mesobj);
        for(String fruta:frutasNov){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=1;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=1;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=12;
        mesobj.nome="Dezembro";
        mes.add(mesobj);
        for(String fruta:frutasDez){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=1;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=1;
                epocas.add(epoca);
                frutas.add(f);
            }
        }



        for(Mes mes_:mes){

            mes_.setId_(sqlitedatabase.insert(mes_.getTabela(), null, mes_.getContentValues()));

        }



        return frutas;


    }




    public List<Frutos> carregaTodasNivel2(SQLiteDatabase sqlitedatabase){





         mes = new ArrayList<Mes>();



        Mes mesobj = new Mes();
        mesobj.codigo=1;
        mesobj.nome="JAN";
        mes.add(mesobj);
        for(String fruta:frutasMediaJan){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=2;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=2;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=2;
        mesobj.nome="FEV";
        mes.add(mesobj);
        for(String fruta:frutasMediaFev){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=2;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=2;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=3;
        mesobj.nome="MAR";
        mes.add(mesobj);
        for(String fruta:frutasMediaMar){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=2;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=2;
                epocas.add(epoca);
                frutas.add(f);
            }
        }

        mesobj = new Mes();
        mesobj.codigo=4;
        mesobj.nome="ABR";
        mes.add(mesobj);
        for(String fruta:frutasMediaAbr){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=2;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=2;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=5;
        mesobj.nome="MAI";
        mes.add(mesobj);
        for(String fruta:frutasMediaMai){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=2;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=2;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=6;
        mesobj.nome="JUN";
        mes.add(mesobj);
        for(String fruta:frutasMediaJun){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=2;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=2;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=7;
        mesobj.nome="JUL";
        mes.add(mesobj);
        for(String fruta:frutasMediaJul){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=2;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=2;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=8;
        mesobj.nome="AGO";
        mes.add(mesobj);
        for(String fruta:frutasMediaAgo){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=2;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=2;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=9;
        mesobj.nome="SET";
        mes.add(mesobj);
        for(String fruta:frutasMediaSet){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=2;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=2;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=10;
        mesobj.nome="OUT";
        mes.add(mesobj);
        for(String fruta:frutasMediaOut){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=2;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=2;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=11;
        mesobj.nome="NOV";
        mes.add(mesobj);
        for(String fruta:frutasMediaNov){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=2;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=2;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=12;
        mesobj.nome="DEZ";
        mes.add(mesobj);
        for(String fruta:frutasMediaDez){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=2;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=2;
                epocas.add(epoca);
                frutas.add(f);
            }
        }



        return frutas;


    }

    public List<Frutos> carregaTodasNivel3(SQLiteDatabase sqlitedatabase){





         mes = new ArrayList<Mes>();



        Mes mesobj = new Mes();
        mesobj.codigo=1;
        mesobj.nome="JAN";
        mes.add(mesobj);
        for(String fruta:frutasSemJan){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=3;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=3;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=2;
        mesobj.nome="FEV";
        mes.add(mesobj);
        for(String fruta:frutasSemFev){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=3;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=3;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=3;
        mesobj.nome="MAR";
        mes.add(mesobj);
        for(String fruta:frutasSemMar){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=3;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=3;
                epocas.add(epoca);
                frutas.add(f);
            }
        }

        mesobj = new Mes();
        mesobj.codigo=4;
        mesobj.nome="ABR";
        mes.add(mesobj);
        for(String fruta:frutasSemAbr){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=3;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=3;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=5;
        mesobj.nome="MAI";
        mes.add(mesobj);
        for(String fruta:frutasSemMai){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=3;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=3;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=6;
        mesobj.nome="JUN";
        mes.add(mesobj);
        for(String fruta:frutasSemJun){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=3;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=3;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=7;
        mesobj.nome="JUL";
        mes.add(mesobj);
        for(String fruta:frutasSemJul){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=3;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=3;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=8;
        mesobj.nome="AGO";
        mes.add(mesobj);
        for(String fruta:frutasSemAgo){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=3;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=3;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=9;
        mesobj.nome="SET";
        mes.add(mesobj);
        for(String fruta:frutasSemSet){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=3;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=3;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=10;
        mesobj.nome="OUT";
        mes.add(mesobj);
        for(String fruta:frutasSemOut){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=3;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=3;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=11;
        mesobj.nome="NOV";
        mes.add(mesobj);
        for(String fruta:frutasSemNov){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=3;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=3;
                epocas.add(epoca);
                frutas.add(f);
            }
        }
        mesobj = new Mes();
        mesobj.codigo=12;
        mesobj.nome="DEZ";
        mes.add(mesobj);
        for(String fruta:frutasSemDez){
            Boolean tem=false;
            for(Frutos frut: frutas){
                if(fruta.equalsIgnoreCase(frut.nome)){
                    tem=true;
                    Epoca epoca = new Epoca();
                    epoca.codigo=codigoEpoca++;
                    epoca.codigoMes=mesobj.codigo;
                    epoca.codigoFruta=frut.codigo;
                    epoca.nivel=3;
                    epocas.add(epoca);
                    break;
                }

            }
            if(!tem){
                Frutos f = new Frutos();
                f.nome=fruta;
                f.codigo=codigo++;
                Epoca epoca = new Epoca();
                epoca.codigo=codigoEpoca++;
                epoca.codigoMes=mesobj.codigo;
                epoca.codigoFruta=f.codigo;
                epoca.nivel=3;
                epocas.add(epoca);
                frutas.add(f);
            }
        }

        for(Frutos frutos:frutas){

            frutos.setId_(sqlitedatabase.insert(frutos.getTabela(), null, frutos.getContentValues()));


        }
        for(Epoca epoca:epocas){

            epoca.setId_(sqlitedatabase.insert(epoca.getTabela(), null, epoca.getContentValues()));

        }

        return frutas;


    }

    private String frutasJan[]=("ABACAXI HAVAI\n" +
            "CARAMBOLA\n" +
            "COCO VERDE\n" +
            "FIGO\n" +
            "FRAMBOESA\n" +
            "FR. DO CONDE/PINHA\n" +
            "LARANJA PERA\n" +
            "MAMÃO HAVAI (PAPAYA)\n" +
            "MARACUJÁ\n" +
            "MARMELO NACIONAL\n" +
            "MELANCIA\n" +
            "NECTARINA ESTRANG.\n" +
            "UVA RUBI").split("\n");

    private String frutasFev[]=("ABACATE\n" +
            "AMEIXA ESTRANGEIRA\n" +
            "AMÊNDOA\n" +
            "CARAMBOLA\n" +
            "COCO VERDE\n" +
            "FIGO\n" +
            "FRUTA DO CONDE/PINHA\n" +
            "GOIABA\n" +
            "JACA\n" +
            "LARANJA PERA\n" +
            "MAÇÃ NACIONAL\n" +
            "MAÇÃ NACIONAL GALA\n" +
            "PÊRA NACIONAL\n" +
            "PÊSSEGO ESTRANGEIRO\n" +
            "SERIGUELA\n" +
            "UVA ITÁLIA\n" +
            "UVA RUBI").split("\n");

    private String frutasMar[]=("ABACATE\n" +
            "ABACAXI PEROLA\n" +
            "AMEIXA ESTRANGEIRA\n" +
            "BANANA\n" +
            "BANANA MAÇÃ\n" +
            "BANANA NANICA\n" +
            "COCO VERDE\n" +
            "FIGO\n" +
            "FRUTA DO CONDE/PINHA\n" +
            "GOIABA\n" +
            "JACA\n" +
            "LARANJA PERA\n" +
            "LIMÃO\n" +
            "LIMÃO TAITI\n" +
            "MAÇÃ NACIONAL\n" +
            "MAÇÃ NACIONAL GALA\n" +
            "MAMÃO FORMOSA\n" +
            "MAMÃO HAVAI\n" +
            "MANGOSTÃO\n" +
            "NECTARINA ESTRANGEIRA\n" +
            "PÊRA NACIONAL\n" +
            "PÊRA ESTRANGEIRA\n" +
            "PÊSSEGO ESTRANGEIRO\n" +
            "SERIGUELA\n" +
            "TANGERINA CRAVO\n" +
            "UVA ITÁLIA\n" +
            "UVA RUBI\n" +
            "UVA ESTRANGEIRA").split("\n");

    private String frutasAbr[]=("ABACATE\n" +
            "AMEIXA ESTRANGEIRA\n" +
            "ATEMOIA\n" +
            "BANANA MAÇÃ\n" +
            "CAQUI\n" +
            "CIDRA\n" +
            "JACA\n" +
            "KIWI NACIONAL\n" +
            "MAÇÃ NACIONAL\n" +
            "MAÇÃ NACIONAL GALA\n" +
            "MAMÃO FORMOSA\n" +
            "PÊRA ESTRANGEIRA\n" +
            "TANGERINA CRAVO\n" +
            "UVA ESTRANGEIRA").split("\n");

    private String frutasMai[]=("ABACATE\n" +
            "ATEMOIA\n" +
            "BANANA MAÇÃ\n" +
            "CAQUI\n" +
            "JACA\n" +
            "KIWI NACIONAL\n" +
            "MAÇÃ NACIONAL\n" +
            "MAÇÃ NACIONAL GALA\n" +
            "PÊRA ESTRANGEIRA\n" +
            "QUINCAM\n" +
            "TANGERINA PONCAM\n" +
            "UVA ESTRANGEIRA").split("\n");

    private String frutasJun[]=("ATEMOIA\n" +
            "CARAMBOLA\n" +
            "KIWI NACIONAL\n" +
            "LARANJA LIMA\n" +
            "MANGOSTÃO\n" +
            "MARMELO ESTRANGEIRO\n" +
            "MEXERICA\n" +
            "QUINCAM\n" +
            "TANGERINA PONCAM").split("\n");

    private String frutasJul[]=("ATEMOIA\n" +
            "CARAMBOLA\n" +
            "GREAP FRUIT\n" +
            "KIWI NACIONAL\n" +
            "LARANJA LIMA\n" +
            "MEXERICA\n" +
            "QUINCAM\n" +
            "TANGERINA PONCAM").split("\n");

    private String frutasAgo[]=("ABIU\n" +
            "ATEMOIA\n" +
            "BANANA \n" +
            "BANANA NANICA\n" +
            "CAJU\n" +
            "CARAMBOLA\n" +
            "KIWI NACIONAL\n" +
            "KIWI ESTRANGEIRO\n" +
            "LARANJA\n" +
            "LARANJA LIMA\n" +
            "LARANJA PERA\n" +
            "LIMA DA PERSIA\n" +
            "MAÇÃ NACIONAL\n" +
            "MAMÃO FORMOSA\n" +
            "MEXERICA\n" +
            "MORANGO\n" +
            "QUINCAM\n" +
            "TANGERINA MURCOTE\n" +
            "TANGERINA PONCAM").split("\n");

    private String frutasSet[]=("ABACAXI PEROLA\n" +
            "ABIU\n" +
            "BANANA NANICA\n" +
            "CAJU\n" +
            "GREAP FRUIT\n" +
            "JABUTICABA\n" +
            "LARANJA\n" +
            "LARANJA LIMA\n" +
            "LARANJA PERA\n" +
            "MAÇÃ NACIONAL FUJI\n" +
            "MEXERICA\n" +
            "NÊSPERA\n" +
            "TAMARINDO\n" +
            "TANGERINA MURCOTE").split("\n");

    private String frutasOut[]=("ABACAXI PEROLA\n" +
            "ACEROLA\n" +
            "BANANA\n" +
            "BANANA NANICA\n" +
            "BANANA PRATA\n" +
            "CAJU\n" +
            "COCO VERDE\n" +
            "JABUTICABA\n" +
            "LARANJA\n" +
            "LARANJA PERA\n" +
            "LIMA DA PERSIA\n" +
            "MAÇÃ NACIONAL FUJI\n" +
            "MAÇÃ ESTRANG. RED DEL\n" +
            "MAMÃO HAVAI\n" +
            "MANGA\n" +
            "NÊSPERA\n" +
            "TANGERINA MURCOTE").split("\n");

    private String frutasNov[]=("ABACAXI PEROLA\n" +
            "ACEROLA\n" +
            "BANANA\n" +
            "BANANA NANICA\n" +
            "BANANA PRATA\n" +
            "CAJU\n" +
            "COCO VERDE\n" +
            "FRAMBOESA\n" +
            "GREAP FRUIT\n" +
            "JACA\n" +
            "LARANJA PERA\n" +
            "MAÇÃ NACIONAL FUJI\n" +
            "MAÇÃ ESTRANGEIRA\n" +
            "MAÇÃ ESTRANG. RED DEL\n" +
            "MAMÃO HAVAI\n" +
            "MANGA\n" +
            "MARACUJÁ\n" +
            "MELANCIA\n" +
            "MELÃO AMARELO\n" +
            "NECTARINA NACIONAL\n" +
            "NOZES\n" +
            "PÊSSEGO NACIONAL\n" +
            "TANGERINA MURCOTE").split("\n");

    private String frutasDez[]=("ABACAXI\n" +
            "ABACAXI HAVAI\n" +
            "ABACAXI PEROLA\n" +
            "AMEIXA ESTRANGEIRA\n" +
            "AMEIXA NACIONAL\n" +
            "AMÊNDOA\n" +
            "AVELÃ\n" +
            "BANANA PRATA\n" +
            "CASTANHA\n" +
            "CEREJA ESTRANGEIRA\n" +
            "COCO VERDE\n" +
            "DAMASCO ESTRANGEIRO\n" +
            "FIGO\n" +
            "FRAMBOESA\n" +
            "GRAVIOLA\n" +
            "KIWI ESTRANGEIRO\n" +
            "LARANJA PERA\n" +
            "LICHIA\n" +
            "LIMÃO\n" +
            "LIMÃO TAITI\n" +
            "MAÇÃ NACIONAL FUJI\n" +
            "MAÇÃ ESTRANGEIRA\n" +
            "MAÇÃ ESTRANG. GRANNY SMITH\n" +
            "MAÇÃ ESTRANG. RED DEL\n" +
            "MANGA\n" +
            "MARACUJÁ\n" +
            "MELANCIA\n" +
            "MELÃO AMARELO\n" +
            "NECTARINA ESTRANGEIRA\n" +
            "NECTARINA NACIONAL\n" +
            "NOZES\n" +
            "PÊSSEGO NACIONAL\n" +
            "PÊSSEGO ESTRANGEIRO\n" +
            "ROMÃ\n" +
            "UVA ITÁLIA\n" +
            "UVA NIAGARA\n" +
            "UVA RUBI").split("\n");



    private String frutasMediaJan[]=("ABACATE\n" +
            "ABACAXI\n" +
            "ABIU\n" +
            "ACEROLA\n" +
            "AMEIXA ESTRANGEIRA\n" +
            "AMEIXA NACIONAL\n" +
            "BANANA MAÇÃ\n" +
            "CAJU\n" +
            "CEREJA ESTRANGEIRA\n" +
            "GOIABA\n" +
            "JACA\n" +
            "LARANJA\n" +
            "LIMÃO\n" +
            "LIMÃO TAITI\n" +
            "MAÇÃ NACIONAL FUJI\n" +
            "MAÇÃ ESTRANGEIRA\n" +
            "MAÇÃ ESTR. RED DEL\n" +
            "MANGA\n" +
            "MELÃO AMARELO\n" +
            "PERA NACIONAL\n" +
            "PÊSSEGO NACIONAL\n" +
            "PÊSSEGO ESTRANGEIRO\n" +
            "ROMÃ\n" +
            "TANGERINA MURCOT\n" +
            "UVA ITÁLIA\n" +
            "UVA NIAGARA").split("\n");

    private String frutasMediaFev[]=("ABACAXI HAVAI\n" +
            "ABIU\n" +
            "ACEROLA\n" +
            "BANANA MAÇÃ\n" +
            "FRAMBOESA\n" +
            "LARANJA\n" +
            "LIMÃO\n" +
            "LIMÃO TAITI\n" +
            "MAMÃO HAVAI\n" +
            "MARMELO NACIONAL\n" +
            "MELANCIA\n" +
            "NECTARINA ESTRANGEIRA\n" +
            "PÊRA ESTRANGEIRA\n" +
            "UVA ESTRANGEIRA").split("\n");

    private String frutasMediaMar[]=("ABACAXI\n" +
            "ABACAXI HAVAI\n" +
            "ABIU\n" +
            "ACEROLA\n" +
            "ATEMOIA\n" +
            "BANANA PRATA\n" +
            "CAQUI\n" +
            "CARAMBOLA\n" +
            "CIDRA\n" +
            "FRAMBOESA\n" +
            "GRAVIOLA\n" +
            "LARANJA\n" +
            "LIMA DA PERSIA\n" +
            "MARACUJÁ\n" +
            "MELANCIA\n" +
            "QUINCAM").split("\n");

    private String frutasMediaAbr[]=("ABACAXI PEROLA\n" +
            "ABIU\n" +
            "ACEROLA\n" +
            "CARAMBOLA\n" +
            "FIGO\n" +
            "FRUTA DO CONDE/PINHA\n" +
            "GOIABA\n" +
            "GRAVIOLA\n" +
            "LARANJA LIMA\n" +
            "LIMA DA PERSIA\n" +
            "LIMÃO\n" +
            "LIMÃO TAITI\n" +
            "MAMÃO HAVAI\n" +
            "MARACUJÁ\n" +
            "MARMELO ESTRANGEIRO\n" +
            "MELANCIA\n" +
            "PÊRA NACIONAL\n" +
            "QUINCAM\n" +
            "TANGERINA PONCAM\n" +
            "UVA RUBI").split("\n");

    private String frutasMediaMai[]=("ABACAXI PEROLA\n" +
            "ABIU\n" +
            "ACEROLA\n" +
            "BANANA\n" +
            "BANANA PRATA\n" +
            "CARAMBOLA\n" +
            "FRUTA DO CONDE/PINHA\n" +
            "GREAP FRUIT\n" +
            "KIWI ESTRANGEIRO\n" +
            "LARANJA LIMA\n" +
            "MAMÃO FORMOSA\n" +
            "MARMELO ESTRANGEIRO\n" +
            "MEXERICA\n" +
            "TANGERINA CRAVO\n" +
            "UVA RUBI").split("\n");

    private String frutasMediaJun[]=("ABACATE\n" +
            "ABIU\n" +
            "BANANA MAÇÃ\n" +
            "CAJU\n" +
            "CAQUI\n" +
            "GREAP FRUIT\n" +
            "JACA\n" +
            "MAÇÃ NACIONAL\n" +
            "MAÇÃ NACIONAL GALA\n" +
            "MAMÃO FORMOSA\n" +
            "MORANGO\n" +
            "PÊRA ESTRANGEIRA\n" +
            "UVA RUBI").split("\n");

    private String frutasMediaJul[]=("ABACATE\n" +
            "ABIU\n" +
            "BANANA MAÇÃ\n" +
            "CAJU\n" +
            "KIWI ESTRANGEIRO\n" +
            "LARANJA\n" +
            "LIMA DA PERSIA\n" +
            "MAÇÃ NACIONAL\n" +
            "MAÇÃ NACIONAL FUJI\n" +
            "MAÇÃ NACIONAL GALA\n" +
            "MAÇÃ ESTRANGEIRA\n" +
            "MAÇÃ ESTRANGEIRA RED DEL\n" +
            "MANGOSTÃO\n" +
            "MORANGO\n" +
            "NÊSPERA\n" +
            "PÊRA ESTRANGEIRA\n" +
            "PêSSEGO ESTRANGEIRO").split("\n");

    private String frutasMediaAgo[]=("ABACATE\n" +
            "ABACAXI PEROLA\n" +
            "BANANA MAÇÃ\n" +
            "BANANA PRATA\n" +
            "CIDRA\n" +
            "GOIABA\n" +
            "MAÇÃ NACIONAL FUJI\n" +
            "MAÇÃ NACIONAL GALA\n" +
            "MAÇÃ ESTRANGEIRA\n" +
            "MAÇÃ ESTRANGEIRA RED DEL\n" +
            "MARACUJÁ\n" +
            "NECTARINA ESTRANGEIRA\n" +
            "NÊSPERA\n" +
            "TAMARINDO").split("\n");

    private String frutasMediaSet[]=("ABACATE\n" +
            "AMÊNDOA\n" +
            "ATEMOIA\n" +
            "BANANA\n" +
            "BANANA PRATA\n" +
            "CARAMBOLA\n" +
            "CIDRA\n" +
            "COCO VERDE\n" +
            "GOIABA\n" +
            "KIWI NACIONAL\n" +
            "KIWI ESTRANGEIRO\n" +
            "LIMA DA PERSIA\n" +
            "MAÇÃ NACIONAL\n" +
            "MAÇÃ NACIONAL GALA\n" +
            "MAÇÃ ESTRANGEIRA\n" +
            "MAÇÃ ESTRANG. RED DEL\n" +
            "MAMÃO FORMOSA\n" +
            "MAMÃO HAVAI\n" +
            "MANGA\n" +
            "MARACUJÁ\n" +
            "MELÃO AMARELO\n" +
            "MORANGO\n" +
            "PÊRA ESTRANGEIRA\n" +
            "QUINCAM").split("\n");

    private String frutasMediaOut[]=("ABACATE\n" +
            "ABACAXI\n" +
            "ABIU\n" +
            "AMEIXA ESTRANGEIRA\n" +
            "ATEMOIA\n" +
            "GOIABA\n" +
            "GREAP FRUIT\n" +
            "JACA\n" +
            "KIWI NACIONAL\n" +
            "LARANJA LIMA\n" +
            "MAÇÃ NACIONAL\n" +
            "MAÇÃ ESTRANGEIRA\n" +
            "MAÇÃ ESTRANG. GRANNY SMITH\n" +
            "MAMÃO FORMOSA\n" +
            "MARACUJÁ\n" +
            "MELANCIA\n" +
            "MELÃO AMARELO\n" +
            "MEXERICA\n" +
            "MORANGO\n" +
            "NECTARINA NACIONAL\n" +
            "PÊSSEGO NACIONAL\n" +
            "QUINCAM\n" +
            "TAMARINDO").split("\n");

    private String frutasMediaNov[]=("ABACAXI\n" +
            "ABACAXI HAVAI\n" +
            "AMEIXA NACIONAL\n" +
            "AMÊNDOA\n" +
            "CASTANHA\n" +
            "GRAVIOLA\n" +
            "KIWI ESTRANGEIRO\n" +
            "LARANJA\n" +
            "LICHIA\n" +
            "LIMA DA PERSIA\n" +
            "PÊSSEGO ESTRANGEIRO").split("\n");

    private String frutasMediaDez[]=("ACEROLA\n" +
            "CAJU\n" +
            "CARAMBOLA\n" +
            "CIDRA\n" +
            "JACA\n" +
            "LARANJA\n" +
            "MAMÃO HAVAI\n" +
            "MARMELO NACIONAL\n" +
            "TANGERINA MURCOTE").split("\n");




    private String frutasSemJan[]=("ABACAXI PEROLA\n" +
            "AMÊNDOA\n" +
            "ATEMÓIA\n" +
            "AVELÃ\n" +
            "BANANA\n" +
            "BANANA NANICA\n" +
            "BANANA PRATA\n" +
            "CAQUI\n" +
            "CASTANHA\n" +
            "CIDRA\n" +
            "DAMASCO ESTRANGEIRO\n" +
            "GRAVIOLA\n" +
            "GRAPE FRUIT\n" +
            "JABUTICABA\n" +
            "KIWI NACIONAL\n" +
            "KIWI ESTRANGEIRO\n" +
            "LARANJA LIMA\n" +
            "LICHIA\n" +
            "LIMA DA PERSIA\n" +
            "MAÇÃ NACIONAL\n" +
            "MAÇÃ NACIONAL GALA\n" +
            "MAÇÃ ESTRAN. GRANNY SMITH\n" +
            "MAMÃO FORMOSA\n" +
            "MANGOSTÃO\n" +
            "MARMELO ESTRANGEIRO\n" +
            "MEXERICA\n" +
            "MORANGO\n" +
            "NECTARINA NACIONAL\n" +
            "NÊSPERA\n" +
            "NOZES\n" +
            "PÊRA ESTRANGEIRA\n" +
            "QUINCAM\n" +
            "SERIGUELA\n" +
            "TAMARINDO\n" +
            "TANGERINA CRAVO\n" +
            "TANGERINA PONCAM\n" +
            "UVA ESTRANGEIRA").split("\n");

    private String frutasSemFev[]=("ABACAXI\n" +
            "ABACAXI PEROLA\n" +
            "AMEIXA NACIONAL\n" +
            "ATEMOIA\n" +
            "AVELÃ\n" +
            "BANANA\n" +
            "BANANA NANICA\n" +
            "BANANA PRATA\n" +
            "CAJU\n" +
            "CAQUI\n" +
            "CASTANHA\n" +
            "CEREJA ESTRANGEIRA\n" +
            "CIDRA\n" +
            "DAMASCO ESTRANGEIRO\n" +
            "GRAVIOLA\n" +
            "GREAP FRUIT\n" +
            "JABUTICABA\n" +
            "KIWI NACIONAL\n" +
            "KIWI ESTRANGEIRO\n" +
            "LARANJA LIMA\n" +
            "LICHIA\n" +
            "LIMA DA PERSIA\n" +
            "MAÇÃ NACIONAL FUJI\n" +
            "MAÇÃ ESTRANGEIRA\n" +
            "MAÇÃ ESTRANGEIRA GRANNY SMITH\n" +
            "MAÇÃ ESTRANGEIRA RED DEL\n" +
            "MAMÃO FORMOSA\n" +
            "MANGA\n" +
            "MANGOSTÃO\n" +
            "MARACUJÁ\n" +
            "MARMELO ESTRANGEIRO\n" +
            "MELÃO AMARELO\n" +
            "MEXERICA\n" +
            "MORANGO\n" +
            "NECTARINA NACIONAL\n" +
            "NESPERA\n" +
            "NOZES\n" +
            "PÊSSEGO NACIONAL\n" +
            "QUINCAM\n" +
            "ROMÃ\n" +
            "TAMARINDO\n" +
            "TANGERINA CRAVO\n" +
            "TANGERINA MURCOTE\n" +
            "TANGERINA PONCAM\n" +
            "UVA NIAGARA").split("\n");

    private String frutasSemMar[]=("AMEIXA NACIONAL\n" +
            "AMÊNDOA\n" +
            "AVELÃ\n" +
            "CAJU\n" +
            "CASTANHA\n" +
            "CEREJA ESTRANGEIRA\n" +
            "DAMASCO ESTRANGEIRO\n" +
            "GREAP FRUIT\n" +
            "JABUTICABA\n" +
            "KIWI NACIONAL\n" +
            "KIWI ESTRANGEIRO\n" +
            "LARANJA LIMA\n" +
            "LICHIA\n" +
            "MAÇÃ NACIONAL FUJI\n" +
            "MAÇÃ ESTRANGEIRA\n" +
            "MAÇÃ ESTRANG. GRANNY SMITH\n" +
            "MAÇÃ ESTRANG. RED DEL\n" +
            "MANGA\n" +
            "MARMELO NACIONAL\n" +
            "MARMELO ESTRANGEIRO\n" +
            "MELÃO AMARELO\n" +
            "MEXERICA\n" +
            "MORANGO\n" +
            "NECTARINA NACIONAL\n" +
            "NÊSPERA\n" +
            "NOZES\n" +
            "PÊSSEGO NACIONAL\n" +
            "ROMÃ\n" +
            "TAMARINDO\n" +
            "TANGERINA MURCOTE\n" +
            "TANGERINA PONCAM\n" +
            "UVA NIAGARA").split("\n");

    private String frutasSemAbr[]=("ABACAXI\n" +
            "ABACAXI HAVAI\n" +
            "AMEIXA NACIONAL\n" +
            "AMÊNDOA\n" +
            "AVELÃ\n" +
            "BANANA\n" +
            "BANANA NANICA\n" +
            "BANANA PRATA\n" +
            "CAJU\n" +
            "CASTANHA\n" +
            "CEREJA ESTRANGEIRA\n" +
            "COCO VERDE\n" +
            "DAMASCO ESTRANGEIRO\n" +
            "FRAMBOESA\n" +
            "GREAP FRUIT\n" +
            "JABUTICABA\n" +
            "KIWI ESTRANGEIRO\n" +
            "LARANJA\n" +
            "LARANJA PERA\n" +
            "LICHIA\n" +
            "MAÇÃ NACIONAL FUJI\n" +
            "MAÇÃ ESTRANGEIRA\n" +
            "MAÇÃ ESTRANG. GRANNY SMITH\n" +
            "MAÇÃ ESTRANG. RED DEL\n" +
            "MANGA\n" +
            "MANGOSTÃO\n" +
            "MARMELO NACIONAL\n" +
            "MELÃO AMARELO\n" +
            "MEXERICA\n" +
            "MORANGO\n" +
            "NECTARINA  ESTRANGEIRA\n" +
            "NECTARINA NACIONAL\n" +
            "NÊSPERA\n" +
            "NOZES\n" +
            "PÊSSEGO NACIONAL\n" +
            "PÊSSEGO ESTRANGEIRO\n" +
            "ROMÃ\n" +
            "SERIGUELA\n" +
            "TAMARINDO\n" +
            "TANGERINA MURCOTE\n" +
            "UVA ITÁLIA\n" +
            "UVA NIAGARA").split("\n");

    private String frutasSemMai[]=("ABACAXI\n" +
            "ABACAXI HAVAI\n" +
            "AMEIXA ESTRANGEIRA\n" +
            "AMEIXA NACIONAL\n" +
            "AMÊNDOA\n" +
            "AVELÃ\n" +
            "BANANA NANICA\n" +
            "CAJU\n" +
            "CASTANHA\n" +
            "CEREJA ESTRANGEIRA\n" +
            "CIDRA\n" +
            "COCO VERDE\n" +
            "DAMASCO ESTRANGEIRO\n" +
            "FIGO\n" +
            "FRAMBOESA\n" +
            "GOIABA\n" +
            "GRAVIOLA\n" +
            "JABUTICABA\n" +
            "LARANJA\n" +
            "LARANJA PERA\n" +
            "LICHIA\n" +
            "LIMA DA PERSIA\n" +
            "LIMÃO\n" +
            "LIMÃO TAITI\n" +
            "MAÇA NACIONAL FUJI\n" +
            "MAÇA ESTRANGEIRA\n" +
            "MAÇÃ ESTRANGEIRA GRANNY SMITH\n" +
            "MAÇÃ ESTRANGEIRA RED DEL\n" +
            "MAMÃO HAVAI\n" +
            "MANGA\n" +
            "MANGOSTÃO\n" +
            "MARACUJÁ\n" +
            "MARMELO NACIONAL\n" +
            "MELANCIA\n" +
            "MELÃO AMARELO\n" +
            "MORANGO\n" +
            "NECTARINA ESTRANGEIRA\n" +
            "NECTARINA NACIONAL\n" +
            "NÊSPERA\n" +
            "NOZES\n" +
            "PÊRA NACIONAL\n" +
            "PÊSSEGO NACIONAL\n" +
            "PÊSSEGO ESTRANGEIRO\n" +
            "ROMÃ\n" +
            "SERIGUELA\n" +
            "TAMARINDO\n" +
            "TANGERINA MURCOTE\n" +
            "UVA ITÁLIA\n" +
            "UVA NIAGARA").split("\n");

    private String frutasSemJun[]=("ABACAXI\n" +
            "ABACAXI HAVAI\n" +
            "ABACAXI PEROLA\n" +
            "ACEROLA\n" +
            "AMEIXA ESTRANGEIRA\n" +
            "AMEIXA NACIONAL\n" +
            "AMÊNDOA\n" +
            "AVELÃ\n" +
            "BANANA\n" +
            "BANANA NANICA\n" +
            "BANANA PRATA\n" +
            "CASTANHA\n" +
            "CEREJA ESTRANGEIRA\n" +
            "CIDRA\n" +
            "COCO VERDE\n" +
            "DAMASCO ESTRANGEIRO\n" +
            "FIGO\n" +
            "FRAMBOESA\n" +
            "FRUTA DO CONDE/ PINHA\n" +
            "GOIABA\n" +
            "GRAVIOLA\n" +
            "JABUTICABA\n" +
            "KIWI ESTRANGEIRO\n" +
            "LARANJA\n" +
            "LARANJA PÊRA\n" +
            "LICHIA\n" +
            "LIMA DA PERSIA\n" +
            "LIMÃO\n" +
            "LIMÃO TAITI\n" +
            "MAÇÃ NACIONAL FUJI\n" +
            "MAÇÃ ESTRANGEIRA\n" +
            "MAÇÃ ESTRANGEIRA GRANNY SMITH\n" +
            "MAÇÃ ESTRANGEIRA RED DEL\n" +
            "MAMÃO HAVAI\n" +
            "MANGA\n" +
            "MARACUJÁ\n" +
            "MARMELO NACIONAL\n" +
            "MELANCIA\n" +
            "MELÃO AMARELO\n" +
            "NECTARINA ESTRANGEIRA\n" +
            "NECTARINA NACIONAL\n" +
            "NÊSPERA\n" +
            "NOZES\n" +
            "PÊRA NACIONAL\n" +
            "PÊSSEGO NACIONAL\n" +
            "PÊSSEGO ESTRANGEIRO\n" +
            "ROMÃ\n" +
            "SERIGUELA \n" +
            "TAMARINDO\n" +
            "TANGERINA CRAVO\n" +
            "TANGERINA MURCOTE\n" +
            "UVA ITÁLIA\n" +
            "UVA NIAGARA\n" +
            "UVA ESTRANGEIRA").split("\n");

    private String frutasSemJul[]=("ABACAXI\n" +
            "ABACAXI HAVAI\n" +
            "ABACAXI PEROLA\n" +
            "ACEROLA\n" +
            "AMEIXA ESTRANGEIRA\n" +
            "AMEIXA NACIONAL\n" +
            "AMENDOA\n" +
            "AVELÃ\n" +
            "BANANA\n" +
            "BANANA NANICA\n" +
            "BANANA PRATA\n" +
            "CAQUI\n" +
            "CASTANHA\n" +
            "CEREJA ESTRANGEIRA\n" +
            "CIDRA\n" +
            "COCO VERDE\n" +
            "DAMASCO ESTRANGEIRO\n" +
            "FIGO\n" +
            "FRAMBOESA\n" +
            "FRUTA DO CONDE/PINHA\n" +
            "GOIABA\n" +
            "GRAVIOLA\n" +
            "JABUTICABA\n" +
            "JACA\n" +
            "LARANJA PERA\n" +
            "LICHIA\n" +
            "LIMÃO\n" +
            "LIMÃO TAITI\n" +
            "MAÇÃ STRANGEIRA GRANNY SMITH\n" +
            "MAMÃO FORMOSA\n" +
            "MAMÃO HAVAI\n" +
            "MANGA\n" +
            "MARACUJA\n" +
            "MARMELO NACIONAL\n" +
            "MARMELO ESTRANGEIRO\n" +
            "MELANCIA\n" +
            "MELÃO AMARELO\n" +
            "NECTARINA ESTRANGEIRA\n" +
            "NECTARINA NACIONAL\n" +
            "NOZES \n" +
            "PÊRA NACIONAL\n" +
            "PÊSSEGO NACIONAL\n" +
            "ROMÃ\n" +
            "SERIGUELA\n" +
            "TAMARINDO\n" +
            "TANGERINA CRAVO\n" +
            "TANGERINA MURCOTE\n" +
            "UVA ITALIA\n" +
            "UVA NIAGARA\n" +
            "UVA RUBI\n" +
            "UVA ESTRANGEIRA").split("\n");

    private String frutasSemAgo[]=("ABACAXI\n" +
            "ABACAXI HAVAI\n" +
            "ACEROLA\n" +
            "AMEIXA ESTRANGEIRA\n" +
            "AMEIXA NACIONAL\n" +
            "AMÊNDOA\n" +
            "AVELÃ\n" +
            "CAQUI\n" +
            "CASTANHA\n" +
            "CEREJA ESTRANGEIRA\n" +
            "COCO VERDE\n" +
            "DAMASCO ESTRANGEIRO\n" +
            "FIGO\n" +
            "FRAMBOESA\n" +
            "FRUTA DO CONDE/PINHA\n" +
            "GRAVIOLA\n" +
            "GREAP FRUIT\n" +
            "JABUTICABA\n" +
            "JACA\n" +
            "LICHIA\n" +
            "LIMÃO\n" +
            "LIMÃO TAITI\n" +
            "MAÇÃ ESTRANGEIRA GRANNY SMTH\n" +
            "MAMÃO HAVAI\n" +
            "MANGA\n" +
            "MANGOSTÃO\n" +
            "MARMELO NACIONAL\n" +
            "MARMELO ESTRANGEIRO\n" +
            "MELANCIA\n" +
            "MELÃO AMARELO\n" +
            "NECTARINA NACIONAL\n" +
            "NOZES\n" +
            "PÊRA NACIONAL\n" +
            "PÊRA ESTRANGEIRA\n" +
            "PÊSSEGO NACIONAL\n" +
            "PÊSSEGO ESTRANGEIRO\n" +
            "ROMÃ\n" +
            "SERIGUELA\n" +
            "TANGERINA CRAVO\n" +
            "UVA ITÁLIA\n" +
            "UVA NIAGARA\n" +
            "UVA RUBI\n" +
            "UVA ESTRANGEIRA").split("\n");

    private String frutasSemSet[]=("ABACAXI\n" +
            "ABACAXI HAVAI\n" +
            "ACEROLA\n" +
            "AMEIXA ESTRANGEIRA\n" +
            "AMEIXA NACIONAL\n" +
            "AVELÃ\n" +
            "BANANA MAÇÃ\n" +
            "CAQUI\n" +
            "CASTANHA\n" +
            "CEREJA ESTRANGEIRA\n" +
            "DAMASCO ESTRANGEIRO\n" +
            "FIGO\n" +
            "FRAMBOESA\n" +
            "FRUTA DO CONDE/PINHA\n" +
            "GRAVIOLA\n" +
            "JACA\n" +
            "LICHIA\n" +
            "LIMÃO\n" +
            "LIMÃO TAITI\n" +
            "MAÇÃ ESTRANG. GRANNY SMITH\n" +
            "MANGOSTÃO\n" +
            "MARMELO NACIONAL\n" +
            "MARMELO ESTRANGEIRO\n" +
            "MELANCIA\n" +
            "NECTARINA ESTRANGEIRA\n" +
            "NECTARINA NACIONAL\n" +
            "NOZES\n" +
            "PÊRA NACIONAL\n" +
            "PÊSSEGO NACIONAL\n" +
            "PÊSSEGO ESTRANGEIRO\n" +
            "ROMÃ\n" +
            "SERIGUELA\n" +
            "TANGERINA CRAVO\n" +
            "TANGERINA PONCAM\n" +
            "UVA ITÁLIA\n" +
            "UVA NIAGARA\n" +
            "UVA RUBI\n" +
            "UVA ESTRANGEIRA").split("\n");

    private String frutasSemOut[]=("ABACAXI HAVAI\n" +
            "AMEIXA NACIONAL\n" +
            "AMÊNDOA\n" +
            "AVELÃ\n" +
            "BANANA MAÇÃ\n" +
            "CAQUI\n" +
            "CARAMBOLA\n" +
            "CASTANHA\n" +
            "CEREJA ESTRANGEIRA\n" +
            "CIDRA\n" +
            "DAMASCO ESTRANGEIRO\n" +
            "FIGO\n" +
            "FRAMBOESA\n" +
            "FRUTA DO CONDE/PINHA\n" +
            "GRAVIOLA\n" +
            "KIWI ESTRANGEIRO\n" +
            "LICHIA\n" +
            "LIMÃO\n" +
            "LIMÃO TAITI\n" +
            "MAÇÃ NACIONAL GALA\n" +
            "MANGOSTÃO\n" +
            "MARMELO NACIONAL\n" +
            "MARMELO ESTRANGEIRO\n" +
            "NECTARINA ESTRANGEIRA\n" +
            "NOZES\n" +
            "PÊRA NACIONAL\n" +
            "PÊRA ESTRANGEIRA\n" +
            "PÊSSEGO ESTRANGEIRO\n" +
            "ROMÃ\n" +
            "SERIGUELA\n" +
            "TANGERINA CRAVO\n" +
            "TANGERINA PONCAM\n" +
            "UVA ITÁLIA\n" +
            "UVA NIAGARA\n" +
            "UVA RUBI\n" +
            "UVA ESTRANGEIRA").split("\n");

    private String frutasSemNov[]=("ABACATE\n" +
            "ABIU\n" +
            "AMEIXA ESTRANGEIRA\n" +
            "ATEMOIA\n" +
            "AVELÃ\n" +
            "BANANA MAÇÃ\n" +
            "CAQUI\n" +
            "CARAMBOLA\n" +
            "CEREJA ESTRANGEIRA\n" +
            "CIDRA\n" +
            "DAMASCO ESTRANGEIRO\n" +
            "FIGO\n" +
            "FRUTA DO CONDE/PINHA\n" +
            "GOIABA\n" +
            "JABUTICABA\n" +
            "KIWI NACIONAL\n" +
            "LARANJA LIMA\n" +
            "LIMÃO\n" +
            "LIMÃO TAITI\n" +
            "MAÇÃ NACIONAL\n" +
            "MAÇÃ NACIONAL GALA\n" +
            "MAÇÃ ESTRANG. GRANNY SMITH\n" +
            "MAMÃO FORMOSA\n" +
            "MANGOSTÃO\n" +
            "MARMELO NACIONAL\n" +
            "MARMELO ESTRANGEIRO\n" +
            "MEXERICA\n" +
            "MORANGO\n" +
            "NECTARINA ESTRANGEIRA\n" +
            "NÊSPERA\n" +
            "PÊRA NACIONAL\n" +
            "PÊRA ESTRANGEIRA\n" +
            "QUINCAM\n" +
            "ROMÃ\n" +
            "SERIGUELA\n" +
            "TAMARINDO\n" +
            "TANGERINA CRAVO\n" +
            "TANGERINA PONCAM\n" +
            "UVA ITÁLIA\n" +
            "UVA NIAGARA\n" +
            "UVA RUBI\n" +
            "UVA ESTRANGEIRA").split("\n");

    private String frutasSemDez[]=("ABACATE\n" +
            "ABIU\n" +
            "ATEMOIA\n" +
            "BANANA\n" +
            "BANANA MAÇÃ\n" +
            "BANANA NANICA\n" +
            "CAQUI\n" +
            "FRUTA DO CONDE/PINHA\n" +
            "GOIABA\n" +
            "GREAP FRUIT\n" +
            "JABUTICABA\n" +
            "KIWI NACIONAL\n" +
            "LARANJA LIMA\n" +
            "LIMA DA PERSIA\n" +
            "MAÇÃ NACIONAL\n" +
            "MAÇÃ NACIONAL GALA\n" +
            "MAMÃO FORMOSA\n" +
            "MANGOSTÃO\n" +
            "MARMELO ESTRANGEIRO\n" +
            "MEXERICA\n" +
            "MORANGO\n" +
            "NÊSPERA\n" +
            "PÊRA NACIONAL\n" +
            "PÊRA ESTRANGEIRA\n" +
            "QUINCAM\n" +
            "SERIGUELA\n" +
            "TAMARINDO\n" +
            "TANGERINA CRAVO\n" +
            "TANGERINA PONCAM\n" +
            "UVA ESTRANGEIRA").split("\n");





}
