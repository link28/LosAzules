package edu.itch2.plat2.losazules;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Terciaria extends AppCompatActivity implements View.OnClickListener {
    private EditText edtTxt;
    private Button btnIngresar;
    private Button btnQuitar;
    private Button btnVolver;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    MediaPlayer np;
    MediaPlayer na;
    private String [] nombres = {"Marisol Caro", "Erick Morales", "Oswaldo Lucero"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terciaria);
        edtTxt=(EditText)findViewById(R.id.edtTxt);
        btnIngresar=(Button)findViewById(R.id.btnIngresar);
        btnQuitar=(Button)findViewById(R.id.btnQuitar);
        btnVolver=(Button)findViewById(R.id.btnVolver2);
        btnIngresar.setOnClickListener(this);
        btnQuitar.setOnClickListener(this);
        btnVolver.setOnClickListener(this);
        list = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<String>();
        arrayList.add( "Marisol Caro".toString());
        arrayList.add( "Erick Morales".toString());
        arrayList.add("Oswaldo Lucero".toString());
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom, arrayList);
        list.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v==btnIngresar){
            na = MediaPlayer.create(Terciaria.this,R.raw.click2);
            na.start();
            String elemento = edtTxt.getText().toString();
            if (TextUtils.isEmpty(elemento)){
                Toast.makeText(this,"Edit text vacío",Toast.LENGTH_SHORT).show();
            }else{
                arrayList.add(edtTxt.getText().toString());
                adapter.notifyDataSetChanged();
            }
        }else if(v==btnQuitar){
            na = MediaPlayer.create(Terciaria.this,R.raw.click2);
            na.start();
                if (arrayList.size() == 0){
                    Toast.makeText(this,"Lista vacía",Toast.LENGTH_SHORT).show();
                }else{
                     arrayList.remove(arrayList.size()-1);
                     adapter.notifyDataSetChanged();
                }

            /*
            */
        }else{
            Intent intent2 = new Intent(this,principal.class);
            startActivity(intent2);
            overridePendingTransition(R.layout.left_in, R.layout.left_out);
            np = MediaPlayer.create(Terciaria.this,R.raw.click);
            np.start();

            finish();
        }
    }
}
