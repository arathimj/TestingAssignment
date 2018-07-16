package com.qburst.daotest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qburst.dao.thisDao;
import com.qburst.model.StudentData;
import com.qburst.service.service;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class DAOTest {
	StudentData sdata = new StudentData();
	StudentData sdata1 = new StudentData();
	StudentData sdata2 = new StudentData();
	StudentData sdata3 = new StudentData();
	
	thisDao dao = Mockito.mock(thisDao.class);
	
	service s = new service();
	
	
	@Test
	public void insertionTest() {
		try {
			s.setDao(dao);
			sdata.setFirstName("Emily");
			sdata.setLastName("Grant"); 
			sdata.setEmail("emily@gmail.com"); 
			sdata.setPassword("hithereu"); 
			sdata.setSex("F");
			when(dao.insertDataBase(sdata)).thenReturn(sdata);
			StudentData result = s.insertingService(sdata);
			assertSame(sdata, result);
			verify(dao).insertDataBase(sdata);
			
			sdata1.setFirstName("Emily");
			sdata1.setLastName("Grant"); 
			sdata1.setEmail("emily@gmail.com"); 
			sdata1.setPassword("hithereu"); 
			sdata1.setSex("F");
			when(dao.insertDataBase(sdata1)).thenReturn(sdata);
			StudentData result1 = s.insertingService(sdata1);
			assertNotSame(sdata1, result1);
			verify(dao).insertDataBase(sdata1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void deletionTest() {
		try {
			s.setDao(dao);
			sdata.setEmail("emily@gmail.com");
			sdata.setPassword("hithereu");
			when(dao.deleteRecord(sdata)).thenReturn(false);
			boolean result = s.deletingService(sdata);
			assertFalse(result);
			verify(dao).deleteRecord(sdata);
			
			sdata1.setEmail("ana@gmail.com");
			sdata1.setPassword("hithereu");
			when(dao.deleteRecord(sdata1)).thenReturn(true);
			boolean result1 = s.deletingService(sdata1);
			assertTrue(result1);
			verify(dao).deleteRecord(sdata1);
		}
		catch(Exception e){
			
		}
	}
	
	@Test
	public void updationTest() {
		try {
			s.setDao(dao);
			sdata.setStudentID(1);
			sdata.setFirstName("Emily");
			sdata.setLastName("Bourne"); 
			sdata.setEmail("emily@gmail.com"); 
			sdata.setPassword("hithereu"); 
			sdata.setSex("F");
			when(dao.updateTable(sdata)).thenReturn(sdata);
			StudentData result = s.updatingService(sdata);
			assertSame(sdata, result);
			verify(dao).updateTable(sdata);
			/*
			sdata.setStudentID(2);
			sdata.setFirstName("Jason");
			sdata.setLastName("Storm"); 
			sdata.setEmail("emily@gmail.com"); 
			sdata.setPassword("hithereu"); 
			sdata.setSex("F");
			when(dao.updateTable(sdata)).thenReturn(sdata);
			StudentData result = s.updatingService(sdata);
			assertSame(sdata, result);
			verify(dao).updateTable(sdata);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void loginTest() {
		try {
			s.setDao(dao);
			sdata.setEmail("emily@gmail.com");
			sdata.setPassword("hithereu");
			when(dao.login(sdata)).thenReturn(true);
			boolean result = s.loginService(sdata);
			assertTrue(result);
			verify(dao).login(sdata);
			
			sdata1.setEmail("emily@gmail.com");
			sdata1.setPassword("hithere");
			when(dao.login(sdata1)).thenReturn(false);
			boolean result1 = s.loginService(sdata1);
			assertFalse(result1);
			verify(dao).login(sdata1);
			
			sdata2.setEmail("emi@gmail.com");
			sdata2.setPassword("hithereu");
			when(dao.login(sdata2)).thenReturn(false);
			boolean result2 = s.loginService(sdata2);
			assertFalse(result2);
			verify(dao).login(sdata2);
			
			sdata3.setEmail("ana@gmail.com");
			sdata3.setPassword("hithereu");
			when(dao.login(sdata3)).thenReturn(false);
			boolean result3 = s.loginService(sdata3);
			assertFalse(result3);
			verify(dao).login(sdata3);
		}
		catch(Exception e){
			
		}
	}
	
	@Test
	public void readTest() {
		try {
			s.setDao(dao);
			
			List<StudentData> list1 = new ArrayList<StudentData>();
			
			StudentData sdata1 = new StudentData();
			StudentData sdata2 = new StudentData();
			StudentData sdata3 = new StudentData();
			
			sdata1.setStudentID(1);
			sdata1.setFirstName("Emily");
			sdata1.setLastName("Grant"); 
			sdata1.setEmail("emily@gmail.com"); 
			sdata1.setPassword("hithereu"); 
			sdata1.setSex("F");
			list1.add(sdata1);
			
			sdata2.setStudentID(2);
			sdata2.setFirstName("Chris");
			sdata2.setLastName("Helmsworth"); 
			sdata2.setEmail("chris@gmail.com"); 
			sdata2.setPassword("hithereu"); 
			sdata2.setSex("M");
			list1.add(sdata2);
			
			sdata3.setStudentID(3);
			sdata3.setFirstName("Ethan");
			sdata3.setLastName("Kavanagh"); 
			sdata3.setEmail("ethan@gmail.com"); 
			sdata3.setPassword("hithereu"); 
			sdata3.setSex("M");
			list1.add(sdata3);
			
			List<StudentData> list2 = new ArrayList<StudentData>();
			
			when(dao.readData(1)).thenReturn(list1);
			List<StudentData> result1 = s.readService(1);
			assertSame(list1, result1);
			verify(dao).readData(1);
			
			when(dao.readData(9)).thenReturn(list2);
			List<StudentData> result2 = s.readService(9);
			assertSame(list2, result2);
			verify(dao).readData(9);
			
		} catch(Exception e) {
			
		}
		
	}
}
