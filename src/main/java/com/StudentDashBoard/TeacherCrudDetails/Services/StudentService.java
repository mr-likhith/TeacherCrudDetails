package com.StudentDashBoard.TeacherCrudDetails.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentDashBoard.TeacherCrudDetails.Repository.StudentRepository;
import com.StudentDashBoard.TeacherCrudDetails.model.Student;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public List<Student> listAll()
	{
		return repo.findAll();
	}
	public void save(Student std)
	{
		repo.save(std);
	}
	public Student get(Long id)
	{
		return repo.findById(id).get();
	}
	public void delete(Long id)
	{
		repo.deleteById(id);
	}
 }
