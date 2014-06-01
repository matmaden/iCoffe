

package com.example.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dto.Orders;
import com.example.ishoopingcaffe.R;

/**
 * Category adapter
 * 
 *  @author: truonglt2
 * @version: 1.0
 * @since: Feb 28, 2014
 */

public class OrdersAdapter extends ArrayAdapter<Orders> {

	public Context context;
	public int resourceId;
	public ArrayList<Orders> arrOrders = null;

	/**
	 * 
	 * Constructor
	 * 
	 *  @author: truonglt2
	 * @Since: Feb 28, 2014
	 * @throws:
	 */
	public OrdersAdapter(Context context, int resource,
			ArrayList<Orders> objects) {
		super(context, resource, objects);
		this.context = context;
		this.resourceId = resource;
		this.arrOrders = objects;
	}

	/**
	 * noi dung sua
	 * 
	 *  @author: truonglt2
	 * @since:Feb 28, 2014
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrOrders.size();
	}
	

	/**
	 * noi dung sua
	 * 
	 *  @author: truonglt2
	 * @since:Feb 28, 2014
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		CommentHolder categoryHolder = null;
		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(resourceId, parent, false);
			categoryHolder = new CommentHolder();
			
			
			categoryHolder.txtIdStatusOrders = (TextView) row
					.findViewById(R.id.txtIdStatusOrders);
			categoryHolder.txtDateTime = (TextView) row
					.findViewById(R.id.txtDatetimeOrders);
			categoryHolder.txtPriceOrders = (TextView) row
					.findViewById(R.id.txtPriceOrders);
			
			row.setTag(categoryHolder);
		} else {
			categoryHolder = (CommentHolder) row.getTag();
		}

		// set information for item
		Orders orders = arrOrders.get(position);
		categoryHolder.txtIdStatusOrders.setText(orders.getId()+"-"+orders.getStatus());
		categoryHolder.txtDateTime.setText(orders.getDateTime());
		categoryHolder.txtPriceOrders.setText(orders.getCurrency()+" "+orders.getPrice());
		
		
		return row;
	}

	/**
	 * class define widgets of view in listview comment
	 *  @author: truonglt2
	 *  @version: 1.0
	 *  @since: Mar 14, 2014
	 */
	private class CommentHolder {
		TextView txtIdStatusOrders;
		TextView txtDateTime;
		TextView txtPriceOrders;
	}
}
