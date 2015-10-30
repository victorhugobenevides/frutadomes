package com.itbenevides.frutosazonal;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.itbenevides.frutosazonal.dao.DAO;
import com.itbenevides.frutosazonal.dao.Epoca;
import com.itbenevides.frutosazonal.dao.Frutos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Onnet on 27/10/2015.
 */
public class frutaAdapterList extends RecyclerView.Adapter<frutaAdapterList.PersonViewHolder>  implements Filterable {
    private List<Frutos> frutos;
    private List<Frutos> frutosorig;
    private Context context;
    private int modo;

    public frutaAdapterList(List<Frutos> frutos, Context context,int modo) {
        this.frutos = frutos;
        this.context=context;
        this.modo=modo;
    }

    @Override
    public int getItemCount() {
        return frutos.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v=null;
        if(modo==1){
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_fruta, viewGroup, false);
        }else if(modo==2){
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_fruta2, viewGroup, false);
        }

        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {

        StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setFullSpan(true);
        personViewHolder.itemView.setLayoutParams(layoutParams);

        personViewHolder.frutanome.setText(frutos.get(i).nome);

        List<Epoca> epocas = Epoca.consultar(DAO.getHelper(context),String.valueOf(frutos.get(i).codigo),"1");
        String strepoca="";
        if(frutos.get(i).nome.equals("ABACAXI HAVAI")){
            strepoca="";
        }


        for(Epoca epoca:epocas){
            strepoca=strepoca+epoca.descricao.substring(0,3)+" ";
        }

        personViewHolder.frutaepoca.setText(strepoca);


        epocas = Epoca.consultar(DAO.getHelper(context),String.valueOf(frutos.get(i).codigo),"2");
        strepoca="";
        for(Epoca epoca:epocas){
            strepoca=strepoca+epoca.descricao.substring(0,3)+" ";
        }
        personViewHolder.frutaepocamedia.setText(strepoca);



        epocas = Epoca.consultar(DAO.getHelper(context),String.valueOf(frutos.get(i).codigo),"3");
        strepoca="";
        for(Epoca epoca:epocas){
            strepoca=strepoca+epoca.descricao.substring(0,3)+" ";
        }
        personViewHolder.frutaepocafora.setText(strepoca);



    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView frutanome;
        TextView frutaepoca;
        TextView frutaepocamedia;
        TextView frutaepocafora;
        ImageView frutafoto;




        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            frutanome = (TextView)itemView.findViewById(R.id.fruta_nome);
            frutaepoca = (TextView)itemView.findViewById(R.id.fruta_epoca);
            frutaepocamedia = (TextView)itemView.findViewById(R.id.fruta_epoca_media);
            frutafoto = (ImageView)itemView.findViewById(R.id.fruta_foto);
            frutaepocafora= (TextView)itemView.findViewById(R.id.fruta_fora_epoca);


        }
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {



            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                frutos.clear();
                frutos.addAll(((List<Frutos>) results.values));

                    notifyDataSetChanged();

            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults results = new FilterResults();
                ArrayList<Frutos> filtrosfrutos = new ArrayList<Frutos>();


                if(frutosorig==null){

                    frutosorig= new ArrayList<Frutos>(frutos);


                }




                String valor[] = constraint.toString().split("%&%");

                constraint = valor[0].toLowerCase();




                if (constraint == null || constraint.length() == 0) {
                    results.count = frutosorig.size();
                    results.values = frutosorig;

                    // set the Original result to return

                } else {





                    for (Frutos fruto:frutosorig) {

                        if (fruto.getNome().toLowerCase().contains(constraint.toString()))  {
                            filtrosfrutos.add(fruto);
                        }
                    }





                    results.count = filtrosfrutos.size();
                    results.values = filtrosfrutos;


                }



                return results;
            }
        };

        return filter;
    }


}
