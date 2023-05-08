package com.bakery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakery.dao.UserRepo;
import com.bakery.model.User;


@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
public User saveUser(User u)
{
 return userRepo.save(u);
}
public String validateUser(String username,String password)
{
	String result="";
	User u=userRepo.findByUsername(username);
	if(u==null)
	{
		result="Invalid user";
	}
		else
		{
			if(u.getPassword().equals(password))
			{
				result="Login success";
			}
			else
			{
				result="Login failed";
			}
		}
	

	return result;
	}
	

}