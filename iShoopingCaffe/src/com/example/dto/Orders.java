
package com.example.dto;

import java.io.Serializable;

/** 
  * @Description: lop menu content
  * @author:truonglt2
  * @since:Feb 7, 2014 4:13:46 PM
  * @version: 1.0
  * @since: 1.0
  * 
  */
@SuppressWarnings("serial")
public class Orders implements Serializable{

	public String id;
	public String title;
	public String dateTime;
	public String status;
	public String currency;
	public String price;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
