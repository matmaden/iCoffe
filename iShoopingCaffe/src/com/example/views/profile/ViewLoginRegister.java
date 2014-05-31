package com.example.views.profile;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.ishoopingcaffe.R;
import com.example.listener.ActionEventConstantProfile;
import com.example.listener.OnEventControlListener;

public class ViewLoginRegister extends LinearLayout implements OnClickListener{
	Context mContext;
	LinearLayout layoutContain;
	OnEventControlListener mListener;
	TextView txtTitle;
	Button btnSignIn_SignInUp,btnRegister_SignInUp;
	ScrollView layout_SignIn,layout_SignUp; 
	Button btnSignIn_SignIn,btnSignUp_SignUp;
	Animation animation;
	public ViewLoginRegister(Context context, OnEventControlListener listenner) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.profile_login_register_layout, this,true);
		mListener = listenner;
		
		
		layoutContain = (LinearLayout)findViewById(R.id.layoutContainer);
		txtTitle =(TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(mContext.getString(R.string.profile));
		
		btnSignIn_SignInUp = (Button)findViewById(R.id.btnSignIn_SignInUp);
		btnSignIn_SignInUp.setOnClickListener(this);
		btnRegister_SignInUp = (Button)findViewById(R.id.btnRegister_SignInUp);
		btnRegister_SignInUp.setOnClickListener(this);
		
		layout_SignIn = (ScrollView)findViewById(R.id.Layout_SignIn);
		layout_SignUp = (ScrollView)findViewById(R.id.Layout_SignUp);
		
		btnSignIn_SignIn = (Button)findViewById(R.id.btnSignIn_SignIn);
		btnSignIn_SignIn.setOnClickListener(this);
		
		btnSignUp_SignUp= (Button)findViewById(R.id.btnSignUp_SignUp);
		btnSignUp_SignUp.setOnClickListener(this);
		
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
		
		case R.id.btnSignIn_SignInUp://button layout login
		{
			animation = AnimationUtils.loadAnimation(mContext, R.anim.rail_from_left_to_right);
			layout_SignIn.startAnimation(animation);
			layout_SignIn.setVisibility(View.VISIBLE);
			layout_SignUp.setVisibility(View.GONE);
			break;
		}
		case R.id.btnRegister_SignInUp://button layout register
		{
			animation = AnimationUtils.loadAnimation(mContext, R.anim.rail_from_right_to_left);
			layout_SignUp.startAnimation(animation);
			layout_SignUp.setVisibility(View.VISIBLE);
			layout_SignIn.setVisibility(View.GONE);
			
			break;
		}
		case R.id.btnSignUp_SignUp://button register
		{
			break;
		}
		case R.id.btnSignIn_SignIn://button login
		{
			mListener.onEvent(ActionEventConstantProfile.ACTION_CHANGE_VIEW_PROFILE_MANAGER, null, null);
			break;
		}
	
		default:
			break;
		}
		
	}

}
