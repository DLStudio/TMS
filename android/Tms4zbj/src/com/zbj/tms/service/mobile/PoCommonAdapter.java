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
public class PoCommonAdapter extends BaseAdapter {
	
	private PoCommonInfo[] commonInfoArray;
	
	private Context context;
	
	public PoCommonAdapter(Context context, PoCommonInfo [] infoArray){
		this.context = context;
		this.commonInfoArray = infoArray;
	}
	
	public void update(PoCommonInfo [] infoArray){
		commonInfoArray = infoArray;
		notifyDataSetInvalidated();
	}
	
	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		return (null == commonInfoArray) ? 0 : commonInfoArray.length;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		return (null == commonInfoArray) ? null : commonInfoArray[position];
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View contentView, ViewGroup parent) {
		View view = contentView;
		if(null == view){
			view = newView(parent, position);
		}
		buildView(position, view, parent, commonInfoArray[position]);
		return view;
	}

	protected View newView(ViewGroup parent, int position){
		View view = View.inflate(context, R.layout.item_po_common, null);
		Holder holder = new Holder();
		view.setTag(holder);
		
		TextView poTitle = (TextView)view.findViewById(R.id.po_common_title);
		holder.poTitle = poTitle;
		
		TextView poDesc = (TextView)view.findViewById(R.id.po_common_desc);
		holder.poDesc = poDesc;
		
		TextView poPrice = (TextView)view.findViewById(R.id.po_common_price);
		holder.poPrice = poPrice;
		
		TextView poPhoneInfo = (TextView)view.findViewById(R.id.po_common_phone_info);
		holder.poPhoneInfo = poPhoneInfo;
		return view;
	}
	
	protected void buildView(int position, View contentView, ViewGroup parent, PoCommonInfo info){
		Holder holder = (Holder)contentView.getTag();
		TextView poTitle = holder.poTitle;
		poTitle.setText(info.issueTitle);
		
		TextView poDesc = holder.poDesc;
		poDesc.setText(info.issueDesc);
		
		TextView poPrice = holder.poPrice;
		poPrice.setText(info.priceScope);
		
		TextView poPhoneInfo = holder.poPhoneInfo;
		poPhoneInfo.setText(info.phoneBrand + " " + info.phoneModel);
	}
	
	private class Holder{
		TextView poTitle;
		
		TextView poDesc;
		
		TextView poPrice;
		
		TextView poPhoneInfo;
	}
}
