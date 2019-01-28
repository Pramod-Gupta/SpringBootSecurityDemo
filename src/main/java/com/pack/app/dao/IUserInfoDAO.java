package com.pack.app.dao;

import com.pack.app.entity.UserInfo;

public interface IUserInfoDAO 
{
	UserInfo getActiveUser(String userName);
	
}
