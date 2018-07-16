package com.qburst.service;

import java.util.List;

import com.qburst.dao.thisDao;
import com.qburst.model.StudentData;

public class service {
	thisDao dao = null;
	

	public thisDao getDao() {
		return dao;
	}
	public void setDao(thisDao dao) {
		this.dao = dao;
	}
	public StudentData insertingService(StudentData sdata){
		StudentData result = null;
		try {
			result = dao.insertDataBase(sdata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean deletingService(StudentData sdata){
		boolean result = false;
		try {
			result = dao.deleteRecord(sdata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public StudentData updatingService(StudentData sdata){
		StudentData result = null;
		try {
			result = dao.updateTable(sdata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public boolean loginService(StudentData sdata){
		boolean result = false;
		try {
			result = dao.login(sdata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public List<StudentData> readService(int n){
		List<StudentData> result = null;
		try {
			result = dao.readData(n);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;		
	}
}




