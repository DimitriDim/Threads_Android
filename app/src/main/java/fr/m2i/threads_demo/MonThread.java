package fr.m2i.threads_demo;

import android.widget.TextView;

/**
 * Created by Administrateur on 10/01/2018.
 */

public class MonThread extends Thread {

    public TextView tvAffichage;

    public void run() {

        super.run();
        for (Integer i = 0; i < 100000; i++) {
            tvAffichage.setText(i.toString());
        }
    }

}
