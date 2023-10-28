package com.example.expfichiers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText txtNum,txtNom;

Button btnAjouter, btnAfficher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
               txtNom = findViewById(R.id.txtNom);
                txtNum = findViewById(R.id.txtNum);

btnAjouter = findViewById(R.id.btnAjouter);
            btnAfficher = findViewById(R.id.btnAfficher);
                btnAjouter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Client C = new Client(Integer.parseInt(txtNum.getText().toString()), txtNom.getText().toString());
                            C.ecrireDansFichier(getApplicationContext());
                            }
                        catch (Exception ex) {
                            Log.i("err", "io:" +ex.getMessage());
                        }

                    }
                });
            btnAfficher.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent it = new Intent(MainActivity.this, ListActivity.class);
startActivity(it);
                }
            });
            }
        catch (Exception ex)
        {
            Log.i("err", "hh:" + ex.getMessage());
        }

    }
}