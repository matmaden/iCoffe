package com.example.views.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ishoopingcaffe.R;
import com.example.listener.ActionEventConstantProfile;
import com.example.listener.OnEventControlListener;

public class ViewProfileMyOrdersDetails extends LinearLayout implements OnClickListener{
	Context mContext;
	LinearLayout layoutContain;
	OnEventControlListener mListener;
	Button btnBack, btnOption;
	TextView txtTilte;
	
	public ViewProfileMyOrdersDetails(Context context, OnEventControlListener listenner) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_profile_my_order_details, this,true);
		mListener = listenner;
		btnBack =(Button)findViewById(R.id.btnBack);
		btnOption =(Button)findViewById(R.id.btnOption); 
		txtTilte=(TextView)findViewById(R.id.txtTitle); 
		btnOption.setText("Lưu ý");
		txtTilte.setText("Đơn hàng của tôi");
		btnBack.setOnClickListener(this);
		btnOption.setOnClickListener(this);
	}
	public void destroy()
	{
		removeAllViews();
		destroyDrawingCache();
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnBack:
		{
			mListener.onEvent(ActionEventConstantProfile.ACTION_CHANGE_VIEW_ORDER_PPRODUCT, null, null);
			break;
		}
		case R.id.btnOption:
		{
			mListener.onEvent(ActionEventConstantProfile.ACTION_CHANGE_VIEW_ORDER_PPRODUCT_DETAILS_NOTES, null, null);
			break;
		}	

		default:
			break;
		}
		
	}

}
