package model;

import java.io.Serializable;
import java.util.TreeSet;

public class InstructorList implements Serializable {
	 private static InstructorList instance = null;
	    private TreeSet<Instructor> instructors;

	    private InstructorList() {
	        instructors = new TreeSet<>();
	    }

	    public static InstructorList getInstance() {
	        if (instance == null) {
	            instance = new InstructorList();
	        }
	        return instance;
	    }

	    public void addInstructor(Instructor instructor) {
	        instructors.add(instructor);
	    }
	    
	    public void printInstructors() {
	        for (Instructor instructor : instructors) {
	            System.out.println(instructor);
	            instructor.printSchedule();
	            System.out.println();
	        }
	    }

	    public TreeSet<Instructor> getInstructors() {
			return instructors;
		}

		public void setInstructors(TreeSet<Instructor> instructors) {
			this.instructors = instructors;
		}

		public static void setInstance(InstructorList instance) {
			InstructorList.instance = instance;
		}

		public int getSize() {
	        return instructors.size();
	    }
		
		public Instructor getInstructorById(String id) {
	    	id = id.trim();

		    for (Instructor instructor : instructors) {
		    	String idNo = instructor.getIdNo().trim();
		        if (idNo.equals(id)) {
		            return instructor;
		        }
		    }
		    return null; // return null if no instructor with the given ID is found
		}
}
