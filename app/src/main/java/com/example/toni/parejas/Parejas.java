package com.example.toni.parejas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static android.R.attr.id;

public class Parejas extends Activity implements View.OnClickListener {

    private class Hilo extends AsyncTask<Void,Void,Object>{

        @Override
        protected Void doInBackground(Void... params) {
            SystemClock.sleep(1000);
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            pinta(a);
            pinta(b);
        }
    }
    private int [][] tablero;

    private boolean active = false;

    private int s;

    private View a;
    private View b;

    private int win;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tablero =  new int[4][4];

        pintaTablero();
    }

    public void pinta(View v){
        int id = getResources().getIdentifier("blanco","drawable", getPackageName());
        ((ImageView)v).setImageResource(id);
    }

    private void pintaTablero() {

        int np = 0;

        for(int i = 1; i <= 8; i++){
           while(np <= 1){

                int x  = (int) ((Math.random() * 4));
                int y  = (int) ((Math.random() * 4));
                if (tablero[x][y] == 0){
                    tablero[x][y] = i;
                    np++;
                }
            }
            np = 0;
        }
    }



    public void pinta(View v, int i){
        int id = getResources().getIdentifier("p"+i,"drawable", getPackageName());
        ((ImageView)v).setImageResource(id);
    }



    @Override
    public void onClick(View v) {

        int x = Character.getNumericValue(((ImageView) v).getContentDescription().charAt(0));
        int y = Character.getNumericValue(((ImageView) v).getContentDescription().charAt(1));

        int i = tablero[x][y];

        if(active && s == i){
            if (s == i){
                win++;

                pinta(v, i);

                if(win == 8){
                    ganastes();
                }

            } else {
                b = v;
                pinta(v, i);
                new Hilo().execute();
            }

            active = false;
        } else {
            s = i;
            a = v;
            pinta(v, i);

            active = true;
        }

    }

    private void ganastes() {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("¡GANASTES!");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }
}
