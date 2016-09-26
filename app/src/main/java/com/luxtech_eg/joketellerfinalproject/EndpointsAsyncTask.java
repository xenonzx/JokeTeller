package com.luxtech_eg.joketellerfinalproject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.luxtech.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by ahmed on 10/09/16.
 */
public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    String SERVER_URL= BuildConfig.SERVER_URL;
    String TAG=EndpointsAsyncTask.class.getSimpleName();

    JokeReceivedListener jokeReceivedListener;
    public EndpointsAsyncTask(JokeReceivedListener jokeReceivedListener){
        this.jokeReceivedListener= jokeReceivedListener;

    }
    //TODO refactor the pair is not needed
    @Override
    protected String doInBackground(Void... voids) {
        if(myApiService == null) {  // Only do this once
            Log.v(TAG,SERVER_URL+"/_ah/api/");
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://nano-degree-gradle-course.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }



        try {
            Log.v(TAG,"service url "+myApiService.tellJoke().buildHttpRequestUrl());
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
            return null;
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
            return null;

        }
    }
    @Override
    protected void onPostExecute(String result) {
       // Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        Log.v(TAG,"joke received "+result);
        // todo if result null listner error
        jokeReceivedListener.onJokeReceived(result);
    }
}