package com.pack.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pack.app.entity.UserInfo;

@Repository
@Transactional
public class UserInfoDAO  implements IUserInfoDAO
{
	@PersistenceContext	
	private EntityManager entityManager;
	public UserInfo getActiveUser(String userName) 
	{
		UserInfo activeUserInfo = new UserInfo();
		short enabled = 1;
		
		List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName=:username and enabled=:enabled")
				.setParameter("username", userName).setParameter("enabled", enabled).getResultList();
		if(!list.isEmpty()) {
			activeUserInfo = (UserInfo)list.get(0);
		}
		return activeUserInfo;
	}	
}