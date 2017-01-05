package com.internet.journal.ua.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class JDBC_Connect {
	private static final String URL = "jdbc:mysql://localhost/Internet_shop_journal";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static boolean INIT_DATABASE_WITH_DATA = false;
	// JDBC variables for opening and managing connection
	private static Connection con;

	public JDBC_Connect() {
		if (INIT_DATABASE_WITH_DATA) {
			try {
				initDataBase();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection() {
		if (con == null) {
			try {
				con = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	public void initDataBase() throws SQLException {
		// определения JDBC
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
		// Створення з'єдднання з MySQL
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// connection
		Connection connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("Aaccess");
		//
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(
				"create table if not exists shop (id int(10), userId int (10),journalId int(10), addDate timestamp, paymentStatus varchar(10))");
		preparedStatement.execute();
		//
		preparedStatement = (PreparedStatement) connection
				.prepareStatement("insert into shop(id,userId, journalId, addDate, paymentStatus)values"
						+ "(1,2,1,'2015-12-28 15:02:14','PAYED')," + "(2,3,2,'2015-12-30 13:02:14','PAYED'),"
						+ "(3,4,2,'2016-10-25 10:02:14','PAYED')," + "(4,5,3,'2016-10-25 10:02:14','PAYED'),"
						+ "(5,5,1,'2014-09-28 15:10:14','PAYED')," + "(6,6,2,'2014-09-29 13:02:14','PAYED'),"
						+ "(7,7,2,'2013-06-23 12:02:25','PAYED')," + "(8,8,4,'2013-06-24 13:02:14','PAYED'),"
						+ "(9,9,1,'2016-12-20 16:02:14','PAYED')," + "(10,10,2,'2016-10-12 13:02:14','PAYED'),"
						+ "(11,10,1,'2017-09-15 22:02:19','PAYED')," + "(12,3,3,'2017-10-12 13:02:14','PAYED')");
		preparedStatement.execute();
		PreparedStatement preparedStatement2 = (PreparedStatement) connection.prepareStatement(
				"create table if not exists user(id int (10), name varchar(10), nick varchar(10),age int(10),isDelited bit)");
		preparedStatement2.execute();
		preparedStatement2 = (PreparedStatement) connection
				.prepareStatement("insert into user(id, name, nick, age, isDelited)values" + "(1,'jumm','jumm90',18,1),"
						+ "(2,'gerry','gerry91',19,0)," + "(3,'igor','igor89',23,0)," + "(4,'ivan','ivankop',20,1),"
						+ "(5,'stepan','stapan',26,1)," + "(6,'andrey','andch',22,1)," + "(7,'mykola','mykoll55',19,0),"
						+ "(8,'sergey','serg',23,0)," + "(9,'inna','nanna89',40,1)," + "(10,'vika','viki88',43,0),"
						+ "(11,'galina','gali89',46,0)," + "(12,'josef','ser21',20,1)");
		preparedStatement2.execute();

		PreparedStatement preparedStatement3 = (PreparedStatement) connection.prepareStatement(
				"create table if not exists journal(id int(10), name varchar(10), description varchar(20),dataCreate timestamp ,modifJournal timestamp,type  varchar(20) ,price int(10),isDelited bit)");
		preparedStatement3.execute();
		preparedStatement3 = (PreparedStatement) connection.prepareStatement(
				"insert into journal (id,name,description,dataCreate, modifJournal,type,price,isDelited)values"
						+ "(1,'maxim','journal','2015-12-28 15:02:14','2016-12-28 16:02:14' ,'MUSIC',100,1),"
						+ "(2,'misic','retro','2015-12-28 15:02:14','2015-12-29 15:02:14','MUSIC',250,1),"
						+ "(3,'car','carsinfo','2015-12-28 15:02:14','2015-12-29 15:02:14','CARS',530,1),"
						+ "(4,'maxim','redactio','2015-12-28 15:02:14','2015-12-29 15:02:14','MOVIES',200,1),"
						+ "(5,'car','carsinfo','2015-12-28 15:02:14','2015-12-29 15:02:14','CARS',510,0),"
						+ "(6,'car','carsinfo','2015-12-28 15:02:14','2015-12-29 15:02:14','CARS',450,1),"
						+ "(7,'misic','retro','2015-12-28 15:02:14','2015-12-29 15:02:14','MUSIC',200,0),"
						+ "(8,'car','carsinfo','2015-12-28 15:02:14','2015-12-29 15:02:14','CARS',500,1),"
						+ "(9,'maxim','newjournal','2015-12-28 15:02:14','2015-12-29 15:02:14','MOVIES',200,0)");
		preparedStatement3.execute();

		System.out.println("Commodity BD");

	}

}
