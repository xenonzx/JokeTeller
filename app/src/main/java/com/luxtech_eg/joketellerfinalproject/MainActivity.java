package com.luxtech_eg.joketellerfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.luxtech_eg.jokesreceivingactivity.JokeReceivingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements JokeReceivedListener{
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.b_tell_jokes)
    Button jokesButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6991334778086285~5079986161");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        jokesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new EndpointsAsyncTask(MainActivity.this).execute();
            }
        });

        AdView mAdView = com.luxtech_eg.joketellerfinalproject.AdsHelper.getAdView(this);
        AdRequest adRequest = new AdRequest.Builder().build();
        if(mAdView!=null){
            Log.v(TAG,"mAdView exists   ");
            mAdView.loadAd(adRequest);
        } else{
            Log.v(TAG,"mAdView is null");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //new EndpointsAsyncTask(this).execute(new Pair<Context, String>(this, "Dakhakhny"));
    }

    Intent buildJokeActivity(String joke){
        Intent intent= new Intent(MainActivity.this, JokeReceivingActivity.class);
        intent.putExtra(getString(R.string.joke_key),joke);
        return  intent;
    }


    @Override
    public void onJokeReceived(String joke) {
        startActivity(buildJokeActivity(joke));
    }
}
