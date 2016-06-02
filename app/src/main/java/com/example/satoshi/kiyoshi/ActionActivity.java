package com.example.satoshi.kiyoshi;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;

import java.util.Random;

public class ActionActivity extends AppCompatActivity {
    TextView tv1;
    Handler mHandler;
    String s1=null,s2=null,s3=null,s4=null,s5=null,s6=null;
    Random rand;
    String h;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_view);
        tv1 = (TextView)findViewById(R.id.tv1);
        mHandler = new Handler(Looper.getMainLooper());

        String[] kiyoshi = {"ズン", "ドコ", "キヨシ!"};
        kiyoshi(kiyoshi);

    }


    void kiyoshi(final String[] kiyoshi) {
        new Thread(new Runnable() {
            public void run() {
                rand = new Random();
                while (true) {
                    mHandler.post(new Runnable() {
                        public void run() {
                            s1 = kiyoshi[rand.nextInt(2)] + "\n";
                            tv1.setText(h + s1);
                            h = tv1.getText().toString();
                        }
                    });
                    if ("ズン".equals(s1)) {
                        mHandler.post(new Runnable() {
                            public void run() {
                                s2 = kiyoshi[rand.nextInt(2)];
                                h = h + s2 + "\n";
                                tv1.setText(h);
                            }
                        });
                        if ("ズン".equals(s2)) {
                            mHandler.post(new Runnable() {
                                public void run() {
                                    s3 = kiyoshi[rand.nextInt(2)];
                                    h = h + s3 + "\n";
                                    tv1.setText(h);
                                }
                            });
                            if ("ズン".equals(s3)) {
                                mHandler.post(new Runnable() {
                                    public void run() {
                                        s4 = kiyoshi[rand.nextInt(2)];
                                        h = h + s4 + "\n";
                                        tv1.setText(h);
                                    }
                                });
                                if ("ズン".equals(s4)) {
                                    mHandler.post(new Runnable() {
                                        public void run() {
                                            s5 = kiyoshi[rand.nextInt(2)];
                                            h = h + s5 + "\n";
                                            tv1.setText(h);
                                        }
                                    });
                                    if ("ドコ".equals(s5)) {
                                        mHandler.post(new Runnable() {
                                            public void run() {
                                                s6 = kiyoshi[rand.nextInt(2)];
                                                h = h + s6 + "\n" + "キヨシ!";
                                                tv1.setText(h);
                                            }
                                        });
                                        break;
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }).start();

    }


}
