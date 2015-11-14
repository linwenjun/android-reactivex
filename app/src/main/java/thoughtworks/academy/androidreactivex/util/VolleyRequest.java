package thoughtworks.academy.androidreactivex.util;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyRequest {

    private static RequestQueue requestQueue;

    private VolleyRequest() {}

    public static void buildRequestQueue(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public static VolleyRequest newInstance() {
        if(null == requestQueue) {
            throw new NullPointerException("Call buildRequestQueue First");
        }

        return new VolleyRequest();
    }

    public Request execStringRequest(String url, Response.Listener<String> listener,
                             Response.ErrorListener errorListener) {
        StringRequest request = new StringRequest(url, listener, errorListener);
        requestQueue.add(request);
        return request;
    }
}
