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

public class ViewProfileMyOrders extends LinearLayout implements OnClickListener,OnEventControlListener{
	Context mContext;
	LinearLayout layoutContain;
	OnEventControlListener mListener;
	ListView listview_Orders;
	Button btnBack, btnOption;
	TextView txtTilte;
	String popUpContents[];
    PopupWindow popupWindowDogs;
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
				mListener.onEvent(ActionEventConstantProfile.ACTION_CHANGE_VIEW_ORDER_PPRODUCT_DETAILS, null, null);
			}
		});
		List<String> dogsList = new ArrayList<String>();
       
		dogsList.add("Thất bại");
		dogsList.add("Đang xử lý");
		dogsList.add("Chờ xử lý");
		
        // convert to simple array
        popUpContents = new String[dogsList.size()];
        dogsList.toArray(popUpContents);
        
        popupWindowDogs = popupWindowDogs(popUpContents);
	}

	public void destroy() {
		removeAllViews();
		destroyDrawingCache();
	}
	public PopupWindow popupWindowDogs(String[] arrrContent) {
		 
        // initialize a pop up window type
        PopupWindow popupWindow = new PopupWindow(mContext);
 
        // the drop down list is a list view
        ListView listViewDogs = new ListView(mContext);
        ListSimpleArrayAdapter adpter = new ListSimpleArrayAdapter(mContext, android.R.layout.simple_list_item_1, arrrContent);
        // set our adapter and pass our pop up window contents
        listViewDogs.setAdapter(adpter);
         
        // set the item click listener
        listViewDogs.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				// add some animation when a list item was clicked
		        Animation fadeInAnimation = AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in);
		        fadeInAnimation.setDuration(10);
		        view.startAnimation(fadeInAnimation);
		         
		        // dismiss the pop up
		        popupWindowDogs.dismiss();
		         
		         
		        // get the id
		        String selectedItemTag = ((TextView) view).getTag().toString();
		        Toast.makeText(mContext, "ID is: " + selectedItemTag, Toast.LENGTH_SHORT).show();
		        
			}
		});
 
        // some other visual settings
        popupWindow.setFocusable(true);
       
        popupWindow.setWidth(300);
//        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(250);
        // set the list view as pop up window content
        popupWindow.setContentView(listViewDogs);
 
        return popupWindow;
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
			popupWindowDogs.showAsDropDown(v);
			break;
		}
		default:
			break;
		}
		
	}

}
