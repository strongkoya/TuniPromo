package com.example.tunipromo.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tunipromo.R;
import com.example.tunipromo.db.DBManager;

public class CreateAccountActivity extends AppCompatActivity {
    Button create;
    EditText nom, prenom, email, login, mdp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_create_account);
        Log.d("test : ", "0");

        nom = (EditText) findViewById(R.id.et_nom);
        prenom = (EditText) findViewById(R.id.et_prenom);
        email = (EditText) findViewById(R.id.et_email);
        login = (EditText) findViewById(R.id.et_identifiant);
        mdp = (EditText) findViewById(R.id.et_mot_de_passe);


        create = (Button) findViewById(R.id.bt_creer);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailValid = email.getText().toString().trim();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                DBManager dbManager = new DBManager(getApplicationContext());
                dbManager.open();

                if (TextUtils.isEmpty(nom.getText())) {

                    nom.setError("Veuillez saisir un nom !!!");

                } else if (TextUtils.isEmpty(prenom.getText())) {

                    prenom.setError("Veuillez saisir un prénom !!!");

                } else if (TextUtils.isEmpty(email.getText()) || !(emailValid.matches(emailPattern))) {

                    email.setError("Veuillez saisir un email valide!!!");

                } else if (TextUtils.isEmpty(login.getText())) {

                    login.setError("Veuillez saisir un identifiant !!!");

                } else if (TextUtils.isEmpty(mdp.getText())) {

                    mdp.setError("Veuillez saisir un mot de pass !!!");

                } else {

                    String sql = "SELECT * FROM USERS WHERE LOGIN=\'" + login.getText().toString() + "\'";
                    Cursor cursor = dbManager.sqlQuery(sql);

                    if (cursor.getCount() != 0) {


                        login.setError("Cet identifiant n'est pas disponible veuillez saisir un autre!!!");
                    } else {
                        dbManager.insert(nom.getText().toString(), prenom.getText().toString(), email.getText().toString(), login.getText().toString(), mdp.getText().toString());
                        dbManager.close();
                        Intent intent = new Intent(CreateAccountActivity.this, MainActivity.class);
                        intent.putExtra("CONNECTION_STATUS", true);

                        startActivity(intent);
                    }
                }
            }


        });


    }
}
