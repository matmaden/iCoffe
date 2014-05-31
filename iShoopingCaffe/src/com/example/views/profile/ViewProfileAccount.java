package com.example.views.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.ishoopingcaffe.R;

public class ViewProfileAccount extends LinearLayout {
	Context mContext;

	public ViewProfileAccount(Context context) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_profile_account_change_password, this,true);

		
	}
	public void destroy()
	{
		removeAllViews();
		destroyDrawingCache();
	}

}
