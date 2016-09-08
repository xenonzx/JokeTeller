package com.luxtech_eg.jokesreceivingactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



public class JokeReceivingActivity extends AppCompatActivity {


    TextView jokeTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_receiving);

        jokeTV= (TextView) findViewById(R.id.tv_joke);
        String receivedJoke=getIntent().getExtras().getString(getString(R.string.joke_key),getString(R.string.default_joke));
        jokeTV.setText(receivedJoke);
    }
}
