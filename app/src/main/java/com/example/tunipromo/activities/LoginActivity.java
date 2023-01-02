package com.example.tunipromo.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tunipromo.R;
import com.example.tunipromo.db.DBManager;
import com.example.tunipromo.db.DatabaseHelper;


public class LoginActivity extends AppCompatActivity {
    Intent intent;

    EditText login;
    EditText motDePasse;
    private Button bt_login;
    public final static String EXTRA_MESSAGE ="Connection Status";

    private DBManager dbManager;

    final String[] from = new String[]{DatabaseHelper._ID,
            DatabaseHelper.NAME, DatabaseHelper.LASTNAME, DatabaseHelper.EMAIL, DatabaseHelper.LOGIN, DatabaseHelper.PASSWORD};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        login = (EditText) findViewById(R.id.et_identifiant);
        motDePasse = (EditText) findViewById(R.id.et_mot_de_passe);
        bt_login = (Button) findViewById(R.id.bt_login);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (verifAccount(login.getText().toString(), motDePasse.getText().toString())) {
                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra(EXTRA_MESSAGE,"true");
                    startActivity(intent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Identification incorrecte: veuillez réessayer");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });



        }
         public Boolean verifAccount(String login, String password) {
             dbManager = new DBManager(this);
             dbManager.open();
             //fetch for all data from the table
             //Cursor cursor = dbManager.fetch();
             String sql = "SELECT * FROM USERS WHERE LOGIN=\'" + login + "\' AND PASSWORD=\'" + password + "\'";
             Cursor cursor = dbManager.sqlQuery(sql);


             if (cursor.getCount() == 0) {
                 cursor.close();
                 dbManager.close();
                 return false;
             } else {
                 cursor.moveToFirst();


                 if (login.equals(cursor.getString(4)) && password.equals(cursor.getString(5))) {
                     cursor.close();
                     dbManager.close();
                     return true;
                 }
                 cursor.close();
                 dbManager.close();
                 return false;
             }
         }


    public void createAccount(View view){

        Toast.makeText(getApplicationContext(),"Création d'un nouveau compte",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);


        startActivity(intent);

    }

}
