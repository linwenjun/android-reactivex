package thoughtworks.academy.androidreactivex.presenter.impl;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func2;
import thoughtworks.academy.androidreactivex.presenter.ReactiveXPresenter;
import thoughtworks.academy.androidreactivex.util.VolleyRequest;
import thoughtworks.academy.androidreactivex.view.IReactiveXView;

public class ReactiveXPresenterWithTwoVolleyRequest implements ReactiveXPresenter {

    private IReactiveXView view;

    private Observable<String> fetchFromGoogle = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(final Subscriber<? super String> subscriber) {
            VolleyRequest.newInstance().execStringRequest("http://www.google.com", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("Response", response);
                    subscriber.onNext(response);
                    subscriber.onCompleted();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    subscriber.onError(error);
                }
            });
        }
    });

    private Observable<String> fetchFromBaidu = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(final Subscriber<? super String> subscriber) {
            VolleyRequest.newInstance().execStringRequest("http://www.baidu.com", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("Response", response);
                    subscriber.onNext(response);
                    subscriber.onCompleted();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    subscriber.onError(error);
                }
            });
        }
    });

    public ReactiveXPresenterWithTwoVolleyRequest(IReactiveXView view) {
        this.view = view;
    }

    public void send() {
        Observable.zip(fetchFromBaidu, fetchFromGoogle, new Func2<String, String, String>() {
            @Override
            public String call(String baidu, String google) {
                Log.d("Fetch from baidu", String.valueOf(baidu.length()));
                Log.d("Fetch from google", String.valueOf(google.length()));

                return String.valueOf((baidu.length() - google.length()));
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("Delta", s);
                view.showInfo(s);
            }
        });
    }
}
