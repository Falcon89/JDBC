package com.internet.journal.ua.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internet.journal.ua.dao.ShopDao;
import com.internet.journal.ua.domain.Shop;
import com.internet.journal.ua.domain.Shop.PaymentStatus;
import com.internet.journal.ua.utils.JDBC_Connect;


public class ShopDaoImpl implements ShopDao {

	// private static final String ADD_NAME_CATALOG = "insert into shop ('name')
	// value (?)";
	// private static final String FIND_NAME_CATALOG_BY_ID = "select * from shop
	// where id=?";
	// private static final String FIND_ALL_CATALOG = "select *from shop";
	// private static final String UPDATE_SHOP_BY_ID = "update shop set name=?
	// where id=?";
	// private static final String DELETE_SHOP_BY_ID = "update shop set
	// isDelited=?, where id=?";
	private java.sql.Connection conn;

	public ShopDaoImpl() {
		conn = JDBC_Connect.getConnection();
	}

	@Override
	public void add(Shop s) {
		System.out.println("open in add method!");
		String query = "insert into user(id,userId,journalId,addDate,paymentStatus)values(?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, s.getId());
			preparedStatement.setInt(2, s.getUserId());
			preparedStatement.setInt(3, s.getJournalId());
			/// ?
			 preparedStatement.setTimestamp(4,s.getAddDate());
			 preparedStatement.setString(4,s.getPaymentStatus().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Shop> findAll() {
		System.out.println("open in findAll method!");
		List<Shop> shops = new ArrayList<Shop>();
		try {
			java.sql.Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select *from shop");
			while (resultSet.next()) {
				Shop shop = new Shop();
				shop.setId(resultSet.getInt("id"));
				shop.setId(resultSet.getInt("userId"));
				shop.setId(resultSet.getInt("journalId"));
				shops.addAll(shops);
				// time
				 shop.setPaymentStatus(PaymentStatus.valueOf(resultSet.getString("paymentStatus")));
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shops;
	}

	@Override
	public Shop findById(int id) {
		System.out.println("open in findById method!");
		Shop shop = new Shop();
		String query = "select * from shop where id=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				shop.setId(resultSet.getInt("id"));
				shop.setId(resultSet.getInt("userId"));
				shop.setId(resultSet.getInt("journalId"));
				// time
				 shop.setPaymentStatus(PaymentStatus.valueOf(resultSet.getString("paymentStatus")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shop;
	}

	@Override
	public void updateById(Shop s) {
		System.out.println("open in updateById method!");
		String query = "update shop set userId=?, journalId=?, addDate=?,paymentStatus=? where id=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, s.getUserId());
			preparedStatement.setInt(2, s.getJournalId());
			 preparedStatement.setTimestamp(3, s.getAddDate());
			 preparedStatement.setString(4, s.getPaymentStatus().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		System.out.println("open in delete method!");
		String query = "delete from shop where id=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
