package com.internet.journal.ua.service.impl;

import java.util.List;

import com.internet.journal.ua.dao.JournalDao;
import com.internet.journal.ua.dao.impl.JournalDaoImpl;
import com.internet.journal.ua.domain.Journal;
import com.internet.journal.ua.service.JournalService;

public class JournalServiceImpl implements JournalService {
	private JournalDao journalDao = new JournalDaoImpl();

	@Override
	public void saveJournalToDB(Journal j) {
		journalDao.add(j);

	}

	@Override
	public List<Journal> findAllJournalFromDB() {
		return journalDao.findAll();
	}

	@Override
	public Journal findJournalByIdFromDB(int id) {
		return journalDao.findById(id);
	}

	@Override
	public void updateJournalByIdInDB(Journal j) {
		journalDao.updateById(j);

	}

	@Override
	public void deleteJournalFromDB(int id) {
		journalDao.delete(id);

	}

}
