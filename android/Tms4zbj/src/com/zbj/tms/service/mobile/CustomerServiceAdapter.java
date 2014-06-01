/**
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zbj.tms.service.mobile;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zbj.tms.R;

/**
 * @author LeiGuoting
 *
 */
public class CustomerServiceAdapter extends BaseAdapter{
	
	private CustomerServiceInfo infoArray[];
	
	private Context context;

	public CustomerServiceAdapter(Context context, CustomerServiceInfo[] infoArray) {
		this.context = context;
		this.infoArray = infoArray;
	}

	@Override
	public int getCount() {
		return (null == infoArray) ? 0 :infoArray.length;
	}

	@Override
	public Object getItem(int position) {
		return (null == infoArray) ? null : infoArray[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public void update(CustomerServiceInfo[] infoArray){
		this.infoArray = infoArray;
		notifyDataSetInvalidated();
	}
	
	@Override
	public View getView(int position, View contentView, ViewGroup parent) {
		View view = contentView;
		if(null == view){
			view = newView(parent, position);
		}
		buildView(position, view, parent, infoArray[position]);
		
		return view;
	}

	protected View newView(ViewGroup parent, int position){
		View view = View.inflate(context, R.layout.item_customer_service, null);
		Holder holder = new Holder();
		view.setTag(holder);
		
		TextView phoneModelTxtv = (TextView)view.findViewById(R.id.item_cs_content_phonemodel);
		holder.phoneModelTxtv = phoneModelTxtv;
		
		TextView phoneNoTxtv = (TextView)view.findViewById(R.id.item_cs_content_phone);
		holder.phoneNoTxtv = phoneNoTxtv;
		
		TextView addressTxtv = (TextView)view.findViewById(R.id.item_cs_content_address);
		holder.addressTxtv = addressTxtv;
		return view;
	}
	

	protected void buildView(int position, View contentView, ViewGroup parent, CustomerServiceInfo info){
		Holder holder = (Holder)contentView.getTag();
		
		TextView phoneModelTxtv = holder.phoneModelTxtv;
		phoneModelTxtv.setText(info.phoneModel);
		
		TextView phoneNoTxtv = holder.phoneNoTxtv;
		phoneNoTxtv.setText(info.customerServicePhone);
		
		TextView addressTxtv = holder.addressTxtv;
		addressTxtv.setText(info.customerServiceAddress);
	}
	
	public void onDestory(){
		context = null;
		infoArray = null;
	}
	
	private static class Holder{
		TextView phoneModelTxtv;
		
		TextView phoneNoTxtv;
		
		TextView addressTxtv;
	}
}
