package p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Demo {
	public static void main(String[] args) {
		String csvFile = "C:\\Users\\carlo\\Desktop\\Instructors.csv";
		String line = "";
		String cvsSplitBy = "\t";
		boolean found = false;
		int count = 0;
        TreeSet<Instructor> instructorsList = new TreeSet<>(); // tree set is good for large data and finds things fast
		//ArrayList<Instructor> instructorsList = new ArrayList<Instructor>();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			ArrayList<String[]> list = null;
			while ((line = br.readLine()) != null) {
				if (found) {

					for (int i = 0; i < 5; i++) {
						//
						String[] values = line.split(",");
						if (list == null) {
							list = new ArrayList<String[]>();
						}
						list.add(values);
						//

						// System.out.println(line);
						count++;
						if (count == 4) {
							String[] empt = { " ", " ", " ", " ", " ", " ", " ", " ", " " };

							for (String[] array : list) {
								// System.out.println(Arrays.toString(array));
							}
							//
							// cant do sun because out of bounds will fix later
							// add code to detect sun
							Instructor instructor = new Instructor(list.get(0)[0], list.get(1)[0], list.get(2)[0],
									list.get(0)[1] + "," + list.get(0)[2], list.get(1)[1],
									list.get(2)[1] + "," + list.get(2)[2], list.get(0)[3], list.get(1)[2],
									list.get(2)[3] + " " + list.get(3)[2], list.get(0)[4], list.get(0)[5],
									list.get(0)[6], list.get(0)[7], list.get(1)[6], list.get(0)[8],
									list.get(0)[9] + " " + list.get(1)[8], list.get(0)[10], list.get(0)[11],
									list.get(1)[8], list.get(0)[12], list.get(0)[13], list.get(0)[14], list.get(0)[15]);
							instructorsList.add(instructor);
							list = new ArrayList<String[]>();
							//
							count = 0;
							found = false;
							// break;//////////////////////////////////////change delte this
						}
					}
				} else {
					String[] values = line.split(cvsSplitBy);
					for (String value : values) {
						if (value.contains("—")) {
							found = true;
							break;
						}
					}
				}
			}

//            if(list != null) {
//            	Instructor instructor = new Instructor(list.get(0)[0], list.get(1)[0], list.get(2)[0], list.get(0)[1]+ "," + list.get(0)[2], list.get(1)[1], list.get(2)[1] + "," + list.get(2)[2], list.get(0)[3], list.get(1)[2], list.get(2)[3] + " " + list.get(3)[2], list.get(0)[4], list.get(0)[5], list.get(0)[6], list.get(0)[7], list.get(1)[6], list.get(0)[8], list.get(0)[9] + " " + list.get(1)[8], list.get(0)[10], list.get(0)[11], list.get(1)[8], list.get(0)[12], list.get(0)[13], list.get(0)[14], list.get(0)[15]);
//            	instructorsList.add(instructor);
//            	list = new ArrayList<String[]>();
//            }

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println();
		for (Instructor instructor : instructorsList) {
			System.out.println(instructor);
		}
		
		int size = instructorsList.size();
		System.out.println("The size of the TreeSet is: " + size);
	}
}
