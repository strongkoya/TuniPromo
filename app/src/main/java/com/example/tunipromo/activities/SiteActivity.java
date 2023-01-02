package com.example.tunipromo.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import com.denzcoskun.imageslider.ImageSlider;

import com.denzcoskun.imageslider.models.SlideModel;
import com.example.tunipromo.R;
import com.example.tunipromo.data.Site;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


import java.util.ArrayList;

public class SiteActivity extends AppCompatActivity {
    private TextView titre;
    private TextView localisation;
    private TextView categorie;
    private TextView description;
    private ImageButton position;
    private Site site;
    private SurfaceView surfaceView;
    private MediaPlayer mediaPlayer;
    private SurfaceHolder surfaceHolder;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);

        ActionBar actionbar = getSupportActionBar();


        actionbar.setTitle("back");
        actionbar.setDisplayHomeAsUpEnabled(true);

        ArrayList imageList = new ArrayList<SlideModel>();
        ImageSlider imageSlider = (ImageSlider) findViewById(R.id.image_slider);


        this.titre = (TextView) findViewById(R.id.titre);
        this.localisation = (TextView) findViewById(R.id.localisation);
        this.categorie = (TextView) findViewById(R.id.categorie);
        this.description = (TextView) findViewById(R.id.desc);
        this.position = (ImageButton) findViewById(R.id.PositionImageButtton);

        Intent intent = getIntent();
        this.site = (Site) intent.getSerializableExtra("site");

        for (String i : site.getImgs()) {
            imageList.add(new SlideModel(i, null, null));

        }
        imageSlider.setImageList(imageList);

        titre.setText(site.getTitre());
        localisation.setText(site.getLocalisation());
        categorie.setText(site.getCategorie());
        description.setText(site.getDescr());

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtubeVideo);
        getLifecycle().addObserver(youTubePlayerView);


        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = site.getVideos();
                youTubePlayer.loadVideo(videoId, 0);
            }
        });


        position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(Uri.parse("geo:0,0?q=" + site.getLocalisation()));
                Intent chooser = Intent.createChooser(intent, "Maps");
                startActivity(chooser);
            }
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
