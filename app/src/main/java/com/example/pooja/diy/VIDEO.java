package com.example.pooja.diy;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class VIDEO extends YouTubeBaseActivity {
    diytypes[] details;
    int position;
    private static final String TAG ="VIDEO";
    YouTubePlayerView youtube;
    Button play;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Bundle extra=getIntent().getExtras();

        if(extra!=null){
            details=(diytypes[])extra.getSerializable("obj");
            position=extra.getInt("pos");
        }
        Log.d(TAG,"onCreate: Starting.");
        play=findViewById(R.id.buttonplay);
        youtube= findViewById(R.id.youtubeplay);
        onInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG,"onClick: Done initialising. ");
                String link=details[position].youtubelink;
                //youTubePlayer.loadVideo("tuRw0owdl10");
                youTubePlayer.loadVideo(link);

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG,"onClick: Failed to  initialize. ");


            }
        };
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick : Initialising Youtube Player. ");
                youtube.initialize(youtubeconfig.getApiKey(),onInitializedListener);

            }
        });
    }
}
