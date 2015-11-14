package thoughtworks.academy.androidreactivex.presenter.impl;

import rx.Observable;
import rx.functions.Action1;
import thoughtworks.academy.androidreactivex.presenter.ReactiveXPresenter;
import thoughtworks.academy.androidreactivex.view.IReactiveXView;

public class ReactiveXPresenterWithAction1 implements ReactiveXPresenter {

    private IReactiveXView view;

    private Observable<String> observable1 = Observable.just("info");

    private Observable<Integer> observable = Observable.from(new Integer[]{1, 2, 3, 4});


    private Action1<Integer> action2 = new Action1<Integer>() {
        @Override
        public void call(Integer integer) {
            view.showInfo(integer.toString());
        }
    };

    public ReactiveXPresenterWithAction1(IReactiveXView view) {
        this.view = view;
    }

    public void send() {
        observable.subscribe(action2);
    }


}
