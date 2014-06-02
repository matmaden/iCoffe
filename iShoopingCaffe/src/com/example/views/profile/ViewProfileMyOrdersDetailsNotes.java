package com.example.views.profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.ListSimpleArrayAdapter;
import com.example.adapter.OrdersAdapter;
import com.example.dto.Orders;
import com.example.ishoopingcaffe.R;
import com.example.listener.ActionEventConstantDiscovery;
import com.example.listener.ActionEventConstantProfile;
import com.example.listener.OnEventControlListener;
import com.example.views.cart.ShoppingCartItem;

public class ViewProfileMyOrdersDetailsNotes extends LinearLayout implements OnClickListener,OnEventControlListener{
	Context mContext;
	LinearLayout layoutContain;
	OnEventControlListener mListener;
	ListView listview_Orders;
	Button btnBack;
	TextView txtTilte;
	public ViewProfileMyOrdersDetailsNotes(Context context, OnEventControlListener listenner) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_profile_my_order_details_notes, this, true);
		mListener = listenner;
		btnBack =(Button)findViewById(R.id.btnBack);
		txtTilte=(TextView)findViewById(R.id.txtTitle); 
		txtTilte.setText("Orders Notes");
		btnBack.setOnClickListener(this);
		
		listview_Orders = (ListView) findViewById(R.id.listview_NotesOrders);
		ArrayList<Orders> arr = new ArrayList<Orders>();
		for (int i = 0; i < 10; i++) {
			Orders orders = new Orders();
			orders.setId("" + 1);
			orders.setDateTime(new Date().toString());
			orders.setCurrency("đ");
			orders.setPrice("" + i * 1000);
			if (i % 2 == 0)
				orders.setStatus("Thất bại");
			else if (i % 3 == 0)
				orders.setStatus("Đang xử lý");
			else
				orders.setStatus("Chờ xử lý");
			arr.add(orders);
		}
		OrdersAdapter adapter = new OrdersAdapter(mContext,
				R.layout.item_view_orders, arr);
		listview_Orders.setAdapter(adapter);
		listview_Orders.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
//				mListener.onEvent(ActionEventConstantProfile.ACTION_CHANGE_VIEW_ORDER_PPRODUCT_DETAILS, null, null);
			}
		});
	}

	public void destroy() {
		removeAllViews();
		destroyDrawingCache();
	}
	@Override
	public void onEvent(int eventType, View control, Object data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		int view = v.getId();
		switch (view) {
		case R.id.btnBack:
		{
			mListener.onEvent(ActionEventConstantProfile.ACTION_CHANGE_VIEW_ORDER_PPRODUCT_DETAILS, null, null);
			break;
		}
		default:
			break;
		}
		
	}

}
