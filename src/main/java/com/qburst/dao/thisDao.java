package com.qburst.dao;

import java.util.List;

import com.qburst.model.StudentData;

public interface thisDao {
	StudentData insertDataBase(StudentData s);
	boolean deleteRecord(StudentData s);
	StudentData updateTable(StudentData s);
	boolean login(StudentData s);
	List<StudentData> readData(int n);
}