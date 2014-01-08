package com.joel_harsh.task_assistant;

import com.joel_harsh.task_assistant.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ViewTask extends Activity implements OnClickListener {

	Button button_dt, button_lt;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_tasks);
		getObjects();

		button_dt.setOnClickListener(this);
		button_lt.setOnClickListener(this);
	}

	private void getObjects() {
		// TODO Auto-generated method stub

		button_dt = (Button) findViewById(R.id.bDoneTasks);
		button_lt = (Button) findViewById(R.id.bLeftTasks);
	}

	@Override
	public void onClick(View vv) {
		// TODO Auto-generated method stub
		if (R.id.bDoneTasks == ((Button) vv).getId()) {
			Intent i5 = new Intent(this, DoneTasks.class);
			startActivity(i5);
		} else if (R.id.bLeftTasks == ((Button) vv).getId()) {
			Intent i6 = new Intent(this, LeftTasks.class);
			startActivity(i6);
		}

	}

}
