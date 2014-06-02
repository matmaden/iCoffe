package com.example.ishoopingcaffe;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.listener.ActionEventConstantProfile;
import com.example.listener.OnEventControlListener;
import com.example.views.profile.ViewLoginRegister;
import com.example.views.profile.ViewProfileMainManagerment;
import com.example.views.profile.ViewProfileMyOrders;
import com.example.views.profile.ViewProfileMyOrdersDetails;
import com.example.views.profile.ViewProfileMyOrdersDetailsNotes;

public class ProfileActivity extends BaseActivity implements OnEventControlListener {
	LinearLayout mainContainerProfile;
	Animation animation;
	ViewLoginRegister viewLoginRegister;
	ViewProfileMainManagerment viewProfileManager;
	ViewProfileMyOrders viewProfileMyOrders;
	ViewProfileMyOrdersDetails viewProfileMyOrdersDetails;
	ViewProfileMyOrdersDetailsNotes viewProfileMyOrdersDetailsNotes;
	Context mContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		mContext = this;
		mainContainerProfile = (LinearLayout)findViewById(R.id.container_profile);
		viewLoginRegister = new ViewLoginRegister(mContext, this);
		viewLoginRegister.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		mainContainerProfile.addView(viewLoginRegister);
	}

	@Override
	public void onEvent(int eventType, View control, Object data) {
		switch (eventType) {
		case ActionEventConstantProfile.ACTION_CHANGE_VIEW_LOGIN_REGISTER:
		{
			mainContainerProfile.removeAllViews();
			viewLoginRegister = new ViewLoginRegister(mContext, this);
			viewLoginRegister.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			animation = AnimationUtils.loadAnimation(mContext, R.anim.rail_from_right_to_left);
			viewLoginRegister.startAnimation(animation);
			mainContainerProfile.addView(viewLoginRegister);
			break;
		}
		case ActionEventConstantProfile.ACTION_CHANGE_VIEW_PROFILE_MANAGER:
		{
			mainContainerProfile.removeAllViews();
			viewProfileManager = new ViewProfileMainManagerment(mContext, this);
			viewProfileManager.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			animation = AnimationUtils.loadAnimation(mContext, R.anim.rail_from_right_to_left);
			viewProfileManager.startAnimation(animation);
			mainContainerProfile.addView(viewProfileManager);
			break;
		}
		case ActionEventConstantProfile.ACTION_CHANGE_VIEW_LOGOUT:
		{
			mainContainerProfile.removeAllViews();
			viewLoginRegister = new ViewLoginRegister(mContext, this);
			viewLoginRegister.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			animation = AnimationUtils.loadAnimation(mContext, R.anim.rail_from_right_to_left);
			viewLoginRegister.startAnimation(animation);
			mainContainerProfile.addView(viewLoginRegister);
			break;
		}
		case ActionEventConstantProfile.ACTION_CHANGE_VIEW_ORDER_PPRODUCT:
		{
			mainContainerProfile.removeAllViews();
			viewProfileMyOrders = new ViewProfileMyOrders(mContext, this);
			viewProfileMyOrders.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			animation = AnimationUtils.loadAnimation(mContext, R.anim.rail_from_right_to_left);
			viewProfileMyOrders.startAnimation(animation);
			mainContainerProfile.addView(viewProfileMyOrders);
			break;
		}
		case ActionEventConstantProfile.ACTION_CHANGE_VIEW_ORDER_PPRODUCT_DETAILS:
		{
			mainContainerProfile.removeAllViews();
			viewProfileMyOrdersDetails = new ViewProfileMyOrdersDetails(mContext, this);
			viewProfileMyOrdersDetails.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			animation = AnimationUtils.loadAnimation(mContext, R.anim.rail_from_right_to_left);
			viewProfileMyOrdersDetails.startAnimation(animation);
			mainContainerProfile.addView(viewProfileMyOrdersDetails);
			break;
		}
		case ActionEventConstantProfile.ACTION_CHANGE_VIEW_ORDER_PPRODUCT_DETAILS_NOTES:
		{
			mainContainerProfile.removeAllViews();
			viewProfileMyOrdersDetailsNotes = new ViewProfileMyOrdersDetailsNotes(mContext, this);
			viewProfileMyOrdersDetailsNotes.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			animation = AnimationUtils.loadAnimation(mContext, R.anim.rail_from_right_to_left);
			viewProfileMyOrdersDetailsNotes.startAnimation(animation);
			mainContainerProfile.addView(viewProfileMyOrdersDetailsNotes);
			break;
		}
		default:
			break;
		}
		
	}

	

}
