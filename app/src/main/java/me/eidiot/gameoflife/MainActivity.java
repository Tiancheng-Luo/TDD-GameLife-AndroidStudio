package me.eidiot.gameoflife;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GameView view = (GameView) findViewById(R.id.gameView);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                float cellSize = getResources().getDimension(R.dimen.cell_size);
                int rows = (int) (view.getWidth() / cellSize);
                int columns = (int) (view.getHeight() / cellSize);
                final GameModel model = new GameModel(rows, columns);

                for (int i = 0; i < model.getRows(); i++) {
                    for (int j = 0; j < model.getColumns(); j++) {
                        if (Math.random() < 0.3) {
                            model.makeAlive(i, j);
                        }
                    }
                }

                view.setup(model);

                final int INTERVAL = 200;
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        handler.postDelayed(this, INTERVAL);

                        model.next();
                        view.invalidate();
                    }
                }, INTERVAL);
            }
        });

    }

}
