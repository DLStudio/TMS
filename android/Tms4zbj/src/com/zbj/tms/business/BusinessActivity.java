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
package com.zbj.tms.business;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.zbj.tms.ParentActivity;
import com.zbj.tms.R;
import com.zbj.tms.business.BusinessLogic.Business;

/**
 * @author LeiGuoting
 *
 */
public class BusinessActivity extends ParentActivity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setTitle("宽带办理");
		
		setContentView(R.layout.activity_business);
		
		findViewById(R.id.bus_action_btn).setOnClickListener(this);
		loadCharge();
	}
	
	@Override
	public void onClick(View view) {
		
		switch(view.getId()){
		default : break;
		
		case R.id.bus_action_btn :
			doBusiness();
			break;
		
		}
	}
	
	private void loadCharge(){
		AsyncTask<Object, Object, ChargeInfo> task = new AsyncTask<Object, Object, ChargeInfo>(){
			
			@Override
			protected ChargeInfo doInBackground(Object... params) {
				return null;
			}
			
			@Override
			protected void onPostExecute(ChargeInfo result) {
				//TODO
			}
		};
		
		task.execute();
	}
	
	private void doBusiness(){
		Business bus = new Business();
		EditText nameEdit = (EditText)findViewById(R.id.bus_item_name_edit);
		EditText phoneEdit = (EditText)findViewById(R.id.bus_item_phone_edit);
		EditText addressEdit = (EditText)findViewById(R.id.bus_item_address_edit);
		
		String name = nameEdit.getText().toString();
		String phone = phoneEdit.getText().toString();
		String address = addressEdit.getText().toString();
		
		boolean isNameEmpty = false;
		boolean isPhoneEmpty = false;
		boolean isAddressEmpty = false;
		if(null == name || 0 == name.length()){
			isNameEmpty = true;
		}
		
		if(null == phone || 0 == phone.length()){
			isPhoneEmpty = true;
		}
		
		if(null == address || 0 == address.length()){
			isAddressEmpty = true;
		}
		
		if(isNameEmpty || isPhoneEmpty || isAddressEmpty){
			//TODO
			return;
		}
		
		
		bus.name = name;
		bus.phone = phone;
		bus.address = address;
		
		AsyncTask<Business, Object, Integer> task = new AsyncTask<Business, Object, Integer>(){
			@Override
			protected Integer doInBackground(Business... params) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			protected void onPostExecute(Integer result) {
				//TODO
			}
		};
		
		task.execute(bus);
	}
}
