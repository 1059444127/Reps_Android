package com.example.ustc.healthreps.serverInterface;

//ReqSingleUserInfo-----请求时发的包
public class ReqSingleUserInfo {
	int type;
	byte[] username = new byte[12];
	boolean isPicExist;
}
