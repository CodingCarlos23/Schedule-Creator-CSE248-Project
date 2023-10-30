package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.CourseFreqList;
import model.CourseList;
import model.InstructorList;

public class Backup {
	public static void backupInstructors(InstructorList list) {
		try {
			FileOutputStream fos = new FileOutputStream("Data/instructorList.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void backupCourses(CourseList list) {
		try {
			FileOutputStream fos = new FileOutputStream("Data/courseList.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void backupCourseFreq (CourseFreqList list) {
		try {
			FileOutputStream fos = new FileOutputStream("Data/courseFreq.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
