package com.internet.journal.ua.dao;

import java.util.List;

import com.internet.journal.ua.domain.Journal;

public interface JournalDao {

	void add(Journal j);

	List<Journal> findAll();

	Journal findById(int id);

	void updateById(Journal j);

	void delete(int id);
}
