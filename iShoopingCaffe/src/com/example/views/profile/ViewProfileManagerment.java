package com.example.views.profile;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.ishoopingcaffe.R;
import com.example.listener.OnEventControlListener;

public class ViewProfileManagerment extends LinearLayout {
	Context mContext;
	LinearLayout layoutContain;

	public ViewProfileManagerment(Context context) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_profile_managerment, this,true);
		
	}
	public void destroy()
	{
		removeAllViews();
		destroyDrawingCache();
	}

}
