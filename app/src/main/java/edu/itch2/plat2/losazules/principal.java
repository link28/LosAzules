package edu.itch2.plat2.losazules;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class principal extends AppCompatActivity implements View.OnClickListener {
    private Button btnVideo;
    private Button btnLista;
    MediaPlayer np;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnLista=(Button)findViewById(R.id.btnList);
        btnVideo=(Button)findViewById(R.id.btnVideo);

        btnLista.setOnClickListener(this);
        btnVideo.setOnClickListener(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            finish();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (btnLista ==  v){

            Intent intent = new Intent(this,Terciaria.class);
            startActivity(intent);
            overridePendingTransition(R.layout.left_in, R.layout.left_out);

            np = MediaPlayer.create(principal.this,R.raw.click);
            np.start();
            finish();

        }else if (btnVideo ==  v){

            Intent intent = new Intent(this,Secundaria.class);
            startActivity(intent);
            overridePendingTransition(R.layout.left_in, R.layout.left_out);
            np = MediaPlayer.create(principal.this,R.raw.click);
            np.start();
            finish();
        }
    }
}
