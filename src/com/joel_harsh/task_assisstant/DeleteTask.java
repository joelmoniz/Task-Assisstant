package com.joel_harsh.task_assisstant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DeleteTask extends Activity implements OnClickListener {

	Button by, bn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delete_task);

		by = (Button) findViewById(R.id.button1);
		bn = (Button) findViewById(R.id.button2);
		
		by.setOnClickListener(this);
		bn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.delete_task, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String s = getIntent().getExtras().getString(StoreConst.Store);
		switch (v.getId()) {
		case R.id.button1:
			SQLManager.createObject(getApplicationContext()).deleteTask(s);
			Toast.makeText(this, "Task successfully deleted.",
					Toast.LENGTH_SHORT).show();
			Intent i = new Intent(this, MainActivity.class);
			startActivity(i);
			break;
		case R.id.button2:
			Intent i2 = new Intent(this, MainActivity.class);
			startActivity(i2);
			break;
		}
	}

}