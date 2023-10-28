package model;

import java.util.LinkedList;
import java.util.List;

public class CourseFreqList {
    private static CourseFreqList instance = null;
    private LinkedList<List<String>> courseFreq;

    private CourseFreqList() {
        courseFreq = new LinkedList<>();
    }

    public static CourseFreqList getInstance() {
        if (instance == null) {
            instance = new CourseFreqList();
        }
        return instance;
    }

    public void addCourse(List<String> course) {
        courseFreq.add(course);
    }

    public void printCourses() {
        for(List<String> course : courseFreq) {
            System.out.println(course);
            System.out.println();
        }
    }

    public LinkedList<List<String>> getCourses() {
        return courseFreq;
    }

    public void setCourses(LinkedList<List<String>> courses) {
        this.courseFreq = courses;
    }

    public static void setInstance(CourseFreqList instance) {
        CourseFreqList.instance = instance;
    }

    public int getSize() {
        return courseFreq.size();
    }
}
