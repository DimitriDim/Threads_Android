package fr.m2i.threads_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtCounter1, txtCounter2;
    private final Integer MAX_COUNTER = 1000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // lien vers les affichages
        txtCounter1 = findViewById(R.id.txtCounter1);
        txtCounter2 = findViewById(R.id.txtCounter2);
    }

    public void counter1(View v) {

      /*  for (Integer i = 0; i < MAX_COUNTER; i++) {
            txtCounter1.setText(i.toString());*/

        new Thread() {
            @Override
            public void run() {
                for (Integer i = 0; i < MAX_COUNTER; i++) {
                    txtCounter1.setText(i.toString());
                }
            }
        }.start();


    }

    public void counter2(View v) {

        new Thread() {
            @Override
            public void run() {
                for (Integer i = 0; i < MAX_COUNTER; i++) {
                    final Integer i2 = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            txtCounter1.setText(i2.toString());
                        }
                    });

                }
            }
        }.start();
    }

    public void counter3(View v) {

        new Thread() {
            @Override
            public void run() {
                for (Integer i = 0; i < MAX_COUNTER; i++) {
                    txtCounter2.setText(i.toString());
                }
            }
        }.start();
    }

    public void counter4(View v) {

        MonThread mth = new MonThread();
        mth.tvAffichage = txtCounter1;
        mth.start();
    }
}


