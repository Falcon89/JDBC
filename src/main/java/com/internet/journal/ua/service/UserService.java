package com.internet.journal.ua.service;

import java.util.List;

import com.internet.journal.ua.domain.User;
//CRAD
public interface UserService {
	void saveUserToDB(User u);

	List<User> findAllUserFromDB();

	User findUserByIdFromDB(int id);

	void updateUserByIdInDB(User u);

	void deleteUserFromDB(int id);
}
