package com.joel_harsh.task_assistant;

import com.joel_harsh.task_assistant.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DoneTasks extends Activity implements OnClickListener {
	TextView tv;
	Button button_vnm;
	Button button_vdt;
	Button button_vpr;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.done_tasks);
		getObjects();

		button_vnm.setOnClickListener(this);
		button_vdt.setOnClickListener(this);
		button_vpr.setOnClickListener(this);

	}

	private void getObjects() {
		// TODO Auto-generated method stub

		button_vnm = (Button) findViewById(R.id.bViewbyName);
		button_vdt = (Button) findViewById(R.id.bViewbydt);
		button_vpr = (Button) findViewById(R.id.bViewbypr);
		tv = (TextView) findViewById(R.id.tVDoneTasks);
	}

	@Override
	public void onClick(View vvv) {
		// TODO Auto-generated method stub
		Intent i7 = new Intent(this, DisplayTaskList.class);
		i7.putExtra(StoreConst.DoStatus, 1);
		if (R.id.bViewbyName == ((Button) vvv).getId()) {
			i7.putExtra(StoreConst.SortBy, StoreConst.NAME);
		} else if (R.id.bViewbydt == ((Button) vvv).getId()) {
			i7.putExtra(StoreConst.SortBy, StoreConst.DATE);
		} else if (R.id.bViewbypr == ((Button) vvv).getId()) {
			i7.putExtra(StoreConst.SortBy, StoreConst.PR);

		}

		startActivity(i7);
	}

}
