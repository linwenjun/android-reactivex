package thoughtworks.academy.androidreactivex.app;

import android.app.Application;
import android.content.Context;

import thoughtworks.academy.androidreactivex.util.VolleyRequest;

public class MainApplication extends Application {

    private static Context instance;

    public MainApplication() {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyRequest.buildRequestQueue(this);
    }
}
