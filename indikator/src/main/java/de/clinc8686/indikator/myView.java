package de.clinc8686.indikator;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class myView extends View {
    int maximum;
    int value;
    Paint paint;
    ArrayList<Canvas> canv;
    ArrayList<Canvas> buttons;
    Context context = getContext();
    public int width = context.getResources().getDisplayMetrics().widthPixels;
    public int height = context.getResources().getDisplayMetrics().heightPixels;

    public myView(Context context) {
        super(context);
        setup();
    }

    public myView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public myView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    public myView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_BUTTON_RELEASE) {
            int left = 30, top = 110, right = 260, bottom = 190;
            float X = event.getX();
            float Y = event.getY();

            for(Canvas c : buttons) {
            }
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawRectangles(canvas);
        drawButtons(canvas);
    }

    private void drawButtons(Canvas canvas) {
        String[] text = {"First", "Previous", "Next", "Last"};
        int left = 30, top = 110, right = 260, bottom = 190;
        for(int i = 0; i < 4; i++) {
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(3);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(left, top, right, bottom, paint);

            Paint pText = new Paint();
            pText.setColor(Color.BLACK);
            pText.setTextSize(51);
            canvas.drawText(text[i], left, bottom, pText);

            buttons.add(canvas);
            left += 250;
            right += 250;
        }
    }

    private void drawRectangles(Canvas canvas) {
        int left = 30, top = 30, right = 180, bottom = 80;
        for(int i = 0; i < maximum; i++) {
            Paint paint = new Paint();
            if (i != value) {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(3);
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawRect(left, top, right, bottom, paint);
            } else {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(3);
                canvas.drawRect(left, top ,right, bottom, paint);

                paint.setStrokeWidth(0);
                paint.setColor(Color.rgb(0,255,255));
                canvas.drawRect(left+3,top+3,right-3,bottom-3, paint);
            }
            Log.e("x", left + " " + top + " " + right + " " + bottom + " " + maximum);

            canv.add(canvas);
            left += 180;
            right += 180;
        }
    }

    public void setup() {
        int right = 180;
        while(right < width) {
            maximum++;
            right += 180;
        }
        value = 2;
        canv = new ArrayList<>();
        buttons = new ArrayList<>();
    }

    public void setValue(int value) {
        this.value = Math.max(0, Math.min(value, maximum));
        invalidate();
    }
}
