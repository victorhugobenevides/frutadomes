package com.itbenevides.frutosazonal;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;

import android.os.Bundle;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.itbenevides.frutosazonal.dao.DAO;
import com.itbenevides.frutosazonal.dao.Frutos;
import com.itbenevides.frutosazonal.dao.Mes;
import com.itbenevides.frutosazonal.dao.Tipofruto;
import com.twotoasters.jazzylistview.effects.SlideInEffect;
import com.twotoasters.jazzylistview.recyclerview.JazzyRecyclerViewScrollListener;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvFrutos;
    Spinner spmes;
    Spinner sptipo;
    Spinner spsafra;
    private Boolean isSpinnerTouchedmes = false;
    private Boolean isSpinnerTouchedtipo = false;
    private Boolean isSpinnerTouchedsafra = false;
    private static int modo= 1;
    public String strfiltro="";
    private AdView avPropaganda;
    //modo 1 list
    //modo 2 grid



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);

        (new ExportDatabaseFileTask()).execute();


        ImageView imvlist = (ImageView) findViewById(R.id.imv_list);
        ImageView imvgrid = (ImageView) findViewById(R.id.imv_grid);

        imvlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modo=1;
                carregaBancoLV carregaBanco=new carregaBancoLV(spmes.getSelectedItem().toString(),String.valueOf(((Tipofruto) sptipo.getSelectedItem()).codigo),spsafra.getSelectedItem().toString());
                carregaBanco.execute();
            }
        });

        imvgrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modo=2;
                carregaBancoLV carregaBanco=new carregaBancoLV(spmes.getSelectedItem().toString(),String.valueOf(((Tipofruto) sptipo.getSelectedItem()).codigo),spsafra.getSelectedItem().toString());
                carregaBanco.execute();
            }
        });




       carregaSpinner();







            carregaBancoLV carregaBanco=new carregaBancoLV(spmes.getSelectedItem().toString(),String.valueOf(((Tipofruto) sptipo.getSelectedItem()).codigo),spsafra.getSelectedItem().toString());
            carregaBanco.execute();




        avPropaganda = (AdView) findViewById(R.id.banner_app);
        inicializarAdListener(avPropaganda);
        requisitarPropaganda(getApplicationContext(),avPropaganda);




    }

    public void carregaSpinner(){


        List<Mes> mesList = Mes.consultar(DAO.getHelper(getApplicationContext()));

        Mes mes = new Mes();
        mes.setNome("Todos");

        mesList.add(0, mes);

        spmes = (Spinner) findViewById(R.id.spinner_mes);


        ArrayAdapter<Mes> adaptermes = new ArrayAdapter<Mes>(this,
                R.layout.item_spinner, mesList);

        spmes.setAdapter(adaptermes);


        spmes.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isSpinnerTouchedmes = true;
                return false;
            }
        });


        spmes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) spmes.getSelectedView()).setPadding(0,0,0,0);
                ((TextView) spmes.getSelectedView()).setTextColor(getResources().getColor(R.color.Branco));
                if (!isSpinnerTouchedmes) return;




                    carregaBancoLV carregaBanco=new carregaBancoLV(spmes.getSelectedItem().toString(),String.valueOf(((Tipofruto) sptipo.getSelectedItem()).codigo),spsafra.getSelectedItem().toString());
                    carregaBanco.execute();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        List<Tipofruto> tipofrutoList = Tipofruto.consultar(DAO.getHelper(getApplicationContext()));

        Tipofruto tipofruto = new Tipofruto();
        tipofruto.descricao="Todos";
        tipofruto.codigo=Tipofruto.CODIGO_TODOS;
        tipofrutoList.add(0,tipofruto);

        sptipo = (Spinner) findViewById(R.id.spinner_tipo);

        ArrayAdapter<Tipofruto> adaptertipo = new ArrayAdapter<Tipofruto>(this,
                R.layout.item_spinner, tipofrutoList);

        sptipo.setAdapter(adaptertipo);





        sptipo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isSpinnerTouchedtipo = true;
                return false;
            }
        });


        sptipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) sptipo.getSelectedView()).setPadding(0, 0, 0, 0);
                ((TextView) sptipo.getSelectedView()).setTextColor(getResources().getColor(R.color.Branco));
                if (!isSpinnerTouchedtipo) return;



                    carregaBancoLV carregaBanco=new carregaBancoLV(spmes.getSelectedItem().toString(),String.valueOf(((Tipofruto) sptipo.getSelectedItem()).codigo),spsafra.getSelectedItem().toString());
                    carregaBanco.execute();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        spsafra=(Spinner) findViewById(R.id.spinner_safra);

        List<String> lstSafra = new ArrayList<>();

        lstSafra.add("Todas");
        lstSafra.add("Alta");
        lstSafra.add("Média");
        lstSafra.add("Sem safra");

        ArrayAdapter<String> adaptersafra = new ArrayAdapter<String>(this,
                R.layout.item_spinner, lstSafra);

        spsafra.setAdapter(adaptersafra);


        spsafra.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isSpinnerTouchedsafra = true;
                return false;
            }
        });
        spsafra.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) spsafra.getSelectedView()).setPadding(0, 0, 0, 0);
                ((TextView) spsafra.getSelectedView()).setTextColor(getResources().getColor(R.color.Branco));
                if (!isSpinnerTouchedsafra) return;

                    carregaBancoLV carregaBanco=new carregaBancoLV(spmes.getSelectedItem().toString(),String.valueOf(((Tipofruto) sptipo.getSelectedItem()).codigo),spsafra.getSelectedItem().toString());
                    carregaBanco.execute();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public class carregaBancoLV extends AsyncTask<Integer, Integer, Void> {


        private ProgressDialog progressdialog;
        List<Frutos> frutos;
        String epocafiltro;
        String tipofruto;
        String tiposafra;


        public carregaBancoLV(String epocafiltro,String tipofruto,String tiposafra) {
            this.epocafiltro=epocafiltro;
            this.tipofruto=tipofruto;
            this.tiposafra=tiposafra;
        }



        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressdialog = new ProgressDialog(MainActivity.this);
            progressdialog.setMessage("Carregando dados...");
            progressdialog.setIndeterminate(true);
            progressdialog.setCancelable(false);
            progressdialog.setCanceledOnTouchOutside(false);
            progressdialog.show();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            rvFrutos = (RecyclerView)findViewById(R.id.rv);
            rvFrutos.setHasFixedSize(true);

            JazzyRecyclerViewScrollListener jazzyScrollListener = new JazzyRecyclerViewScrollListener();
            rvFrutos.setOnScrollListener(jazzyScrollListener);

            // LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());


            if(modo==1){
                LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
                rvFrutos.setLayoutManager(llm);
            }else if(modo==2){
                GridLayoutManager llm =  new GridLayoutManager(getApplicationContext(),2);
                rvFrutos.setLayoutManager(llm);
            }



            frutaAdapterList adapter = new frutaAdapterList(frutos,getApplicationContext(),modo);

            rvFrutos.setAdapter(adapter);



            ((frutaAdapterList)rvFrutos.getAdapter()).getFilter().filter(strfiltro);



            progressdialog.dismiss();
        }

        @Override
        protected Void doInBackground(Integer... integers) {


            frutos = Frutos.consultar(DAO.getHelper(getApplicationContext()), String.valueOf(Tipofruto.CODIGO_FRUTA),epocafiltro,tipofruto,tiposafra);
            return null;
        }
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        //Carrega o arquivo de menu.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.busca, menu);

        SearchView mSearchView = (SearchView) menu.findItem(R.id.search).getActionView();
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {


            @Override
            public boolean onQueryTextSubmit(String s) {

                s=s+"*&%"+spmes.getSelectedItem().toString();

                strfiltro=s;
                ((frutaAdapterList)rvFrutos.getAdapter()).getFilter().filter(s);
                return false;

            }

            @Override
            public boolean onQueryTextChange(String s) {

                s=s+"%&%"+spmes.getSelectedItem().toString();
                strfiltro=s;
                ((frutaAdapterList)rvFrutos.getAdapter()).getFilter().filter(s);

                return false;
            }
        });




        return true;
    }



    private class ExportDatabaseFileTask extends AsyncTask<String, Void, Boolean> {
        private final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        private boolean enviaBanco = false;

        // can use UI thread here
        protected void onPreExecute() {
            this.dialog.setMessage("Exportanto base de dados...");
            this.dialog.show();
        }

        public void setDados(boolean enviaBanco) {
            this.enviaBanco = enviaBanco;
        }

        // automatically done on worker thread (separate from UI thread)
        protected Boolean doInBackground(final String... args) {
            try {
                File dbFile = new File(Environment.getDataDirectory() + "/data/data/com.itbenevides.frutadomes/databases/frutossazon");


                File exportDir = new File(Environment.getExternalStorageDirectory(), "BKP");
                if (!exportDir.exists()) {
                    exportDir.mkdirs();
                }
                File file = new File(exportDir, dbFile.getName());

                try {
                    file.createNewFile();
                    this.copyFile(dbFile, file);
//				return true;
                } catch (IOException e) {
                    //Log.e(MyApplication.APP_NAME, e.getMessage(), e);
                    return false;
                }




            }catch (Exception e){
                return false;

            }




            return true;
        }

        // can use UI thread here
        protected void onPostExecute(final Boolean success) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (success) {
                Toast.makeText(MainActivity.this, "Export successful!", Toast.LENGTH_SHORT).show();

            }
        }

        void copyFile(File src, File dst) throws IOException {
            FileChannel inChannel = new FileInputStream(src).getChannel();
            FileChannel outChannel = new FileOutputStream(dst).getChannel();
            try {
                inChannel.transferTo(0, inChannel.size(), outChannel);
            } finally {
                if (inChannel != null)
                    inChannel.close();
                if (outChannel != null)
                    outChannel.close();
            }
        }

    }

    public static boolean requisitarPropaganda(Context contexto, AdView advBanner) {
        // Create an ad request. Check logcat output for the hashed device
        // ID to get test ads on a physical device.

        AdRequest.Builder adBuilder = new AdRequest.Builder();
        if (BuildConfig.DEBUG) {
            adBuilder
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        }

        AdRequest adRequest = adBuilder.build();

        // Start loading the ad in the background.
        if (advBanner != null) {
            advBanner.loadAd(adRequest);
        }

        return true;
    }

    public static void inicializarAdListener(final AdView advBanner) {
        advBanner.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

                // A propaganda foi carregada com sucesso
                // Logo, vamos mostrar para o usuário
                advBanner.setVisibility(AdView.VISIBLE);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                String msgErro = "";
                switch (errorCode) {
                    case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                        msgErro = "AdListener - Erro interno";
                        break;
                    case AdRequest.ERROR_CODE_INVALID_REQUEST:
                        msgErro = "AdListener - Requisição inválida";
                        break;
                    case AdRequest.ERROR_CODE_NETWORK_ERROR:
                        msgErro = "AdListener - Erro de rede";
                        break;
                    case AdRequest.ERROR_CODE_NO_FILL:
                        msgErro = "AdListener - Não coube";
                        break;
                }
                Log.e("RETORNOALMOCO", msgErro);
                advBanner.setVisibility(AdView.GONE);
            }
        });}

}
