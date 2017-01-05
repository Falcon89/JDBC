package com.internet.journal.ua.service;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import com.internet.journal.ua.service.impl.JournalServiceImpl;

public class JournalServiceImplTest {
	// Посилання на клас JournalServiceImpl
	private static JournalServiceImpl journalService;

	@Test
	public  void JournalServiceTest(){
	int realfind = journalService.findJournalByIdFromDB(1).getId();
	int newfind=(1);
	Assert.assertEquals(realfind, newfind);
	}
	@Test
	public  void JournalServiceTest2(){
		JournalServiceImpl impl = new JournalServiceImpl();

		String impls=impl.getClass().getName();
		String implsn=JournalServiceImpl.class.getName();
		Assert.assertEquals(impls, implsn);
	}
	// Метод помічений даною анотацією відпрацьовує всього раз - перед запуском
		// тестів
	@AfterClass
	public static void tearDown() {
		journalService = null;
	}
}	