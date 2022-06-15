package de.clinc8686.tastenfeld;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class NumPad extends TableLayout {
    OnNumClickListener mOnNUmClickListener;
    public NumPad(Context context) {
        super(context);
        setup();
    }

    public NumPad(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public void setOnNumClickListener(OnNumClickListener onNumClickListener) {
        mOnNUmClickListener = onNumClickListener;
        Log.e("xy", "setOnClickListener!");
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
        for(int i = 0; i < tl.getChildCount(); i++) {
            TableRow tr = (TableRow) tl.getChildAt(i);
            for(int j = 0; j < tr.getChildCount(); j++) {
                Button b = (Button) tr.getChildAt(j);
                b.setOnClickListener(this::onNumClick);
            }
        }

        //tl.setOnClickListener(this::onNumClick);    //Das hier fr alle Buttons machen - gemacht
    }

    public void onNumClick(View v) {
        //TableLayout t = findViewById(R.id.tableLayout); //Hier eigentlich direkter button, aber keien id fr BUttons deshalb nur über parent erreichbar
        //Button b = (Button) ((TableRow) t.getChildAt(0)).getChildAt(0);

        char number = 99;
        TableLayout tl = findViewById(R.id.tableLayout);
        for(int i = 0; i < tl.getChildCount(); i++) {
            TableRow tr = (TableRow) tl.getChildAt(i);
            for(int j = 0; j < tr.getChildCount(); j++) {
                Button b = (Button) tr.getChildAt(j);
                b.setOnClickListener(this::onNumClick);
                number = b.getText().toString().charAt(0);
            }
        }

        if(mOnNUmClickListener != null || number == 99) {
            mOnNUmClickListener.onNumClick(v, number);
        }
    }
}
