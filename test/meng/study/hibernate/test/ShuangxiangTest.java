package meng.study.hibernate.test;

import meng.study.hibernate.shuangxiang.*;
import meng.study.hibernate.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class ShuangxiangTest {

	/**
	 * 双向关联
	 */
	@Test
	public void testSave() {
		Grade grade = new Grade("物联网14", "**学院2014级物联网工程");
		Student stu1 = new Student("王丽", "女");
		Student stu2 = new Student("王五", "男");
		stu1.setGrade(grade);
		stu2.setGrade(grade);
		grade.getStudents().add(stu1);
		grade.getStudents().add(stu2);

		Session session = HibernateUtils.getSession();
		// 开启事务
		Transaction transaction = session.beginTransaction();
		session.save(grade);//级联操作
//		session.save(stu1);
//		session.save(stu2);
		// 提交事务
		transaction.commit();
		HibernateUtils.closeSession(session);
	}
	
	@Test
	public void testSelect() {
		Session session = HibernateUtils.getSession();
		Grade grade = (Grade)session.get(Grade.class, 1);
		System.out.println(grade);
		Student student = (Student)session.get(Student.class, 1);
		System.out.println(student);
		HibernateUtils.closeSession(session);
	}
	
	@Test
	public void testUpdate() {
		Grade grade = new Grade("软件13", "**学院2013级软件工程");
		Session session = HibernateUtils.getSession();
		// 开启事务
		Transaction transaction = session.beginTransaction();
		Student student = (Student)session.get(Student.class, 1);
		student.setGrade(grade);
		session.save(grade);
		// 提交事务
		transaction.commit();
		HibernateUtils.closeSession(session);
	}
	
	

}
