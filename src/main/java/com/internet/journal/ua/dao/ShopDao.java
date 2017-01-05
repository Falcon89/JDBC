package com.internet.journal.ua.dao;

import java.util.List;

import com.internet.journal.ua.domain.Shop;

public interface ShopDao {

	void add(Shop s);

	List<Shop> findAll();

	Shop findById(int id);

	void updateById(Shop s);

	void delete(int id);
}
