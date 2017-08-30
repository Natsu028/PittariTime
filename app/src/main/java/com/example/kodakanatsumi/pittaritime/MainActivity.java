package com.example.kodakanatsumi.pittaritime;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView mTimeTextView;
    TextView mResultTextView;

    Timer mTimer;

    Handler mHandler;

    int mTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeTextView = (TextView)findViewById(R.id.textview);
        mResultTextView = (TextView)findViewById(R.id.textview2);

        mHandler = new Handler();
    }

     public void start(View v){
         mTime = 10;

         mTimer = new Timer(false);
         mTimer.schedule(new TimerTask() {
             @Override
             public void run() {
                 mHandler.post(new Runnable() {
                     @Override
                     public void run() {

                         mTime--;

                         Log.d("timeの数字=", String.valueOf(mTime));

                     }
                 });

             }

         },0,1000);
     }

     public void button(View v){

         mTimer = new Timer(true);
         mTimer.schedule(new TimerTask() {
             @Override
             public void run() {
                 mHandler.post(new Runnable() {
                     @Override
                     public void run() {

                         mTime -= 2;

                         Log.d("timeの数字=", String.valueOf(mTime));

                     }
                 });

             }

         },0,1000);

     }

    public void button2(View v){

        mTimer = new Timer(false);
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        mTime -= 5;

                        Log.d("timeの数字=", String.valueOf(mTime));

                    }
                });

            }

        },0,1000);

    }

    public void button3(View v){

        mTimer = new Timer(false);
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        mTime -= 8;

                        Log.d("timeの数字=", String.valueOf(mTime));

                    }
                });

            }

        },0,1000);

    }


     public void stop(View v){
         if (mTime == 0) {

             mTimeTextView.setText(String.valueOf(mTime));
             mResultTextView.setText("おめでとう！");
         }else{

             mTimeTextView.setText(String.valueOf(mTime));
             mResultTextView.setText("残念！");

         }

     }

     // コメント
     public void reset(View v){
         mTime = 10;
         mTimeTextView.setText(String.valueOf(mTime));

     }
}
