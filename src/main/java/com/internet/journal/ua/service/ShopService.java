package com.internet.journal.ua.service;

import java.util.List;

import com.internet.journal.ua.domain.Shop;
//CRAD
public interface ShopService {

	void saveShopToDB(Shop s);

	List<Shop> findAllShopFromDB();

	Shop findShopByIdFromDB(int id);

	void updateShopByIdInDB(Shop s);

	void deleteShopFromDB(int id);
}
