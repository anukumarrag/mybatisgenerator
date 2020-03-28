package com.anurag.mybatiscrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.mybatiscrud.domain.User;
import com.anurag.mybatiscrud.domain.UserExample;
import com.anurag.mybatiscrud.mapper.UserMapper;

/**
 * 
 * @author anurag.kumar
 *
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int insert(User user) {
		return userMapper.insert(user);
	}

	@Override
	public List<User> getUserByExample(UserExample userExample) {
		return userMapper.selectByExample(userExample);
	}

	@Override
	public int updateUserByExample(User user, UserExample userExample) {
		return userMapper.updateByExample(user, userExample);
	}

	@Override
	public int deleteUserByExample(UserExample userExample) {
		return userMapper.deleteByExample(userExample);
	}

}
