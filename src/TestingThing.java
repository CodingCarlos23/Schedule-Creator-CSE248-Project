import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestingThing {
    public static void main(String[] args) {
        String csvFile = "Data/Instructors.csv"; // Replace with the path to your CSV file
        List<List<String>> result = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        int consecutiveNullLines = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    // Empty line found
                    consecutiveNullLines++;
                    if (consecutiveNullLines >= 4) {
                        break; // Stop after four consecutive null lines
                    }
                } else {
                	String[] cells = line.split(",",-1);
                	// THE ISSUE IS IT IS NOT ADDING THE BLANKS THAT WHY IT IS NOT ALLINGING FIGURE OUT HOW TO ADD BLANKS IF NOT BUFFER THEN APPACHE
                    for (String cell : cells) {
                        currentList.add(cell);
                    }

                    // Check for the marker "—"
                    if (line.contains("â€”")) {
                        // Marker found, add the current list to the result and create a new list
                        if (!currentList.isEmpty()) {
                        	System.out.println(currentList.size());
                            result.add(currentList);
                            //add INSTRUCTOR HERE
                            currentList = new ArrayList<>();
                        }
                    }

                    consecutiveNullLines = 0; // Reset the count of consecutive null lines
                }
            }

            // Add the last currentList to the result
            if (!currentList.isEmpty()) {
                result.add(currentList);
            }

            // Find the maximum row length
            int maxRowLength = 0;
            for (List<String> list : result) {
                maxRowLength = Math.max(maxRowLength, list.size());
            }

            // Pad shorter rows to make them equal in length with empty strings
            for (List<String> list : result) {
                while (list.size() < maxRowLength) {
                    list.add(""); // Add empty strings for empty cells
                }
            }

            // Determine the column widths
            int[] columnWidths = new int[maxRowLength];
            for (List<String> list : result) {
                for (int i = 0; i < list.size(); i++) {
                    columnWidths[i] = Math.max(columnWidths[i], list.get(i).length());
                }
            }

            // Print the result with proper alignment
            for (List<String> list : result) {
                for (int i = 0; i < list.size(); i++) {
                    String cell = list.get(i);
                    System.out.print(String.format("%-" + (columnWidths[i] + 2) + "s", cell)); // Add 2 for padding
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Done");
    }
}
