package com.example.expfichiers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        try{
            lv = findViewById(R.id.lv);
            ArrayList<Client> lstClients= Client.chargerArrayListdepuisFichier(getApplicationContext());
            ArrayAdapter<Client> AA = new ArrayAdapter<>(getApplicationContext(),
                    android.R.layout.simple_list_item_1,lstClients );
            lv.setAdapter(AA);
        }
        catch (Exception e)
        {
            Log.e("err", "Erreur :" + e.getMessage());
        }

    }
}