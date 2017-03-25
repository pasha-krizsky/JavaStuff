package task2; 

import java.io.*;
import java.util.*;

public class Solver {

    public static void main(String[] args) throws IOException {
        // New buffer reader object
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // New print writer object
        PrintWriter out   = new PrintWriter(new OutputStreamWriter(System.out));

        // Read line as a string
        String s = in.readLine();
        // Convert line to an array
        String[] arr = s.split(" ");
        // Remove link to the string
        s = null;
        // A set with unique words
        Set<String> uniqueWords = new HashSet<>();
        // Fill the set
        for (String word: arr) {
            uniqueWords.add(word);
        }

        // Array to output
        List<LinkedList<String>> result = new ArrayList<>(arr.length + 1);

        // Initialize the array
        for (int i = 0; i < arr.length + 1; ++i) {
            result.add(new LinkedList<>());
        }

        // Max match and length
        int maxMatch  = 0;
        int maxLength = 0;

        // Count words
        for (String word: uniqueWords) {
            int counter = 0;

            // Count word in array of words
            for (int i = 0; i < arr.length; ++i) {
                if (arr[i].equals(word)) {
                    counter++;
                }
            }

            // Search for max match and max length
            if (counter > maxMatch) {
                maxMatch = counter;
            }
            if (word.length() > maxLength) {
                maxLength = word.length();
            }

            // Add word to result array
            result.get(counter).add(word);
        }

        // Output result
        for (int i = 0; i < result.size(); ++i) {
            for (int j = 0; j < result.get(i).size(); ++j) {
                // Output "_"
                for (int k = 0; k < maxLength - result.get(i).get(j).length(); ++k)
                    out.print("_");

                // Output word and space
                out.print(result.get(i).get(j) + " " );

                // Count and output points
                int numberOfPoints = (int) Math.round((double) i * (double) 10 / (double) maxMatch);
                for (int l = 0; l < numberOfPoints; ++l)
                    out.print(".");

                out.println();
            }
        }

        out.flush();
    }
}