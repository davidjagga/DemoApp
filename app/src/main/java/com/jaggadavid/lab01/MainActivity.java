package com.jaggadavid.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView greetingView, targetValDisplay;
    Button increment, decrement;
    Random random;
    long start, finish;
    int count, targetVal;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greetingView = findViewById(R.id.greeting);
        increment = findViewById(R.id.increment);
        decrement = findViewById(R.id.decrement);
        targetValDisplay = findViewById(R.id.display);
        count = 0;
        //set first random value
        random = new Random();
        targetVal = random.nextInt(90)+10;
        targetValDisplay.setText("Try to get "+ targetVal);
        start = System.currentTimeMillis();
    }


    public void increment(View view) {
        count+=1;
        Log.i("incrementing", "" + count);
        greetingView.setText(count+"");
        if (Integer.valueOf(greetingView.getText().toString())==targetVal) {
            finish = System.currentTimeMillis();
            float sec = ((finish - start) / 1000F)-10F;
            targetValDisplay.setText("You got the answer in "+ sec  +"s");

        }
    }

    public void decrement(View view) {
        count-=5;
        Log.i("decrementing", "" + count);
        greetingView.setText(count+"");
        if (Integer.valueOf(greetingView.getText().toString())==targetVal) {
            finish = System.currentTimeMillis();
            float sec = ((finish - start) / 1000F)-10;
            targetValDisplay.setText("You got the answer in "+ sec  +"s");

        }
    }

    public void doubleVal(View view) {
        count*=2;
        Log.i("double", "" + count);
        greetingView.setText(count+"");
        if (Integer.valueOf(greetingView.getText().toString())==targetVal) {
            finish = System.currentTimeMillis();
            float sec = ((finish - start) / 1000F)-10;
            targetValDisplay.setText("You got the answer in "+ sec  +"s");

        }
    }

    public void restartVal(View view) {

        count=0;

        greetingView.setText(count+"");

        random = new Random();
        targetVal = random.nextInt(90) + 10;
        targetValDisplay.setText("Try to get "+ targetVal);
        start = System.currentTimeMillis();
        Log.i("restart", "" + count);


    }

    public void chooseVal(View view) {
        if (Integer.valueOf(greetingView.getText().toString())!=targetVal) {
            random = new Random();
            targetVal = random.nextInt(90) + 10;
            targetValDisplay.setText("Try to get "+ targetVal);
            start = System.currentTimeMillis();
        }

    }
}