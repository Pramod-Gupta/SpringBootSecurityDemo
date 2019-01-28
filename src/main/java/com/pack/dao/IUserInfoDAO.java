package com.pack.dao;

import com.pack.entity.UserInfo;

public interface IUserInfoDAO 
{
	UserInfo getActiveUser(String userName);
	
}
