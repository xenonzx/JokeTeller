package com.luxtech_eg.joketellerfinalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.luxtech_eg.jokesreceivingactivity.JokeReceivingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements JokeReceivedListener{
    @BindView(R.id.b_tell_jokes)
    Button jokesButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        jokesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new EndpointsAsyncTask(MainActivity.this).execute(new Pair<Context, String>(MainActivity.this, "Dakhakhny"));
            }
        });

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
