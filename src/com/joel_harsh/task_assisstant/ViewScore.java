package com.joel_harsh.task_assisstant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ViewScore extends Activity implements OnClickListener {
	TextView tv1, tv2, tv3;
	TextView et1, et2, et3;
	Button button_fd;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_score);
		getObjects();
		button_fd.setOnClickListener(this);
		long done = SQLManager.createObject(getApplicationContext())
				.getTasksDoneCount();
		long left = SQLManager.createObject(getApplicationContext())
				.getTasksLeftCount();
		if (done + left != 0)
			et1.setText(String.valueOf(done * 100L / (done + left)) + "%");
		else
			et1.setText("No tasks yet!");
		et2.setText(String.valueOf(done));
		et3.setText(String.valueOf(left));
	}

	private void getObjects() {
		// TODO Auto-generated method stub

		button_fd = (Button) findViewById(R.id.bVSDate);
		tv1 = (TextView) findViewById(R.id.tVCurrentScore);
		tv2 = (TextView) findViewById(R.id.tVTaskDonepercentage);
		tv3 = (TextView) findViewById(R.id.tVTasksleftpercent);
		et1 = (TextView) findViewById(R.id.eTcurrentScore);
		et2 = (TextView) findViewById(R.id.eTtaskDonepercent);
		et3 = (TextView) findViewById(R.id.eTtaskleftpercent);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i11 = new Intent(this, ViewScore2.class);
		startActivity(i11);

	}

}
