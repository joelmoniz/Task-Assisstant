package com.joel_harsh.task_assistant;


import java.util.ArrayList;
import java.util.HashMap;

import com.joel_harsh.task_assistant.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class ListViewAdapter extends BaseAdapter
{
	public ArrayList<HashMap<String,String>> list;
	Activity activity;
	
	public ListViewAdapter(Activity activity, ArrayList<HashMap<String,String>> list) {
		super();
		this.activity = activity;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	private class ViewHolder {
	       TextView txtFirst;
	       TextView txtSecond;
	       TextView txtThird;
	  }

	  
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				ViewHolder holder;
				LayoutInflater inflater =  activity.getLayoutInflater();

				if (convertView == null)
				{
					convertView = inflater.inflate(R.layout.listview, null);
					holder = new ViewHolder();
					holder.txtFirst = (TextView) convertView.findViewById(R.id.tvName);
					holder.txtSecond = (TextView) convertView.findViewById(R.id.tvDate);
					holder.txtThird = (TextView) convertView.findViewById(R.id.tvPriority);
					convertView.setTag(holder);
				}
				else
				{
					holder = (ViewHolder) convertView.getTag();
				}

				HashMap<String, String> map = list.get(position);
				holder.txtFirst.setText(map.get(StoreConst.NAME));
				holder.txtSecond.setText(map.get(StoreConst.DATE));
				holder.txtThird.setText(map.get(StoreConst.PR));				

			return convertView;
	}

}

