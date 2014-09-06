package me.eidiot.gameoflife;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View {
    private GameModel model;
    private Paint strokePaint;
    private Paint fillPaint;

    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setup(GameModel model) {
        this.model = model;

        strokePaint = new Paint();
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setColor(Color.LTGRAY);

        fillPaint = new Paint();
        fillPaint.setStyle(Paint.Style.FILL);
        fillPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int size = 20;
        for (int i = 0; i < model.getRows(); i++) {
            for (int j = 0; j < model.getColumns(); j++) {
                int left = size * i;
                int top = size * j;
                int right = left + size;
                int bottom = top + size;
                if (model.isAlive(i, j)) {
                    canvas.drawRect(left, top, right, bottom, fillPaint);
                }
                canvas.drawRect(left, top, right, bottom, strokePaint);
            }
        }
    }
}
