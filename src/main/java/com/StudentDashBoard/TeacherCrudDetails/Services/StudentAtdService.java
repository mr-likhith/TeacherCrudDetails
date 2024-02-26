package com.StudentDashBoard.TeacherCrudDetails.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentDashBoard.TeacherCrudDetails.Repository.StudentAtrepo;
import com.StudentDashBoard.TeacherCrudDetails.model.StudentAttendance;

@Service
public class StudentAtdService {
	@Autowired
	private StudentAtrepo repo;
	
	public List<StudentAttendance> listAll()
	{
		return repo.findAll();
	}
	public void saved(StudentAttendance atd)
	{
		repo.save(atd);
	}
	public StudentAttendance get(Long id)
	{
		return repo.findById(id).get();
	}
	public void remove(Long id)
	{
		repo.deleteById(id);
	}
}
