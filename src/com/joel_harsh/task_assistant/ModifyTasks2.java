package com.joel_harsh.task_assistant;

import com.joel_harsh.task_assistant.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ModifyTasks2 extends Activity implements OnClickListener {
	TextView tv;

	Button button_cd;
	Button button_cp;
	Button button_md;
	Button button_rt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modifytask2);
		getObjects();

		button_cd.setOnClickListener(this);
		button_cp.setOnClickListener(this);
		button_md.setOnClickListener(this);
		button_rt.setOnClickListener(this);

	}

	private void getObjects() {
		// TODO Auto-generated method stub

		button_cd = (Button) findViewById(R.id.bChangeDATEofthistask);
		button_cp = (Button) findViewById(R.id.bChangePriorityoftask);
		button_md = (Button) findViewById(R.id.bMARKDone);
		button_rt = (Button) findViewById(R.id.bREMoveTASk);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		String s = getIntent().getExtras().getString(StoreConst.Store);

		if (R.id.bChangeDATEofthistask == ((Button) v).getId()) {
			Intent i2 = new Intent(this, ChangeTaskDate.class);
			i2.putExtra(StoreConst.Store, s);
			startActivity(i2);
		} else if (R.id.bChangePriorityoftask == ((Button) v).getId()) {
			Intent i3 = new Intent(this, ChangePriority.class);
			i3.putExtra(StoreConst.Store, s);
			startActivity(i3);
		} else if (R.id.bMARKDone == ((Button) v).getId()) {
			Intent i4 = new Intent(this, ChangeDoneStatus.class);
			i4.putExtra(StoreConst.Store, s);
			startActivity(i4);
		} else if (R.id.bREMoveTASk == ((Button) v).getId()) {
			Intent i5 = new Intent(this, DeleteTask.class);
			i5.putExtra(StoreConst.Store, s);
			startActivity(i5);
		}

	}

}
