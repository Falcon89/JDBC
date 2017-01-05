package com.internet.journal.ua;

import java.sql.SQLException;
import java.util.List;

import com.internet.journal.ua.domain.Journal;
import com.internet.journal.ua.domain.Journal.JournalType;
import com.internet.journal.ua.domain.Shop;
import com.internet.journal.ua.domain.Shop.PaymentStatus;
import com.internet.journal.ua.domain.User;
import com.internet.journal.ua.service.JournalService;
import com.internet.journal.ua.service.ShopService;
import com.internet.journal.ua.service.UserService;
import com.internet.journal.ua.service.impl.JournalServiceImpl;
import com.internet.journal.ua.service.impl.ShopServiceImpl;
import com.internet.journal.ua.service.impl.UserServiceImpl;
import com.internet.journal.ua.utils.JDBC_Connect;

public class Application {

	public static void main(String[] args) {
		// виклик JDBC_Connect
		JDBC_Connect jdbc_Connect = new JDBC_Connect();
		try {
			jdbc_Connect.initDataBase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//
		UserService userServiceImpl = new UserServiceImpl();
		// Створюємо обєкт user для того щоб зберегти його в БД
		User user = new User();
		user.setName("ALADIN");
		user.setAge(50);
		user.setId(2);
		// Зберігаємо обєкт person в БД
		userServiceImpl.saveUserToDB(user);

		// Витягуємо з БД обєкт з id=4
		User user2 = userServiceImpl.findUserByIdFromDB(3);
		// Виводимо інформацію про даний обєкт на консоль
		System.out.println(user2);

		// Видаляємо обєкт з id=6 з БД
		userServiceImpl.deleteUserFromDB(6);

		// Записуєм дані в модель user, щоб оновити дані обєкта з id=1 в БД
		// user.setNick("journals");
		// user.setId(10);

		// Оновлюємо дані
		userServiceImpl.updateUserByIdInDB(user);

		// Витягуємо з БД всі обєкти класу Person
		System.out.println("User");
		List<User> listOfAllShop = userServiceImpl.findAllUserFromDB();
		// Виводимо інформацію про всі обєкти на консоль
		for (User user3 : listOfAllShop) {
			System.out.println(user3);
		}
		//
		System.out.println("Shop");
		ShopService shopServiceImpl = new ShopServiceImpl();
		// Створюємо обєкт shop для того щоб зберегти його в БД
		Shop shop = new Shop();
		shop.setJournalId(2);
		shop.setPaymentStatus(PaymentStatus.ADDED_TO_BUCKET);
		// Зберігаємо обєкт person в БД
		shopServiceImpl.saveShopToDB(shop);
		// Витягуємо з БД обєкт з id=4
		Shop shop2=shopServiceImpl.findShopByIdFromDB(4);
		// Виводимо інформацію про даний обєкт на консоль
		System.out.println(shop2);
		// Оновлюємо дані
		shopServiceImpl.updateShopByIdInDB(shop);
		// Витягуємо з БД всі обєкти класу Person
		List<Shop> shops = shopServiceImpl.findAllShopFromDB();
		// Виводимо інформацію про всі обєкти на консоль
		for (Shop shop3 : shops) {
			System.out.println(shop3);
		}

		System.out.println("Jurnal");
		JournalService journalService = new JournalServiceImpl();
		Journal journal = new Journal();
		journal.setName("newJournal");
		journal.setId(5);
		journal.setPrice(680);
		journal.setType(JournalType.MUSIC);
		journalService.saveJournalToDB(journal);
		// Витягуємо з БД обєкт з id=8
		Journal journal2 = journalService.findJournalByIdFromDB(8);
		// Виводимо інформацію про даний обєкт на консоль
		System.out.println(journal2);
		// Оновлюємо дані
		journalService.updateJournalByIdInDB(journal);
		// Витягуємо з БД всі обєкти класу Person
		List<Journal> journals = journalService.findAllJournalFromDB();
		// Виводимо інформацію про всі обєкти на консоль
		for (Journal journal3 : journals) {
			System.out.println(journal3);
		}
	}

}
