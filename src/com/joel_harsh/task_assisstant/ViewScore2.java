package com.joel_harsh.task_assisstant;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ViewScore2 extends Activity{
	TextView tv1,tv2,tv3;
	EditText et1,et2,et3;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_score2);
		getObjects();
		}
	private void getObjects() {
		// TODO Auto-generated method stub		
		tv1 = (TextView)findViewById(R.id.tVDAte);
		tv2 = (TextView)findViewById(R.id.tVtodaysdone);
		tv3 = (TextView)findViewById(R.id.tVtodaysleft);
		et1 = (EditText)findViewById(R.id.etDAte);
		et2 = (EditText)findViewById(R.id.eTtodaysDone);
		et3 = (EditText)findViewById(R.id.eTtodaysleft);
	}

}
