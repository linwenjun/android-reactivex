package thoughtworks.academy.androidreactivex.presenter.impl;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import thoughtworks.academy.androidreactivex.presenter.ReactiveXPresenter;
import thoughtworks.academy.androidreactivex.view.IReactiveXView;

public class ReactiveXPresenterWithMapAndFilter implements ReactiveXPresenter {

    private IReactiveXView view;

    private Observable<Integer> observable = Observable.from(new Integer[]{1, 2, 3, 4});


    private Action1<Integer> action2 = new Action1<Integer>() {
        @Override
        public void call(Integer integer) {
            view.showInfo(integer.toString());
        }
    };

    public ReactiveXPresenterWithMapAndFilter(IReactiveXView view) {
        this.view = view;
    }

    public void send() {
        observable.map(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer * integer;
            }
        }).filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer < 10;
            }
        }).subscribe(action2);
    }


}
