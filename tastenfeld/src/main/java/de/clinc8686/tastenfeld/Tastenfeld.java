package de.clinc8686.tastenfeld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Tastenfeld extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tastenfeld);

        NumPad np = findViewById(R.id.numpadInMain);
        np.setOnClickListener(new NumPad.OnNumClickListener() {

            @Override
            public void onNumClick(View v, char num) {
                Log.e("a", "onNumClick");
            }
        });
    }
}