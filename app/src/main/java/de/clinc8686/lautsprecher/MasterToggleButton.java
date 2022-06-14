package de.clinc8686.lautsprecher;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MasterToggleButton extends androidx.appcompat.widget.AppCompatToggleButton {

    ArrayList<ToggleButton> slaves;
    private boolean disableSlaves = false;

    public MasterToggleButton(@NonNull Context context) {
        super(context);
        slaves = new ArrayList<>();
    }

    public MasterToggleButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        slaves = new ArrayList<>();
        init(context, attrs);
    }

    public MasterToggleButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        slaves = new ArrayList<>();
        init(context, attrs);
    }

    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        changeSlaves(checked);
    }

    void addSlaves(ToggleButton toggleButton) {
        toggleButton.setClickable(!disableSlaves);
        slaves.add(toggleButton);
    }

    void changeSlaves(boolean checked) {
        if (slaves != null) {
            for (ToggleButton tb : slaves) {
                tb.setChecked(checked);
            }
        }
    }

    public boolean getDisableSlaves() {
        return disableSlaves;
    }

    public void setDisableSlaves(boolean disabled) {
        disableSlaves = disabled;
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MasterToggleButton);
        disableSlaves = a.getBoolean(R.styleable.MasterToggleButton_slavesDisabled, false);
    }
}
