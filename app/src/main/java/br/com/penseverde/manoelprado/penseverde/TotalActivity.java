package br.com.penseverde.manoelprado.penseverde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TotalActivity extends AppCompatActivity {

    private TextView mostrarDiasNoApp;
    private TextView totalCopos;
    private TextView totalSacolas;
    private TextView totalCanudos;
    private int diasNoApp;
    private int numTotalCopos;
    private int numTotalSacolas;
    private int numTotalCanudos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        mostrarDiasNoApp = (TextView) findViewById(R.id.dataPrimeiroAcessoId);
        totalCopos = (TextView) findViewById(R.id.totalCoposId);
        totalSacolas = (TextView) findViewById(R.id.totalSacolasId);
        totalCanudos = (TextView) findViewById(R.id.totalCanudosId);

        Preferencias preferencias = new Preferencias(TotalActivity.this);
        diasNoApp = preferencias.getDiasNoApp();
        numTotalCopos = preferencias.getCoposTotal();
        numTotalSacolas = preferencias.getSacolasTotal();
        numTotalCanudos = preferencias.getCanudosTotal();

        if (diasNoApp==1){
            mostrarDiasNoApp.setText(diasNoApp + " dia");
        }else{
            mostrarDiasNoApp.setText(diasNoApp + " dias");
        }
        totalCopos.setText(Integer.toString(numTotalCopos));
        totalSacolas.setText(Integer.toString(numTotalSacolas));
        totalCanudos.setText(Integer.toString(numTotalCanudos));
    }
}
