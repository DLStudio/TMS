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
package com.zbj.tms.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.zbj.tms.ParentActivity;
import com.zbj.tms.R;
import com.zbj.tms.Utils;
import com.zbj.tms.business.BusinessActivity;

/**
 * @author LeiGuoting
 *
 */
public class HomeActivity extends ParentActivity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//getSupportActionBar().hide();
		
		setContentView(R.layout.activity_home);
		
		findViewById(R.id.home_item_business).setOnClickListener(this);
		findViewById(R.id.home_item_commerce).setOnClickListener(this);
		findViewById(R.id.home_item_personal).setOnClickListener(this);
		findViewById(R.id.home_item_phoneno).setOnClickListener(this);
		findViewById(R.id.home_item_sales).setOnClickListener(this);
		findViewById(R.id.home_item_service_mobile).setOnClickListener(this);
		findViewById(R.id.home_item_service_network).setOnClickListener(this);
	
		if(! Utils.hasBind(getApplicationContext())){
			PushManager.startWork(getApplicationContext(),
	                PushConstants.LOGIN_TYPE_API_KEY,
	                Utils.getMetaValue(getApplicationContext(), "api_key"));
		}
	}
	
	@Override
	public void onClick(View view) {
		
		switch(view.getId()){
		default : break;
		
		case R.id.home_item_business :		//业务办理
			Intent intent = new Intent(getApplicationContext(), BusinessActivity.class);
			startActivityForResult(intent, REQUEST_BUSINESS);
			break;
			
		case R.id.home_item_commerce :      //商务
			break;
			
		case R.id.home_item_personal :		//个人
			break;
			
		case R.id.home_item_phoneno :	 	//手机靓号
			break;
		
		case R.id.home_item_sales :			//手机专区
			break;
			
		case R.id.home_item_service_mobile:	//手机故障
			break;
			
		case R.id.home_item_service_network://宽带故障
			break;
		}
	}
	
	@Override
	protected void onDestroy() {
		PushManager.stopWork(getApplicationContext());
		super.onDestroy();
	}
}
