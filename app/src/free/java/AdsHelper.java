package com.luxtech_eg.joketellerfinalproject;
import android.app.Activity;

import com.google.android.gms.ads.AdView;
import com.luxtech_eg.joketellerfinalproject.R;

/**
 * Created by ahmed on 26/09/16.
 */
public class AdsHelper {
    static AdView getAdView(Activity activity){
    return     (AdView) activity.findViewById(R.id.adView);
    }
}
