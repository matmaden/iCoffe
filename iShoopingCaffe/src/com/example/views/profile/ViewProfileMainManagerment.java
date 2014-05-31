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

public class ViewProfileMainManagerment extends LinearLayout implements OnClickListener{
	Context mContext;
	LinearLayout layoutContain;
	OnEventControlListener mListener;
	Animation animation;
	
	Button btnManagerment,btnAccount,btnOrders,btnLogout;
	TextView txtTitle;
	Button btnOption;
	ScrollView layoutAddSubview;
	ViewProfileManagerment viewProfileManager;
	ViewProfileAccount viewProfileAccount;
	
	public ViewProfileMainManagerment(Context context, OnEventControlListener listenner) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_main_profile_managerment, this,true);
		mListener = listenner;
		layoutContain = (LinearLayout)findViewById(R.id.layoutContainerMainManager);
		layoutAddSubview = (ScrollView)findViewById(R.id.layout_add_subview);
		
		btnManagerment= (Button)findViewById(R.id.btnManagerment);
		btnAccount= (Button)findViewById(R.id.btnAccount);
		btnOrders= (Button)findViewById(R.id.btnOrders);
		btnLogout= (Button)findViewById(R.id.btnLogout);
		btnOption= (Button)findViewById(R.id.btnOption);
		
		btnManagerment.setOnClickListener(this);
		btnAccount.setOnClickListener(this);
		btnOrders.setOnClickListener(this);
		btnLogout.setOnClickListener(this);
		btnOption.setOnClickListener(this);
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(mContext.getString(R.string.managerment));
		
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
		viewProfileManager = new ViewProfileManagerment(mContext);
		viewProfileManager.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		layoutAddSubview.addView(viewProfileManager);
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
		case R.id.btnManagerment:
		{
			layoutAddSubview.removeAllViews();
			viewProfileManager = new ViewProfileManagerment(mContext);
			viewProfileManager.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			animation = AnimationUtils.loadAnimation(mContext, R.anim.rail_from_right_to_left);
			viewProfileManager.startAnimation(animation);
			layoutAddSubview.addView(viewProfileManager);
			break;
		}
		case R.id.btnAccount:
		{
			layoutAddSubview.removeAllViews();
			viewProfileAccount = new ViewProfileAccount(mContext);
			viewProfileAccount.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			animation = AnimationUtils.loadAnimation(mContext, R.anim.rail_from_right_to_left);
			viewProfileAccount.startAnimation(animation);
			layoutAddSubview.addView(viewProfileAccount);
			
			break;
		}
		case R.id.btnOrders:
		{
			mListener.onEvent(ActionEventConstantProfile.ACTION_CHANGE_VIEW_ORDER_PPRODUCT, null, null);
			break;
		}
		case R.id.btnLogout:
		{
			mListener.onEvent(ActionEventConstantProfile.ACTION_CHANGE_VIEW_LOGOUT, null, null);
			break;
		}
		case R.id.btnOption:
		{
			//show action capture
//			mListener.onEvent(ActionEventConstantProfile.ACTION_CHANGE_VIEW_LOGOUT, null, null);
			break;
		}
		
		default:
			break;
		}
	}
	
	

}
