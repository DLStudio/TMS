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

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.zbj.tms.R;

/**
 * @author LeiGuoting
 *
 */
public class PeriodOutFragment extends Fragment implements OnClickListener{
	
	private EditText brandEdit;
	
	private EditText priceEdit;
	
	private EditText issueEdit;
	
	private ListView commonListv;
	
	private PoCommonAdapter adapter;
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		
		ActionBar actionBar = ((ActionBarActivity)getActivity()).getSupportActionBar();
		actionBar.setTitle("手机维修价格咨询");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_period_out, null);
		view.findViewById(R.id.po_issue_submit_btn).setOnClickListener(this);
		
		brandEdit = (EditText) view.findViewById(R.id.po_brand_content);
		priceEdit = (EditText) view.findViewById(R.id.po_price_content);
		issueEdit = (EditText) view.findViewById(R.id.po_issue_content);
		
		commonListv = (ListView) view.findViewById(R.id.po_common_listv);
		
		loadCommon();
		return view;
	}
	
	
	@Override
	public void onClick(View view) {
		
		switch(view.getId()){
		default : break;
		
		case R.id.po_issue_submit_btn :
			submitIssue();
			break;
		}
	}
	
	private void loadCommon(){
		AsyncTask<Object, Object, PoCommonInfo[]> task = new AsyncTask<Object, Object, PoCommonInfo[]>(){
			@Override
			protected PoCommonInfo[] doInBackground(Object... params) {
				MobileServiceLogic logic = MobileServiceLogic.getInstance();
				return logic.obtainCommonIssue();
			}
			
			@Override
			protected void onPostExecute(PoCommonInfo[] result) {
				if(null == result || 0 == result.length){
					return;
				}
				
				if(null == adapter){
					adapter = new PoCommonAdapter(getActivity().getApplicationContext(), result);
					commonListv.setAdapter(adapter);
				}
				
				else{
					adapter.update(result);
				}
			}
		};
		
		task.execute();
	}
	
	private void submitIssue(){
		
		final String brand = brandEdit.getText().toString();
		final String price = priceEdit.getText().toString();
		final String issue = issueEdit.getText().toString();
		
		if(null == brand || 0 == brand.trim().length()){
			//TODO
			return;
		}
		
		if(null == price || 0 == price.trim().length()){
			//TODO
			return;
		}
		
		if(null == issue || 0 == issue.trim().length()){
			//TODO
			return;
		}
		
		IssuePriceInfo issueInfo = new IssuePriceInfo();
		issueInfo.brand = brand;
		issueInfo.price = price;
		issueInfo.issue = issue;
		
		AsyncTask<IssuePriceInfo, Object, Integer> task = new AsyncTask<IssuePriceInfo, Object, Integer>(){
			@Override
			protected Integer doInBackground(IssuePriceInfo... params) {
				IssuePriceInfo issueInfo = params[0];
				
				MobileServiceLogic logic = MobileServiceLogic.getInstance();
				int code = logic.submitIssuePrice(issueInfo);
				return code;
			}
			
			@Override
			protected void onPostExecute(Integer result) {
				if(1 == result){
					//成功
					//TODO
				}
				
				else{
					//失败
					//TODO
				}
			}
		};
		
		task.execute(issueInfo);
	}
}