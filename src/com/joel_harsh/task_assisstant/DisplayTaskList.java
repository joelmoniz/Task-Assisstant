package com.joel_harsh.task_assisstant;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class DisplayTaskList extends Activity {

	LinearLayout linearLayout;
	SharedPreferences prefs;
	SQLManager manager;
	TextView t1;
	private ArrayList<HashMap<String, String>> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_task_list);

		manager = SQLManager.createObject(getApplicationContext());

		ListView lview = (ListView) findViewById(R.id.listview);

		Cursor c=null;
		int status = getIntent().getExtras().getInt(StoreConst.DoStatus);

		if (getIntent().getExtras().getString(StoreConst.SortBy) == StoreConst.NAME) {
			c = manager.getTaskByName(status);
		} else if (getIntent().getExtras().getString(StoreConst.SortBy) == StoreConst.DATE) {
			c = manager.getTaskByDate(status);
		} else {
			c = manager.getTaskByPr(status);
		}

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

}
