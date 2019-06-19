package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDAO {
	List<User> selectUsers();
}
