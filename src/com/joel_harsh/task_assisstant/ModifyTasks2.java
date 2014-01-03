package com.joel_harsh.task_assisstant;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ModifyTasks2 extends Activity implements OnClickListener {
	TextView tv;
	Button button_an;
	Button button_cd;
	Button button_cp;
	Button button_md;
	Button button_rt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modifytask2);
		getObjects();
	
		
		button_an.setOnClickListener(this);
		button_cd.setOnClickListener(this);
		button_cp.setOnClickListener(this);
		button_md.setOnClickListener(this);
		button_rt.setOnClickListener(this);

	}

	private void getObjects() {
		// TODO Auto-generated method stub
		
		button_an = (Button) findViewById(R.id.bAddNote);
		button_cd = (Button) findViewById(R.id.bChangeDATEofthistask);
		button_cp = (Button) findViewById(R.id.bChangePriorityoftask);
		button_md = (Button) findViewById(R.id.bMARKDone);
		button_rt = (Button) findViewById(R.id.bREMoveTASk);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(R.id.bAddNote == ((Button)v).getId()) {
		//	Intent i1 = new Intent( this,CreateTask.class);
			//startActivity(i1);
			Toast.makeText(this, "YOUR WORK", Toast.LENGTH_SHORT)
			.show();
			}
			else if(R.id.bChangeDATEofthistask== ((Button)v).getId()) {
			//Intent i2 = new Intent( this, ViewTask.class);
			//startActivity(i2);
				Toast.makeText(this, "YOUR WORK", Toast.LENGTH_SHORT)
				.show();
			}
			else if(R.id.bChangePriorityoftask== ((Button)v).getId()) {
			//Intent i3 = new Intent( this, ModifyTask.class);
	        //startActivity(i3);
				Toast.makeText(this, "YOUR WORK", Toast.LENGTH_SHORT)
				.show();
			}
			else if(R.id.bMARKDone == ((Button)v).getId()) {
			//Intent i4 = new Intent( this, ViewScore.class);
			//startActivity(i4);
				Toast.makeText(this, "YOUR WORK", Toast.LENGTH_SHORT)
				.show();
			}
			else if(R.id.bREMoveTASk == ((Button)v).getId()) {
				//Intent i4 = new Intent( this, ViewScore.class);
				//startActivity(i4);
				Toast.makeText(this, "YOUR WORK", Toast.LENGTH_SHORT)
				.show();
				}
		
	}
	

}
