package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entyties.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {
		
		Integer i=(Integer)this.hibernateTemplate.save(student);
		return 1;
	}
// get single data(object)
		public Student getStudent(int studentId) {
			Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
		}
		
		// get all data(all row)
		public List<Student> getAllStudents(){
			List<Student> student = this.hibernateTemplate.loadAll(Student.class);
			return student;
		}
		//delete the data
		@Transactional
		public void deleteStudent(int studentId) {
			Student student = this.hibernateTemplate.get(Student.class, studentId);
			this.hibernateTemplate.delete(student);
		}
		
		//updating data
		@Transactional
		public void updateStudent(Student student) {
			this.hibernateTemplate.update(student);
		}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

}
