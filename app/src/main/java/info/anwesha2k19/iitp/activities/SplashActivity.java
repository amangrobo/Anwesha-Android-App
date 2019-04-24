package info.anwesha2k19.iitp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.nineoldandroids.animation.ObjectAnimator;

import info.anwesha2k19.iitp.R;


public class SplashActivity extends Activity {
    int time = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.splashscreen );
        View view = (ImageView) findViewById( R.id.logo );
        final ObjectAnimator animation = ObjectAnimator.ofFloat( view, "rotationY", 0.0f, 360f );
        animation.setDuration( 2000 );
   //     animation.setRepeatCount( ObjectAnimator.INFINITE );
        animation.setInterpolator( new AccelerateDecelerateInterpolator() );
        animation.start();
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent( SplashActivity.this, MainActivity.class );
                startActivity( i );
                finish();
            }
        }, time );
        Window window = this.getWindow();
        window.setStatusBarColor( ContextCompat.getColor( this, R.color.cardBackgroundEvents ) );


    }
}

