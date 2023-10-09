package model;

import java.util.LinkedList;

public class CourseList {
	private static CourseList instance = null;
	private LinkedList<Course> courses;
	private CourseList() {
		courses = new LinkedList<Course>();
	}
	
	public static CourseList getInstance() {
		if (instance == null) {
			instance = new CourseList();
		}
		return instance;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public void printCourses() {
		for(Course course : courses) {
			System.out.println(course);
			System.out.println();
		}
	}
	
	
	
	public LinkedList<Course> getCourses() {
		return courses;
	}

	public void setCourses(LinkedList<Course> courses) {
		this.courses = courses;
	}
	
	public static void setInstance(CourseList instance) {
		CourseList.instance = instance;
	}
	
	public int getSize() {
        return courses.size();
    }
}
