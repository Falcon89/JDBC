package com.internet.journal.ua.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internet.journal.ua.dao.JournalDao;
import com.internet.journal.ua.domain.Journal;
import com.internet.journal.ua.domain.Journal.JournalType;
import com.internet.journal.ua.utils.JDBC_Connect;

public class JournalDaoImpl implements JournalDao {
	private java.sql.Connection conn;

	public JournalDaoImpl() {
		conn = JDBC_Connect.getConnection();
	}

	@Override
	public void add(Journal j) {
		String query = "insert into journal(id,name,description,dataCreate,modifJournal,typ,price,isDelited)values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, j.getId());
			preparedStatement.setString(2, j.getName());
			preparedStatement.setString(3, j.getDescription());
			preparedStatement.setTimestamp(4, j.getDataCreate());
			preparedStatement.setTimestamp(5, j.getModifJournal());
			preparedStatement.setString(6, j.getType().toString());
			preparedStatement.setInt(7, j.getPrice());
			preparedStatement.setBoolean(8, j.isDelited());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Journal> findAll() {
		List<Journal> journals = new ArrayList<Journal>();
		try {
			java.sql.Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from journal");
			while (resultSet.next()) {
				Journal journal = new Journal();
				journal.setId(resultSet.getInt("id"));
				journal.setName(resultSet.getString("name"));
				journal.setDescription(resultSet.getString("description"));
				 journal.setDataCreate(resultSet.getTimestamp("dataCreate"));
				 journal.setModifJournal(resultSet.getTimestamp("modifJournal"));
				 journal.setType(JournalType.valueOf(resultSet.getString("type")));
				journal.setId(resultSet.getInt("price"));
				 journal.setDelited(resultSet.getBoolean("isDelited"));
				journals.add(journal);
				
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return journals;
	}

	@Override
	public void updateById(Journal j) {
		String query = "update journal set name=?,description=?,dataCreate=?,modifJournal=?,type=?,price=?,isDelited=? where id=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, j.getName());
			preparedStatement.setString(2, j.getDescription());
			 preparedStatement.setTimestamp(3, j.getDataCreate());
			 preparedStatement.setTimestamp(4, j.getModifJournal());
			 preparedStatement.setString(5, j.getType().toString());
			preparedStatement.setInt(6, j.getPrice());
			preparedStatement.setBoolean(7, j.isDelited());
			preparedStatement.setInt(8, j.getId());
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String query = "delete from journal where id=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Journal findById(int id) {
		Journal journal = new Journal();
		String query = "select *from journal where id=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				journal.setId(resultSet.getInt("id"));
				journal.setName(resultSet.getString("name"));
				journal.setDescription(resultSet.getString("description"));
				 journal.setDataCreate(resultSet.getTimestamp("dataCreate"));
				 journal.setModifJournal(resultSet.getTimestamp("modifJournal"));				 
				 journal.setType(JournalType.valueOf(resultSet.getString("type").toString()));
				journal.setId(resultSet.getInt("price"));
				 journal.setDelited(resultSet.getBoolean("isDelited"));

			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return journal;
	}

}
