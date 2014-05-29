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
	OnEventControlListener mListener;
	public ViewProfileManagerment(Context context, OnEventControlListener listenner) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_profile_managerment, this,true);
		mListener = listenner;
		layoutContain = (LinearLayout)findViewById(R.id.layoutContainerManager);
		
		layoutContain.setFocusableInTouchMode(true);
		layoutContain.requestFocus();
		layoutContain.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(keyCode == KeyEvent.KEYCODE_BACK 
						&& event.getAction() == KeyEvent.ACTION_UP)
				{
//					mListener.onBackListener();
					return true;
				}
				return false;
			}
		});
		
	}
	public void destroy()
	{
		removeAllViews();
		destroyDrawingCache();
	}

}
