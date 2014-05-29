package com.example.views.profile;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.ishoopingcaffe.R;
import com.example.listener.ActionEventConstantProfile;
import com.example.listener.OnEventControlListener;

public class ViewLoginRegister extends LinearLayout implements OnClickListener{
	Context mContext;
	LinearLayout layoutContain;
	OnEventControlListener mListener;
	Button btnSignIn_SignIn;
	public ViewLoginRegister(Context context, OnEventControlListener listenner) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.profile_login_register_layout, this,true);
		mListener = listenner;
		layoutContain = (LinearLayout)findViewById(R.id.layoutContainer);
		btnSignIn_SignIn = (Button)findViewById(R.id.btnSignIn_SignIn);
		btnSignIn_SignIn.setOnClickListener(this);
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
	@Override
	public void onClick(View v) {
		int view = v.getId();
		switch (view) {
		case R.id.btnSignIn_SignIn:
		{
			mListener.onEvent(ActionEventConstantProfile.ACTION_CHANGE_VIEW_PROFILE_MANAGER, null, null);
			break;
		}
		default:
			break;
		}
		
	}

}
