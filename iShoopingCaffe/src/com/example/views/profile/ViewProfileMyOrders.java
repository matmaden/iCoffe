package com.example.views.profile;

import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.OrdersAdapter;
import com.example.dto.Orders;
import com.example.ishoopingcaffe.R;
import com.example.listener.ActionEventConstantProfile;
import com.example.listener.OnEventControlListener;

public class ViewProfileMyOrders extends LinearLayout implements OnClickListener,OnEventControlListener{
	Context mContext;
	LinearLayout layoutContain;
	OnEventControlListener mListener;
	ListView listview_Orders;
	Button btnBack, btnOption;
	TextView txtTilte;
	public ViewProfileMyOrders(Context context, OnEventControlListener listenner) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_profile_my_order, this, true);
		mListener = listenner;
		
		btnBack =(Button)findViewById(R.id.btnBack);
		btnOption =(Button)findViewById(R.id.btnOption); 
		txtTilte=(TextView)findViewById(R.id.txtTitle); 
		btnOption.setText("Lọc theo");
		txtTilte.setText("Đơn hàng của tôi");
		btnBack.setOnClickListener(this);
		btnOption.setOnClickListener(this);
		
		listview_Orders = (ListView) findViewById(R.id.listview_Orders);
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
				System.out.println("Qua day hehe");
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
			mListener.onEvent(ActionEventConstantProfile.ACTION_CHANGE_VIEW_PROFILE_MANAGER, null, null);
			break;
		}
		case R.id.btnOption:
		{
			
			break;
		}
		default:
			break;
		}
		
	}

}
