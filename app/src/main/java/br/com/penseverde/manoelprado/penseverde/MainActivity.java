package br.com.penseverde.manoelprado.penseverde;

import android.content.Intent;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;

import java.util.Observable;
import java.util.Observer;

import br.com.penseverde.manoelprado.penseverde.R;
//implements Observer  //caso for usar o listener pra atualizar
public class MainActivity extends AppCompatActivity{

    private ImageView somaCopo;
    private ImageView somaSacola;
    private ImageView somaCanudo;
    private ImageView subCopo;
    private ImageView subSacola;
    private ImageView subCanudo;
    private EditText addCopos;
    private EditText addSacolas;
    private EditText addCanudos;
    private Button buttonSalvaCopos;
    private Button buttonSalvaSacolas;
    private Button buttonSalvaCanudos;
    private TextView numCoposHoje;
    private TextView numSacolasHoje;
    private TextView numCanudosHoje;
    private ImageView imageCopo;
    private ImageView imageSacola;
    private ImageView imageCanudo;

    private int numCopos;
    private int numCoposTotal;
    private int numSacolas;
    private int numSacolasTotal;
    private int numCanudos;
    private int numCanudosTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final InputMethodManager imm = (InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE);
        final Preferencias preferencias = new Preferencias(MainActivity.this);

        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");
        Date data = new Date();
        String dataFormatada = formataData.format(data);

        if (preferencias.getComparaDay()==null){

            preferencias.setComparaDay(dataFormatada);
            preferencias.setDataPrimeiroAcesso(dataFormatada);
            preferencias.setDiasNoApp(1);
            Toast.makeText(MainActivity.this, "Primeiro acesso: "+preferencias.getDataPrimeiroAcesso(), Toast.LENGTH_LONG).show();


        }else {
            String comparaDay = preferencias.getComparaDay();

            if (comparaDay.equals(dataFormatada)){

            }else {

                preferencias.salvarCoposHoje(0);
                preferencias.salvarSacolasHoje(0);
                preferencias.salvarCanudosHoje(0);

                preferencias.setDiasNoApp(preferencias.getDiasNoApp()+1);
                preferencias.setComparaDay(dataFormatada);

            }
        }

        somaCopo = (ImageView) findViewById(R.id.somaCopoId);
        somaSacola = (ImageView) findViewById(R.id.somaSacolaId);
        somaCanudo = (ImageView) findViewById(R.id.somaCanudoId);

        subCopo = (ImageView) findViewById(R.id.subCopoId);
        subSacola = (ImageView) findViewById(R.id.subSacolaId);
        subCanudo = (ImageView) findViewById(R.id.subCanudoId);

        addCopos = (EditText) findViewById(R.id.addCoposId);
        addSacolas = (EditText) findViewById(R.id.addSacolasId);
        addCanudos = (EditText) findViewById(R.id.addCanudosId);

        buttonSalvaCopos = (Button) findViewById(R.id.buttonSalvaCopoId);
        buttonSalvaSacolas = (Button) findViewById(R.id.buttonSalvaSacolaId);
        buttonSalvaCanudos = (Button) findViewById(R.id.buttonSalvaCanudoId);

        numCoposHoje = (TextView) findViewById(R.id.numCoposHojeId);
        numSacolasHoje = (TextView) findViewById(R.id.numSacolasHojeId);
        numCanudosHoje = (TextView) findViewById(R.id.numCanudosHojeId);

        imageCopo = (ImageView) findViewById(R.id.imageCopoId);
        imageSacola = (ImageView) findViewById(R.id.imageSacolaId);
        imageCanudo = (ImageView) findViewById(R.id.imageCanudoId);


        if (preferencias.getCoposHoje()==0){
            numCoposHoje.setText("Hoje: ...");
        }else{
            if (preferencias.getCoposHoje()==1) {
                numCoposHoje.setText("Hoje: " + preferencias.getCoposHoje() + " copo");
            }else{
                numCoposHoje.setText("Hoje: " + preferencias.getCoposHoje() + " copos");
            }
        }

        if (preferencias.getSacolasHoje()==0){
            numSacolasHoje.setText("Hoje: ...");
        }else{
            if (preferencias.getSacolasHoje()==1) {
                numSacolasHoje.setText("Hoje: " + preferencias.getSacolasHoje() + " sacola");
            }else{
                numSacolasHoje.setText("Hoje: " + preferencias.getSacolasHoje() + " sacolas");
            }
        }

        if (preferencias.getCanudosHoje()==0){
            numCanudosHoje.setText("Hoje: ...");
        }else{
            if (preferencias.getCanudosHoje()==1) {
                numCanudosHoje.setText("Hoje: " + preferencias.getCanudosHoje() + " canudo");
            }else{
                numCanudosHoje.setText("Hoje: " + preferencias.getCanudosHoje() + " canudos");
            }
        }

