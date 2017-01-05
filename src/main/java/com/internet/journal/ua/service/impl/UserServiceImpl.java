package com.internet.journal.ua.service.impl;

import java.util.List;

import com.internet.journal.ua.dao.UserDao;
import com.internet.journal.ua.dao.impl.UserDaoImpl;
import com.internet.journal.ua.domain.User;
import com.internet.journal.ua.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public void saveUserToDB(User u) {
		userDao.add(u);
		
	}

	@Override
	public List<User> findAllUserFromDB() {
		return userDao.findAll();
	}

	@Override
	public User findUserByIdFromDB(int id) {
		return userDao.findById(id);
	}

	@Override
	public void updateUserByIdInDB(User u) {
		userDao.updateById(u);
	}

	@Override
	public void deleteUserFromDB(int id) {
		userDao.delete(id);
	}

}
