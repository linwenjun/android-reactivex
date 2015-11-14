package thoughtworks.academy.androidreactivex.presenter.impl;

import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import thoughtworks.academy.androidreactivex.presenter.ReactiveXPresenter;
import thoughtworks.academy.androidreactivex.view.IReactiveXView;

public class ReactiveXPresenterWithJust implements ReactiveXPresenter {

    private IReactiveXView view;

    private Observable<String> observable1 = Observable.just("info");

    private Observer<String> observer = new Observer<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {
            Log.d("My Observer", s);
            view.showInfo(s);
        }
    };

    private Action1<String> action1 = new Action1<String>() {
        @Override
        public void call(String s) {
            Log.d("My Action", s);
        }
    };

    public ReactiveXPresenterWithJust(IReactiveXView view) {
        this.view = view;
    }

    public void send() {
        observable1.subscribe(observer);
    }


}
