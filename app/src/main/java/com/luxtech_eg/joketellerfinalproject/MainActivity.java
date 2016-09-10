package com.luxtech_eg.joketellerfinalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.example.JokesProvider;
import com.luxtech_eg.jokesreceivingactivity.JokeReceivingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
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

                //Toast.makeText(MainActivity.this,JokesProvider.getJoke(),Toast.LENGTH_LONG).show();
                startActivity(buildJokeActivity(JokesProvider.getJoke()));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
    }

    Intent buildJokeActivity(String joke){
        Intent intent= new Intent(MainActivity.this, JokeReceivingActivity.class);
        intent.putExtra(getString(R.string.joke_key),joke);
        return  intent;
    }
}
