package com.example.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.listener.OnEventControlListener;

public class ListSimpleArrayAdapter extends
ArrayAdapter<String> {
	Context mContext;
	int resourceLayoutId;
	OnEventControlListener listener;
	public ListSimpleArrayAdapter(Context context, int resourceLayoutId,
			String[] commentArray
			) {

		super(context, resourceLayoutId,
				commentArray);
		mContext = context;
		this.resourceLayoutId = resourceLayoutId;

	}
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // setting the ID and text for every items in the list
        String item = getItem(position);

        // visual settings for the list item
        TextView listItem = new TextView(mContext);

        listItem.setText(item);
        listItem.setTag(position);
        listItem.setTextSize(18);
        listItem.setPadding(10, 10, 10, 10);
        listItem.setTextColor(Color.WHITE);
         
        return listItem;
    }
}
