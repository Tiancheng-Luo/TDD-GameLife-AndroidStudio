package me.eidiot.gameoflife;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameModel model = new GameModel(30, 15);

        GameView view = (GameView) findViewById(R.id.gameView);
        view.setup(model);
    }

}
