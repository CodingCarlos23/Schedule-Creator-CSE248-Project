package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.CourseFreqList;
import model.CourseList;
import model.InstructorList;

public class Restore {
	public static InstructorList restoreInstructorList() {
		//used to bring back the data saved on drives
		try {
			FileInputStream fis = new FileInputStream("Data/instructorList.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			InstructorList list = (InstructorList) ois.readObject();
			ois.close();
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static CourseList restoreCourseList() {
		//used to bring back the data saved on drives
		try {
			FileInputStream fis = new FileInputStream("Data/courseList.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			CourseList list = (CourseList) ois.readObject();
			ois.close();
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static CourseFreqList restoreCourseFreqList() {
		//used to bring back the data saved on drives
		try {
			FileInputStream fis = new FileInputStream("Data/courseFreq.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			CourseFreqList list = (CourseFreqList) ois.readObject();
			ois.close();
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}
}
