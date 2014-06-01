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

import java.lang.ref.SoftReference;

/**
 * @author LeiGuoting
 *
 */
public class MobileServiceLogic {

	private MobileServiceLogic(){}
	
	
	private static SoftReference<MobileServiceLogic> refer;
	
	public static MobileServiceLogic getInstance(){
		MobileServiceLogic logic = null;
		
		if(null != refer && null != (logic = refer.get())){
			return logic;
		}
		
		else{
			synchronized (MobileServiceLogic.class) {
				if(null == refer || null == (logic = refer.get())){
					logic = new MobileServiceLogic();
					refer = new SoftReference<MobileServiceLogic>(logic);
				}
			}
			
			return logic;
		}
	}
	
	public CustomerServiceInfo[] obtainPeriodInInfo(){
		CustomerServiceInfo infoArray[] = null;
		
		return infoArray;
	}
	
	/**
	 * 手机付费服务
	 * 
	 */
	public int submitPaidServiceMessage(PaidServiceInfo info){
		
		return 0;
	}
	
	/*
	 * 手机故障维修价格咨询
	 * */
	public int submitIssuePrice(IssuePriceInfo issueInfo){
		
		return 0;
	}
	
	public PoCommonInfo[] obtainCommonIssue(){
		PoCommonInfo [] infoArray = null;
		
		return infoArray;
	}
}