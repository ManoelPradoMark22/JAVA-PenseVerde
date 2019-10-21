package br.com.penseverde.manoelprado.penseverde;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias {


    private Context contexto;
    private SharedPreferences preferences;
    private final String NOME_ARQUIVO = "penseverde.preferencias";
    private int MODE = 0; //apenas o app tem acesso ao arquivo de preferencias
    private SharedPreferences.Editor editor;


    private String CHAVE_COPOSHOJE = "numcoposhoje";
    private String CHAVE_COPOSTOTAL = "numcopostotal";

    private String CHAVE_SACOLASHOJE = "numsacolashoje";
    private String CHAVE_SACOLASTOTAL = "numsacolastotal";

    private String CHAVE_CANUDOSHOJE = "numcanudoshoje";
    private String CHAVE_CANUDOSTOTAL = "numcanudostotal";

    private String CHAVE_COMPARADAY = "comparaday";
    private String CHAVE_DIAFIXO = "diafixo";
    private String CHAVE_DATAPRIMEIROACESSO = "dataprimeiroacesso";
    private String CHAVE_DIASNOAPP = "diasnoapp";


    //construtor
    public Preferencias(Context contextoParametro){
        //usando o contexto podemos manipular as preferencias

        contexto = contextoParametro;
        preferences = contexto.getSharedPreferences(NOME_ARQUIVO, MODE);//MODE =0apenas o app tem acesso ao arquivo de preferencias
        editor = preferences.edit(); //início da possibilidade de edicao das preferencias. editar, inserir ou remover itens de preferencias
    }

    //COPOS
    public void salvarCoposTotal (int numcopostotal){
        editor.putInt(CHAVE_COPOSTOTAL, numcopostotal);
        editor.commit(); //salva os dados no arquivo de preferencia criado
    }

    public int getCoposTotal (){  //retorna o num de copos hoje!
        return preferences.getInt(CHAVE_COPOSTOTAL,  0);
    }

    public void salvarCoposHoje (int numcoposhoje){
        editor.putInt(CHAVE_COPOSHOJE, numcoposhoje);
        editor.commit(); //salva os dados no arquivo de preferencia criado
    }

    public int getCoposHoje (){  //retorna o num de copos hoje!
        return preferences.getInt(CHAVE_COPOSHOJE,  0);
    }

    //SACOLAS
    public void salvarSacolasTotal (int numsacolastotal){
        editor.putInt(CHAVE_SACOLASTOTAL, numsacolastotal);
        editor.commit(); //salva os dados no arquivo de preferencia criado
    }

    public int getSacolasTotal (){  //retorna o num de copos hoje!
        return preferences.getInt(CHAVE_SACOLASTOTAL,  0);
    }

    public void salvarSacolasHoje (int numsacolashoje){
        editor.putInt(CHAVE_SACOLASHOJE, numsacolashoje);
        editor.commit(); //salva os dados no arquivo de preferencia criado
    }

    public int getSacolasHoje (){  //retorna o num de copos hoje!
        return preferences.getInt(CHAVE_SACOLASHOJE,  0);
    }

    //CANUDOS
    public void salvarCanudosTotal (int numcanudostotal){
        editor.putInt(CHAVE_CANUDOSTOTAL, numcanudostotal);
        editor.commit(); //salva os dados no arquivo de preferencia criado
    }

    public int getCanudosTotal(){  //retorna o num de copos hoje!
        return preferences.getInt(CHAVE_CANUDOSTOTAL,  0);
    }

    public void salvarCanudosHoje (int numcanudoshoje){
        editor.putInt(CHAVE_CANUDOSHOJE, numcanudoshoje);
        editor.commit(); //salva os dados no arquivo de preferencia criado
    }

    public int getCanudosHoje (){  //retorna o num de copos hoje!
        return preferences.getInt(CHAVE_CANUDOSHOJE,  0);
    }


    //DATA
    public void setComparaDay (String comparaDay) {
        editor.putString(CHAVE_COMPARADAY, comparaDay);
        editor.commit(); //salva os dados no arquivo de preferencia criado
    }

    public String  getComparaDay (){
        return preferences.getString(CHAVE_COMPARADAY, null);
    }

    //primerio acesso data
    public void setDataPrimeiroAcesso (String dataPrimeiroAcesso) {
        editor.putString(CHAVE_DATAPRIMEIROACESSO, dataPrimeiroAcesso);
        editor.commit(); //salva os dados no arquivo de preferencia criado
    }

    public String  getDataPrimeiroAcesso (){
        return preferences.getString(CHAVE_DATAPRIMEIROACESSO, null);
    }

    //dias no app
    public void setDiasNoApp (int diasNoApp) {
        editor.putInt(CHAVE_DIASNOAPP, diasNoApp);
        editor.commit(); //salva os dados no arquivo de preferencia criado
    }

    public int  getDiasNoApp (){
        return preferences.getInt(CHAVE_DIASNOAPP, 0);
    }


}
