package com.joel_harsh.task_assisstant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ViewScore2 extends Activity implements OnClickListener {
	TextView tv1, tv2, tv3, et2, et3, tv4, tvScore;
	EditText et1;
	Button b1, back;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_score2);
		setObjects();

	}

	private void setObjects() {
		// TODO Auto-generated method stub
		tv1 = (TextView) findViewById(R.id.tVDAte);
		tv2 = (TextView) findViewById(R.id.tVtodaysdone);
		tv3 = (TextView) findViewById(R.id.tVtodaysleft);
		tv4 = (TextView) findViewById(R.id.textView1);
		tvScore = (TextView) findViewById(R.id.tVScore);
		et1 = (EditText) findViewById(R.id.etDAte);
		et2 = (TextView) findViewById(R.id.eTtodaysDone);
		et3 = (TextView) findViewById(R.id.eTtodaysleft);
		tv2.setVisibility(View.GONE);
		tv3.setVisibility(View.GONE);
		et2.setVisibility(View.GONE);
		et3.setVisibility(View.GONE);
		tv4.setVisibility(View.GONE);
		tvScore.setVisibility(View.GONE);

		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		back = (Button) findViewById(R.id.goBack);
		back.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.button1) {
			String s = et1.getText().toString();
			if (s != null && s != "") {
				tv2.setVisibility(View.VISIBLE);
				tv3.setVisibility(View.VISIBLE);
				et2.setVisibility(View.VISIBLE);
				et3.setVisibility(View.VISIBLE);
				tv4.setVisibility(View.VISIBLE);
				tvScore.setVisibility(View.VISIBLE);
				tvScore.setText("SCORE:");
				long done = SQLManager.createObject(getApplicationContext())
						.getTasksDoneOnGivenDayCount(s);
				long left = SQLManager.createObject(getApplicationContext())
						.getTasksLeftOnGivenDayCount(s);
				if (done + left != 0)
					tv4.setText(String.valueOf(done * 100L / (done + left))
							+ "%");
				else
					tv4.setText("No tasks yet!");
				et2.setText(String.valueOf(done));
				et3.setText(String.valueOf(left));
			} else
				Toast.makeText(this, "Enter a date!", Toast.LENGTH_SHORT)
						.show();
		} else {
			Intent i = new Intent(this, MainActivity.class);
			startActivity(i);
		}
	}
}
