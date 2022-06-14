package de.clinc8686.tastenfeld;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class NumPad extends TableLayout implements View.OnClickListener{
    OnNumClickListener oncl;
    public NumPad(Context context) {
        super(context);
        setup();
    }

    public NumPad(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public void setOnClickListener(OnNumClickListener onNumClickListener) {
        oncl = onNumClickListener;
        Log.e("xy", "setOnClickListener!");
    }

    @Override
    public void onClick(View view) {
        Log.e("xyz", "onClicked");
    }

    public interface OnNumClickListener {
        public void onNumClick(View v, char num);
    }

    private void setup() {
        inflate(getContext(), R.layout.numpad, this);
        addListeners();
    }

    private void addListeners() {
        TableLayout tl = findViewById(R.id.tableLayout);

    }

    public void action(View v) {
        Log.e("xyz", "action!");
    }
}
