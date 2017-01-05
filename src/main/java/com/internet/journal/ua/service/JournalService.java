package com.internet.journal.ua.service;

import java.util.List;

import com.internet.journal.ua.domain.Journal;

//CRAD
public interface JournalService {
	void saveJournalToDB(Journal j);

	List<Journal> findAllJournalFromDB();

	Journal findJournalByIdFromDB(int id);

	void updateJournalByIdInDB(Journal j);

	void deleteJournalFromDB(int id);
}
