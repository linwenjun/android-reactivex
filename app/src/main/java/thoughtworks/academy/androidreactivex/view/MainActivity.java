package thoughtworks.academy.androidreactivex.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import thoughtworks.academy.androidreactivex.R;
import thoughtworks.academy.androidreactivex.presenter.ReactiveXPresenter;
import thoughtworks.academy.androidreactivex.presenter.impl.ReactiveXPresenterWithAction1;
import thoughtworks.academy.androidreactivex.presenter.impl.ReactiveXPresenterWithJust;
import thoughtworks.academy.androidreactivex.presenter.impl.ReactiveXPresenterWithMap;
import thoughtworks.academy.androidreactivex.presenter.impl.ReactiveXPresenterWithMapAndFilter;
import thoughtworks.academy.androidreactivex.presenter.impl.ReactiveXPresenterWithTwoVolleyRequest;
import thoughtworks.academy.androidreactivex.presenter.impl.ReactiveXPresenterWithVolleyRequest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IReactiveXView {

    private Button startButton;
    private TextView content;
    private ReactiveXPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.start_button);
        content = (TextView) findViewById(R.id.content_text);

        presenter = new ReactiveXPresenterWithJust(this);
        presenter = new ReactiveXPresenterWithAction1(this);
        presenter = new ReactiveXPresenterWithMap(this);
        presenter = new ReactiveXPresenterWithMapAndFilter(this);
        presenter = new ReactiveXPresenterWithVolleyRequest(this);
        presenter = new ReactiveXPresenterWithTwoVolleyRequest(this);

        startButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.start_button:
                Log.i("Test", "Test");
                presenter.send();
                break;
            default:
                break;
        }
    }

    @Override
    public void showInfo(String info) {
        String existText = content.getText().toString();
        content.setText(existText + "|" + info);
    }
}
