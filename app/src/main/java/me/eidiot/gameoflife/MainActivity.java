package me.eidiot.gameoflife;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GameModel model = new GameModel(30, 15);
        model.makeAlive(1, 0);
        model.makeAlive(2, 1);
        model.makeAlive(0, 2);
        model.makeAlive(1, 2);
        model.makeAlive(2, 2);

        final GameView view = (GameView) findViewById(R.id.gameView);
        view.setup(model);

        final int INTERVAL = 300;
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, INTERVAL);

                model.next();
                view.invalidate();
            }
        };
        handler.postDelayed(runnable, INTERVAL);
    }

}
