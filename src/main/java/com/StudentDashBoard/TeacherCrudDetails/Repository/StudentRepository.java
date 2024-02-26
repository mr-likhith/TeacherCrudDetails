package com.StudentDashBoard.TeacherCrudDetails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentDashBoard.TeacherCrudDetails.model.Student;
import com.StudentDashBoard.TeacherCrudDetails.model.StudentAttendance;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
	
}

