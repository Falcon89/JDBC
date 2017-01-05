package com.internet.journal.ua.service.impl;

import java.util.List;

import com.internet.journal.ua.dao.ShopDao;
import com.internet.journal.ua.dao.impl.ShopDaoImpl;
import com.internet.journal.ua.domain.Shop;
import com.internet.journal.ua.service.ShopService;

public class ShopServiceImpl implements ShopService {
	private ShopDao shopDao = new ShopDaoImpl();

	@Override
	public void saveShopToDB(Shop s) {
		shopDao.add(s);

	}

	@Override
	public List<Shop> findAllShopFromDB() {
		return shopDao.findAll();
	}

	@Override
	public Shop findShopByIdFromDB(int id) {
		return shopDao.findById(id);
	}

	@Override
	public void updateShopByIdInDB(Shop s) {
		shopDao.updateById(s);

	}

	@Override
	public void deleteShopFromDB(int id) {
		shopDao.delete(id);

	}

}
