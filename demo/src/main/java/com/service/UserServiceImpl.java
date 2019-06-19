package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> selectUsers() {
		return userDAO.selectUsers();
	}

}
