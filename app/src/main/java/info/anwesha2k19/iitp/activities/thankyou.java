package info.anwesha2k19.iitp.activities;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import info.anwesha2k19.iitp.R;

public class thankyou extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thankyou);
        getWindow().setStatusBarColor(getResources().getColor(R.color.cardBackgroundEvents));
        getSupportActionBar().hide();
        int t = 1000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        }, t);
    }
}
