package com.joel_harsh.task_assisstant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	TextView tv;
	Button button_ct;
	Button button_vt;
	Button button_mt;
	Button button_vs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getObjects();

		SQLManager.createObject(getApplicationContext()); // Called to create an
															// SQLManager object
															// and to
															// run the
															// onCreate() method
															// of SQLManager,
															// creating the
															// database
       
		button_ct.setOnClickListener(this);
		button_vt.setOnClickListener(this);
		button_mt.setOnClickListener(this);
		button_vs.setOnClickListener(this);
		// prefs = PreferenceManager
		// .getDefaultSharedPreferences(getApplicationContext());
	}

	private void getObjects() {
		// TODO Auto-generated method stub

		button_ct = (Button) findViewById(R.id.bCT);
		button_vt = (Button) findViewById(R.id.bVT);
		button_mt = (Button) findViewById(R.id.bMT);
		button_vs = (Button) findViewById(R.id.bVS);
		

		tv = (TextView) findViewById(R.id.tvHeading);
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.activity_main, menu);
	// return true;
	// }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (R.id.bCT == ((Button) v).getId()) {
			Intent i1 = new Intent(this, CreateTask.class);
			startActivity(i1);
		} else if (R.id.bVT == ((Button) v).getId()) {
			Intent i2 = new Intent(this, ViewTask.class);
			startActivity(i2);
		} else if (R.id.bMT == ((Button) v).getId()) {
			Intent i3 = new Intent(this, ModifyTask.class);
			startActivity(i3);
		} else if (R.id.bVS == ((Button) v).getId()) {
			Intent i4 = new Intent(this, ViewScore.class);
			startActivity(i4);
		}

	}

}
