package com.internet.journal.ua.dao;

import java.util.List;

import com.internet.journal.ua.domain.User;

public interface UserDao {
	void add(User u);

	List<User> findAll();

	User findById(int id);

	void updateById(User u);

	void delete(int id);
}
