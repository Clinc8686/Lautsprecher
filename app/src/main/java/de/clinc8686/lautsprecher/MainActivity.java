package de.clinc8686.lautsprecher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MasterToggleButton mtgAll = findViewById(R.id.masterToggleButton);
        MasterToggleButton mtgFront = findViewById(R.id.frontButton);
        MasterToggleButton mtgRear = findViewById(R.id.rearButton);

        mtgAll.addSlaves(findViewById(R.id.centerButton));
        mtgAll.addSlaves(findViewById(R.id.subwooferButton));

        mtgAll.addSlaves(mtgFront);
        mtgFront.addSlaves(findViewById(R.id.frontLeftButton));
        mtgFront.addSlaves(findViewById(R.id.frontRightButton));

        mtgAll.addSlaves(mtgRear);
        mtgRear.addSlaves(findViewById(R.id.rearLeftButton));
        mtgRear.addSlaves(findViewById(R.id.rearRightButton));
    }
}