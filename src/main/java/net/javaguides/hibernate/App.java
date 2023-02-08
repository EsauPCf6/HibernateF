package net.javaguides.hibernate;

import java.util.List;

import net.javaguides.hibernate.dao.StudentDao;
import net.javaguides.hibernate.model.Student;

public class App {
	
	public static void main (String[] args) { 
		StudentDao studentDao = new StudentDao();
		
		Student student = new Student("Esau","Perez","esaupc100@hotmail.com");
		studentDao.saveStudent(student);
		
		//student.setFirstName("Ramirez");
		//studentDao.updateStudent(student);
		
		//Student student2 = studentDao.getStudentById(student.getId());
		
		//List<Student> students = studentDao.getAllStudents();
		//students.forEach(student1 -> System.out.println(student1.getId()));
		
		//studentDao.deleteStudent(student.getId());
		
	}

}