        //BOTOES IMAGENS
        imageCopo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Total Copos: " + preferencias.getCoposTotal(), Toast.LENGTH_LONG).show();
            }
        });

        imageCopo.setLongClickable(true);
        imageCopo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this, TotalActivity.class);
                startActivity(intent);
                return false;
            }
        });

        imageSacola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Total Sacolas: " + preferencias.getSacolasTotal(), Toast.LENGTH_LONG).show();
            }
        });

        imageSacola.setLongClickable(true);
        imageSacola.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this, TotalActivity.class);
                startActivity(intent);
                return false;
            }
        });

        imageCanudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Total Canudos: " + preferencias.getCanudosTotal(), Toast.LENGTH_LONG).show();
            }
        });

        imageCanudo.setLongClickable(true);
        imageCanudo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this, TotalActivity.class);
                startActivity(intent);
                return false;
            }
        });

        //BOTOES SALVAR
        buttonSalvaCopos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCopos.length()>0){
                        numCopos =preferencias.getCoposHoje()+(Integer.parseInt(addCopos.getText().toString()));
                        numCoposTotal=preferencias.getCoposTotal()+(Integer.parseInt(addCopos.getText().toString()));
                    adicionaCopoHoje(numCopos, numCoposTotal);
                    addCopos.setText("");
                    addCopos.clearFocus();
                    if(imm.isActive()) { imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                }else {
                    Toast.makeText(MainActivity.this, "Preencha o campo!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonSalvaSacolas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addSacolas.length()>0){
                    numSacolas =preferencias.getSacolasHoje()+(Integer.parseInt(addSacolas.getText().toString()));
                    numSacolasTotal=preferencias.getSacolasTotal()+(Integer.parseInt(addSacolas.getText().toString()));
                    adicionaSacolaHoje(numSacolas, numSacolasTotal);
                    addSacolas.setText("");
                    addSacolas.clearFocus();
                    if(imm.isActive()) { imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                }else {
                    Toast.makeText(MainActivity.this, "Preencha o campo!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonSalvaCanudos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addCanudos.length()>0){
                    numCanudos =preferencias.getCanudosHoje()+(Integer.parseInt(addCanudos.getText().toString()));
                    numCanudosTotal=preferencias.getCanudosTotal()+(Integer.parseInt(addCanudos.getText().toString()));
                    adicionaCanudoHoje(numCanudos, numCanudosTotal);
                    addCanudos.setText("");
                    addCanudos.clearFocus();
                    if(imm.isActive()) { imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                }else {
                    Toast.makeText(MainActivity.this, "Preencha o campo!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //BOTOES SOMAR
        somaCopo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numCopos = preferencias.getCoposHoje()+1;
                numCoposTotal = preferencias.getCoposTotal()+1;
                adicionaCopoHoje(numCopos, numCoposTotal);
            }
        });

        somaSacola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numSacolas = preferencias.getSacolasHoje()+1;
                numSacolasTotal = preferencias.getSacolasTotal()+1;
                adicionaSacolaHoje(numSacolas, numSacolasTotal);
            }
        });

        somaCanudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numCanudos = preferencias.getCanudosHoje()+1;
                numCanudosTotal = preferencias.getCanudosTotal()+1;
                adicionaCanudoHoje(numCanudos, numCanudosTotal);
            }
        });

        //BOTOES SUBTRAIR
        subCopo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (preferencias.getCoposHoje()>0){
                    numCopos = preferencias.getCoposHoje()-1;
                    numCoposTotal = preferencias.getCoposTotal()-1;
                    adicionaCopoHoje(numCopos, numCoposTotal);
                }
            }
        });

        subSacola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (preferencias.getSacolasHoje()>0){
                    numSacolas = preferencias.getSacolasHoje()-1;
                    numSacolasTotal = preferencias.getSacolasTotal()-1;
                    adicionaSacolaHoje(numSacolas, numSacolasTotal);
                }
            }
        });

        subCanudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (preferencias.getCanudosHoje()>0){
                    numCanudos = preferencias.getCanudosHoje()-1;
                    numCanudosTotal = preferencias.getCanudosTotal()-1;
                    adicionaCanudoHoje(numCanudos, numCanudosTotal);
                }
            }
        });

    }

    private void adicionaCopoHoje(int numCopos, int numCoposTotal){
        Preferencias preferencias = new Preferencias(MainActivity.this);
        preferencias.salvarCoposHoje(numCopos);
        preferencias.salvarCoposTotal(numCoposTotal);

        int copos = preferencias.getCoposHoje();
        if (copos == 1){
            numCoposHoje.setText("Hoje: " + copos + " copo");
        }else {
            numCoposHoje.setText("Hoje: " + copos + " copos");
        }
    }

    private void adicionaSacolaHoje(int numSacolas, int numSacolasTotal){
        Preferencias preferencias = new Preferencias(MainActivity.this);
        preferencias.salvarSacolasHoje(numSacolas);
        preferencias.salvarSacolasTotal(numSacolasTotal);

        int sacolas = preferencias.getSacolasHoje();
        if (sacolas == 1){
        numSacolasHoje.setText("Hoje: " + sacolas + " sacola");
        }else{
            numSacolasHoje.setText("Hoje: " + sacolas + " sacolas");
        }

    }

    private void adicionaCanudoHoje(int numCanudos, int numCanudosTotal){
        Preferencias preferencias = new Preferencias(MainActivity.this);
        preferencias.salvarCanudosHoje(numCanudos);
        preferencias.salvarCanudosTotal(numCanudosTotal);

        int canudos = preferencias.getCanudosHoje();
        if (canudos == 1){
        numCanudosHoje.setText("Hoje: " + canudos + " canudo");
        }else{
            numCanudosHoje.setText("Hoje: " + canudos + " canudos");
        }
    }

    /*
    public void observe(Observable o) {
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        int someVariable = ((Flux) o).getSomeVariable();
        System.out.println("All is flux!  Some variable is now " + someVariable);
        Toast.makeText(MainActivity.this, "mudança", Toast.LENGTH_SHORT).show();
        Preferencias preferencias = new Preferencias(MainActivity.this);
        preferencias.salvarCoposHoje(0);
        preferencias.salvarSacolasHoje(0);
        preferencias.salvarCanudosHoje(0);
    }
    */

}
