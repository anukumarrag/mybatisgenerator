package com.anurag.mybatiscrud.service;



import java.util.List;

import com.anurag.mybatiscrud.domain.User;
import com.anurag.mybatiscrud.domain.UserExample;

public interface UserService {
	
	public int insert(User user);
	
	public List<User> getUserByExample(UserExample userExample);
	
	public int updateUserByExample(User user, UserExample userExample);
	
	public int deleteUserByExample(UserExample userExample);
}
