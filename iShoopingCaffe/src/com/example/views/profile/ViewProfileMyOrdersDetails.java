package com.example.views.profile;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.ishoopingcaffe.R;
import com.example.listener.OnEventControlListener;

public class ViewProfileMyOrdersDetails extends LinearLayout {
	Context mContext;
	LinearLayout layoutContain;
	OnEventControlListener mListener;
	public ViewProfileMyOrdersDetails(Context context, OnEventControlListener listenner) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_profile_my_order, this,true);
		mListener = listenner;
		
	}
	public void destroy()
	{
		removeAllViews();
		destroyDrawingCache();
	}

}
