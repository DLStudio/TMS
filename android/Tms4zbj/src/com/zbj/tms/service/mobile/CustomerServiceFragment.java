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

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zbj.tms.R;

/**
 * @author LeiGuoting
 *
 */
public class CustomerServiceFragment extends Fragment implements OnClickListener{
	private ListView content;
	
	private CustomerServiceAdapter adapter;
	
	private OnCustomerServiceListener onCustomerServiceListener;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		onCustomerServiceListener = (OnCustomerServiceListener)activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_period_in, null);
		view.findViewById(R.id.pi_paid_service).setOnClickListener(this);
		
		content = (ListView)view.findViewById(R.id.pi_customer_service_listv);
		loadContent();
		return view;
	}
	
	@Override
	public void onClick(View view) {
		
		int viewId = view.getId();
		if(R.id.pi_paid_service == viewId){
			if(null != onCustomerServiceListener){
				onCustomerServiceListener.onToPaidService();
			}
			
		}
	}
	
	private void loadContent(){
		AsyncTask<Object, Object, CustomerServiceInfo[]> task = new AsyncTask<Object, Object, CustomerServiceInfo[]>(){
			@Override
			protected CustomerServiceInfo[] doInBackground(Object... params) {
				MobileServiceLogic logic = MobileServiceLogic.getInstance();
				return logic.obtainPeriodInInfo();
			}
			
			@Override
			protected void onPostExecute(CustomerServiceInfo[] result) {
				if(null == result || null == content){
					return ;
				}
				
				if(null == adapter){
					adapter = new CustomerServiceAdapter(CustomerServiceFragment.this.getActivity().getApplicationContext(), result);
					content.setAdapter(adapter);
				}
				
				else{
					adapter.update(result);
				}
			}
		};
		
		task.execute();
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		
		content.destroyDrawingCache();
		content = null;
		
		adapter.onDestory();
		adapter = null;
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		onCustomerServiceListener = null;
	}
	
	public interface OnCustomerServiceListener{
		public void onToPaidService();
	}
}