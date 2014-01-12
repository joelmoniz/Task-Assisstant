package com.joel_harsh.task_assistant;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.Toast;

public class ChangeTaskDate extends Activity implements OnClickListener, OnDateChangedListener {

	Button b;
	DatePicker dp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.change_task_date);

		b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(this);
		

		dp = (DatePicker) findViewById(R.id.datePicker1);
		Calendar calendar = Calendar.getInstance();
		dp.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.change_task_date, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String s = getIntent().getExtras().getString(StoreConst.Store);
		String d = dp.getYear() + "/" 	+ (dp.getMonth() + 1) + "/" + dp.getDayOfMonth() ;
		SQLManager.createObject(getApplicationContext()).updateDate(s, d);

		Intent i2 = new Intent(this, MainActivity.class);
		startActivity(i2);

		Toast.makeText(this, "Date updated.", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDateChanged(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		// TODO Auto-generated method stub
		
	}

}
