package id.xyz.xyzuan;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
private int delay=2000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.splash);
            new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        
                        Intent home=new Intent(SplashScreen.this, Dashboard.class);
                        startActivity(home);
                        finish();

                    }
                },delay);
        }
    }
