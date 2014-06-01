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
package com.zbj.tms;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.baidu.android.pushservice.PushManager;
import com.baidu.frontia.api.FrontiaPushMessageReceiver;

/**
 * @author LeiGuoting
 *
 */
public class BaiduPushMessageReceiver extends FrontiaPushMessageReceiver {

	private static final String TAG = "BaiduPushMessageReceiver";
	
	@Override
	public void onBind(Context context, int errorCode, String appId, String userId,
			String channelId, String requestId) {
		Log.d(TAG, "@onBind errorCode[" + errorCode + "], appId[" + appId + "], userId[" 
			+ userId + "], channelId[" + channelId + "], requestId[" + requestId + "]");
		
		if(0 == errorCode){
			List<String> tagList = new ArrayList<String>(1);
			tagList.add("manager");
			//tagList.add("admin");
			
			PushManager.setTags(context, tagList);
			
			//PushManager.setSDKTags(context, "manager", tagList);
			
			tagList = new ArrayList<String>(1);
			tagList.add("admin");
			PushManager.delTags(context, tagList);
		}
	}

	
	@Override
	public void onDelTags(Context context, int errorCode, List<String> sucessTags,
			List<String> failTags, String requestId) {
		String responseString = "@onDelTags errorCode=" + errorCode
                + " sucessTags=" + sucessTags + " failTags=" + failTags
                + " requestId=" + requestId;
        Log.d(TAG, responseString);
	}
	
	@Override
	public void onListTags(Context arg0, int arg1, List<String> arg2,
			String arg3) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onMessage(Context context, String message, String customContentString) {
		
		Log.d(TAG, "@onMessage message[" + message + "], customContentString[" + customContentString + "]");
	}
	
	@Override
	public void onNotificationClicked(Context context, String title, String description,
			String customContentString) {
		Log.d(TAG, "@onMessage title[" + title + "], description[" + description + "]" + 
				"], customContentString[" + customContentString + "]");
	}
	
	@Override
	public void onSetTags(Context context, int errorCode, List<String> sucessTags,
			List<String> failTags, String requestId) {
		String responseString = "@onSetTags errorCode=" + errorCode
                + " sucessTags=" + sucessTags + " failTags=" + failTags
                + " requestId=" + requestId;
        Log.d(TAG, responseString);
	}
	
	@Override
	public void onUnbind(Context context, int errorCode, String requestId) {
		 String responseString = "onUnbind errorCode=" + errorCode
	                + " requestId = " + requestId;
	        Log.d(TAG, responseString);
		
		// 解绑定成功，设置未绑定flag，
        if (errorCode == 0) {
            Utils.setBind(context, false);
        }
	}
}
