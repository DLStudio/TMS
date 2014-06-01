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

import com.zbj.tms.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/**
 * @author LeiGuoting
 *
 */
public class PortalFragment extends Fragment implements OnClickListener{
	
	private OnMobileServiceListener onMobileServiceListener;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		onMobileServiceListener = (OnMobileServiceListener)activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_mobile_service_portal, null);
		view.findViewById(R.id.mobser_period_in).setOnClickListener(this);
		view.findViewById(R.id.mobser_period_out).setOnClickListener(this);
		view.findViewById(R.id.mobser_common).setOnClickListener(this);
		
		return view;
	}
	
	@Override
	public void onClick(View view) {
		
		switch(view.getId()){
		default : break;
		
		/*保修期内服务*/
		case R.id.mobser_period_in : 
			onMobileServiceListener.onPeriodIn();
			break;
			
		/*已过保修期服务*/
		case R.id.mobser_period_out :
			onMobileServiceListener.onPeriodOut();
			break;
			
		/*手机常见故障*/
		case R.id.mobser_common :
			onMobileServiceListener.onCommon();
			break;
		}
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		onMobileServiceListener = null;
	}
	
	public interface OnMobileServiceListener{
		
		public void onPeriodIn();
		
		public void onPeriodOut();
		
		public void onCommon();
	}
}
