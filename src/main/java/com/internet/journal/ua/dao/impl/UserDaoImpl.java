package com.internet.journal.ua.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internet.journal.ua.dao.UserDao;
import com.internet.journal.ua.domain.User;
import com.internet.journal.ua.utils.JDBC_Connect;

public class UserDaoImpl implements UserDao {
	private java.sql.Connection conn;

	public UserDaoImpl() {
		conn = JDBC_Connect.getConnection();
	}

	@Override
	public void add(User u) {
		String query = "insert into user(id,name,nick,age,isDelited)values (?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, u.getId());
			preparedStatement.setString(2, u.getName());
			preparedStatement.setString(3, u.getNick());
			preparedStatement.setInt(4, u.getAge());
			preparedStatement.setBoolean(5, u.isDelited());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String query = "delete from user where id=?";
		try {
			java.sql.PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateById(User u) {
		String query = "update user set name=?,nick=?,age=?,isDelited=? where id=?";
		try {
			java.sql.PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, u.getName());
			preparedStatement.setString(2, u.getNick());
			preparedStatement.setInt(3, u.getAge());
			preparedStatement.setBoolean(4, u.isDelited());
			preparedStatement.setInt(5, u.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		try {
			java.sql.Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user");
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setNick(resultSet.getString("name"));
				user.setAge(resultSet.getInt("age"));
				user.setDelited(resultSet.getBoolean("isDelited"));
				users.add(user);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findById(int id) {
		User user = new User();
		try {
			String query = "select * from user where id=?";
			java.sql.PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setNick(resultSet.getString("name"));
				user.setAge(resultSet.getInt("age"));
				user.setDelited(resultSet.getBoolean("isDelited"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
