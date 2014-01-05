package com.joel_harsh.task_assisstant;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;

public class SplashScreen extends Activity {

	MediaPlayer splashsong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		splashsong = MediaPlayer.create(SplashScreen.this, R.raw.one_up);
		splashsong.start();
		Thread timeFSA = new Thread() {
			public void run() {
				try {
					sleep(900);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openFSA = new Intent(SplashScreen.this,MainActivity.class);
					startActivity(openFSA);
				}
			}

		};
		timeFSA.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		splashsong.release();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

}
