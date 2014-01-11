package com.joel_harsh.task_assistant;

import java.util.Calendar;

import com.joel_harsh.task_assistant.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class CreateTask extends Activity implements OnClickListener,
		OnCheckedChangeListener, OnDateChangedListener {

	Button button_save;
	RadioGroup rg;
	TextView tv1, tv2, tv3, tv4;
	EditText ed1;
	DatePicker dp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_task);
		getObjects();
		rg.setOnCheckedChangeListener(this);
		button_save.setOnClickListener(this);

		Calendar calendar = Calendar.getInstance();
		dp.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), this);
	}

	private void getObjects() {
		// TODO Auto-generated method stub
		button_save = (Button) findViewById(R.id.bAddTask);
		rg = (RadioGroup) findViewById(R.id.rGPr);
		tv1 = (TextView) findViewById(R.id.tVCreatetsk);
		tv2 = (TextView) findViewById(R.id.tVtskName);
		tv3 = (TextView) findViewById(R.id.tVTskDt);
		tv4 = (TextView) findViewById(R.id.tVtskPriority);
		ed1 = (EditText) findViewById(R.id.eTtskname);
		dp = (DatePicker) findViewById(R.id.datePicker1);

	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch (arg1) {
		case R.id.rPRhigh:
			Toast.makeText(this, "High Priority", Toast.LENGTH_SHORT).show();
			break;
		case R.id.rPRmed:
			Toast.makeText(this, "Medium Priority", Toast.LENGTH_SHORT).show();
			break;
		case R.id.rPRlow:
			Toast.makeText(this, "Low Priority", Toast.LENGTH_SHORT).show();
			break;
		}

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		String rId = null;
		switch (rg.getCheckedRadioButtonId()) {
		case R.id.rPRhigh:
			rId = "High";
			break;
		case R.id.rPRmed:
			rId = "Medium";
			break;
		case R.id.rPRlow:
			rId = "Low";
			break;
		}

		if (rg.getCheckedRadioButtonId() != -1
				&& ed1.getText().toString() != ""
				&& ed1.getText().toString() != null) {
			if (SQLManager.istaskPresent(ed1.getText().toString())) {
				Toast.makeText(
						this,
						"You have already added that task. Change the name and try again.",
						Toast.LENGTH_SHORT).show();
			} else {
				String date = dp.getYear() + "/" 
						+ (dp.getMonth() + 1) + "/" + dp.getDayOfMonth() ;
				SQLManager.newTask(ed1.getText().toString(), date, rId);

				Toast.makeText(this, "Task Added!!", Toast.LENGTH_SHORT).show();
				Intent i = new Intent(this,MainActivity.class);
				startActivity(i);
			}
		}

		else {
			if (ed1.getText().toString() == null
					|| ed1.getText().toString() == null)
				Toast.makeText(this, "Enter Task Name", Toast.LENGTH_SHORT)
						.show();

			if (rg.getCheckedRadioButtonId() == -1)
				Toast.makeText(this, "Select Task Priority", Toast.LENGTH_SHORT)
						.show();

		}
	}

	@Override
	public void onDateChanged(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		// TODO Auto-generated method stub
		
	}

}
