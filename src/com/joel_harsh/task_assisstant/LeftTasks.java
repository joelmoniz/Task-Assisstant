package com.joel_harsh.task_assisstant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LeftTasks extends Activity implements OnClickListener {
	TextView tv;
	Button button_vnm;
	Button button_vdt;
	Button button_vpr;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.left_tasks);
		getObjects();

		button_vnm.setOnClickListener(this);
		button_vdt.setOnClickListener(this);
		button_vpr.setOnClickListener(this);

	}

	private void getObjects() {
		// TODO Auto-generated method stub

		button_vnm = (Button) findViewById(R.id.bViewbyNamelft);
		button_vdt = (Button) findViewById(R.id.bViewbydtlft);
		button_vpr = (Button) findViewById(R.id.bViewbyprlft);
		tv = (TextView) findViewById(R.id.tVleftTasks);
	}

	@Override
	public void onClick(View vvv) {

		Intent i8 = new Intent(this, DisplayTaskList.class);
		i8.putExtra(StoreConst.DoStatus, 0);
		if (R.id.bViewbyName == ((Button) vvv).getId()) {
			i8.putExtra(StoreConst.SortBy, StoreConst.NAME);
		} else if (R.id.bViewbydt == ((Button) vvv).getId()) {
			i8.putExtra(StoreConst.SortBy, StoreConst.DATE);
		} else if (R.id.bViewbypr == ((Button) vvv).getId()) {
			i8.putExtra(StoreConst.SortBy, StoreConst.PR);

		}

		startActivity(i8);

	}

}
