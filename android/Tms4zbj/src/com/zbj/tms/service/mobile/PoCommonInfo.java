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

/**
 * 常见手机故障维修价格信息
 * 
 * @author LeiGuoting
 *
 */
public class PoCommonInfo {

	/*故障名称*/
	public String issueTitle;
	
	/*故障描述*/
	public String issueDesc;
	
	/*手机品牌*/
	public String phoneBrand;
	
	/*手机型号*/
	public String phoneModel;
	
	/*维修价格范围: 300 ~ 400*/
	public String priceScope;
}