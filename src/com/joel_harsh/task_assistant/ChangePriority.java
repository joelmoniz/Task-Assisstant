package com.joel_harsh.task_assistant;

import com.joel_harsh.task_assistant.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ChangePriority extends Activity implements OnClickListener, OnCheckedChangeListener{

	Button b;
	RadioGroup rg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.change_priority);
		
		b = (Button) findViewById(R.id.bModTask);
		b.setOnClickListener(this);
		
		rg = (RadioGroup) findViewById(R.id.rGPr);
		rg.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.change_priority, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (rg.getCheckedRadioButtonId() != -1)
		{
		String c=null;
		switch (rg.getCheckedRadioButtonId()) {
		case R.id.rPRhigh:
			c = "High";
			break;
		case R.id.rPRmed:
			c = "Medium";
			break;
		case R.id.rPRlow:
			c = "Low";
			break;
		}
		String s = getIntent().getExtras().getString(StoreConst.Store);

		SQLManager.createObject(getApplicationContext()).updatePR(s, c);

		Intent i2 = new Intent(this, MainActivity.class);
		startActivity(i2);

		Toast.makeText(this, "Priority updated.", Toast.LENGTH_SHORT).show();
		}
		
		else
		{
			Toast.makeText(this, "Select a priority first!", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.rPRhigh:
			Toast.makeText(this, "HIGH PR", Toast.LENGTH_SHORT).show();
			break;
		case R.id.rPRmed:
			Toast.makeText(this, "MED PR", Toast.LENGTH_SHORT).show();
			break;
		case R.id.rPRlow:
			Toast.makeText(this, "LOW PR", Toast.LENGTH_SHORT).show();
			break;
		}
	}

}
