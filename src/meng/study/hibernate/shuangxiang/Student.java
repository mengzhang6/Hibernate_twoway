package meng.study.hibernate.shuangxiang;

import java.io.Serializable;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sid;
	private String sname;
	private String sex;
	private Grade grade = new Grade();
	//对班级的引用
	public Student(String sname, String sex) {
		this.sname = sname;
		this.sex = sex;
	}

	public Student() {
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sex=" + sex
				+ ", grade=" + grade.getGid() + ":" + grade.getGname() + ":"
				+ grade.getGdesc() + "]";
	}

}
