package edu.itch2.plat2.losazules;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Secundaria extends AppCompatActivity implements View.OnClickListener {
    private VideoView miVideoView;
    private Button btnVolver;
    MediaPlayer np;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        miVideoView=(VideoView)findViewById(R.id.videoView);
        btnVolver=(Button)findViewById(R.id.btnVolver1);
        btnVolver.setOnClickListener(this);


        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+ R.raw.golden);


        miVideoView.setVideoURI(uri);
        miVideoView.setMediaController(new MediaController(this));
        miVideoView.start();
        miVideoView.requestFocus();
    }

    @Override
    public void onClick(View v) {

        Intent intent2 = new Intent(this,principal.class);
        startActivity(intent2);
        overridePendingTransition(R.layout.left_in, R.layout.left_out);
        np = MediaPlayer.create(Secundaria.this,R.raw.click);
        np.start();

        finish();
    }
}
