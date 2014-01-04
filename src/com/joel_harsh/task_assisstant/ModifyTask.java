package com.joel_harsh.task_assisstant;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ModifyTask extends Activity implements OnClickListener {
	Spinner sp;
	String selecteditm;
	Button b1;
	SQLManager manager;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modify_tasks);

		manager = SQLManager.createObject(getApplicationContext());
		List<String> list = new ArrayList<String>();
		Cursor c = null;
		c = manager.getTaskByName(0);

		boolean exist = false;
		if (c != null && c.getCount() > 0) {
			c.moveToFirst();
			while (c.getPosition() < c.getCount()) {
				if (c.getInt(3) == 0) {
					list.add(c.getString(0));
					exist = true;
				}
				c.moveToNext();
			}
		}

		if (!exist) {
			Toast.makeText(this, "No Tasks to do!", Toast.LENGTH_SHORT).show();
			Intent i12 = new Intent(this, MainActivity.class);
			startActivity(i12);
		}

		b1 = (Button) findViewById(R.id.bOpenTASK);
		sp = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adap = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);

		sp.setAdapter(adap);

		sp.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> adapter, View v, int i,
					long lng) {

				selecteditm = adapter.getItemAtPosition(i).toString();
				Toast.makeText(getBaseContext(),
						"You have selected : " + selecteditm,
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {

			}
		});
		b1.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (R.id.bOpenTASK == ((Button) arg0).getId()) {
			Intent i12 = new Intent(this, ModifyTasks2.class);
			i12.putExtra(StoreConst.Store,sp.getSelectedItem().toString());
			startActivity(i12);
		}

	}
}
