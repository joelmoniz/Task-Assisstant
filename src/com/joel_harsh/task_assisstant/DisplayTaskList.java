package com.joel_harsh.task_assisstant;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayTaskList extends Activity implements OnClickListener{

	LinearLayout linearLayout;
	SharedPreferences prefs;
	SQLManager manager;
	TextView t1;
	Button back;
	
	private ArrayList<HashMap<String, String>> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_task_list);

		manager = SQLManager.createObject(getApplicationContext());

		ListView lview = (ListView) findViewById(R.id.listview);
		back = (Button)findViewById(R.id.goBack);
		back.setOnClickListener(this);

		Cursor c=null;
		int status = getIntent().getExtras().getInt(StoreConst.DoStatus);
		String s = getIntent().getExtras().getString(StoreConst.SortBy);
		if(s!=null)
		{
		if (s.equals(StoreConst.NAME)) {
			c = manager.getTaskByName(status);
		} else if (s.equals(StoreConst.DATE)) {
			c = manager.getTaskByDate(status);
		} else {
			c = manager.getTaskByPr(status);
		}
		}
		else
			Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

		populateListView(c, status);

		ListViewAdapter adapter = new ListViewAdapter(this, list);
		lview.setAdapter(adapter);
	}

	private void populateListView(Cursor c, int status) {

		boolean exist = false;

		list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> temp = new HashMap<String, String>();

		if (c != null && c.getCount() > 0) {
			c.moveToFirst();
			while (c.getPosition() < c.getCount()) {
				if (c.getInt(3) == status) {
					temp.put(StoreConst.NAME, c.getString(0));
					temp.put(StoreConst.DATE, c.getString(1));
					temp.put(StoreConst.PR, c.getString(2));
					exist = true;
				}
				list.add(new HashMap<String, String>(temp));
				c.moveToNext();
				temp.clear();
			}
		}

		if (!exist) {
			if (status == 1)
				temp.put(StoreConst.NAME, "No Tasks done yet");
			else
				temp.put(StoreConst.NAME, "No Tasks to do!");
			list.add(temp);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_task_by_name, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(this,MainActivity.class);
		startActivity(i);
	}

}
