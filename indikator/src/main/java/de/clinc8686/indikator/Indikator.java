package de.clinc8686.indikator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Indikator extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_indikator);
        setContentView(new myView(this));
    }
}