package com.example.mathtable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int max = 30;
        int startingPosition = 2;
        final ListView tableListView = findViewById(R.id.tableListView);
        SeekBar numberSeekBar = findViewById(R.id.numberSeekBar);
        final ArrayList<Integer> tableArray = new ArrayList<>();
        for(int x = 1; x<=10; x++){
            tableArray.add(startingPosition*x);
        }
        final ArrayAdapter<Integer> tableArrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, tableArray);
        numberSeekBar.setMax(max);
        numberSeekBar.setProgress(startingPosition);
        tableListView.setAdapter(tableArrayAdapter);

        numberSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("inside",Integer.toString(i));
                tableArray.clear();
                if(i<1){
                    i=1;
                }
                for(int x = 1; x<=10; x++){
                    tableArray.add(i*x);
                }

                tableListView.setAdapter(tableArrayAdapter);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}