package com.luxtech_eg.joketellerfinalproject;

import android.test.InstrumentationTestCase;
import android.util.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by ahmed on 22/09/16.
 */
//@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest  extends InstrumentationTestCase {

    String TAG = AsyncTaskTest.class.getSimpleName();
   // @Rule
   // public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

     public void testSuccessfulJokeFetch(){

        final CountDownLatch signal = new CountDownLatch(1);
        final String[] recivedJoke = {null};
        EndpointsAsyncTask testTask= (EndpointsAsyncTask) new EndpointsAsyncTask(new JokeReceivedListener() {
            @Override
            public void onJokeReceived(String joke) {

                Log.d(TAG, joke);

                System.out.println("This is System.out.println");

                recivedJoke[0] =joke;
                signal.countDown();
            }
        }).execute((Void[]) null);
        try {
            signal.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         Log.d(TAG, recivedJoke[0]);
        assertTrue(recivedJoke[0] !=null);
    }
}
