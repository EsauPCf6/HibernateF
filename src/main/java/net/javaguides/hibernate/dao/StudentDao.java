package net.javaguides.hibernate.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.model.Student;
import net.javaguides.hibernate.util.HibernateUtil;

public class StudentDao {
	
	//Guardar estudiante
	//Obtener todos los estudiantes
	//Obtener el ID del estudiante
	//Añadir estudiante
	//Editar estudiante
	//Borrar estudiante
	
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Inicia la transaccion
			transaction = session.beginTransaction();
			
			//Guarda el objeto estudiante
			session.save(student);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	
	public void updateStudent(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Inicia la transaccion
			transaction = session.beginTransaction();
			
			//Guarda el objeto estudiante
			session.saveOrUpdate(student);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	
	public Student getStudentById(Long id) {
		Transaction transaction = null;
		Student student = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Inicia la transaccion
			transaction = session.beginTransaction();
			
			//Guarda el objeto estudiante
			student = session.get(Student.class, id);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
		}
		return student;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		Transaction transaction = null;
		List<Student> students = null;
	try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Inicia la transaccion
			transaction = session.beginTransaction();
			
			//Guarda el objeto estudiante
			students = session.createQuery("from Student").list();
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
		}
		return students;
	}
	
	public void deleteStudent(Long id) {
		Transaction transaction = null;
		Student student = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Inicia la transaccion
			transaction = session.beginTransaction();
			
			student = session.get(Student.class, id);
			//Guarda el objeto estudiante
			session.delete(student);;
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
		}
	}
}
