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

import java.lang.ref.SoftReference;

/**
 * @author LeiGuoting
 *
 */
public class BusinessLogic {
	
	private static SoftReference<BusinessLogic> refer;
	
	private BusinessLogic(){}
	
	public static BusinessLogic getInstance(){
		BusinessLogic logic = null;
		
		if(null != refer && null != (logic = refer.get())){
			return logic;
		}
		
		else{
			synchronized (BusinessLogic.class) {
				if(null == refer || null == (logic = refer.get())){
					logic = new BusinessLogic();
					refer = new SoftReference<BusinessLogic>(logic);
				}
			}
			return logic;
		}
	}
	
	public int doBusiness(Business bus){
		
		return 0;
	}
	
	public ChargeInfo[] loadCharge(){
		ChargeInfo chargeArray[] = null;
		
		
		return chargeArray;
	}
	

	public static class Business{
		public String name;
		
		public String phone;
		
		public String address;
	}
	
	
}
