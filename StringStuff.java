// Import modules.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/** Copyright (c) 2022 Mel Aguoth All rights reserved.
 * Given a string passed as an argument, this function returns the length of the largest
 * run in the string. A "run" is a series of zero or more adjacent characters that are the same.
 *
 * @author  Mel Aguoth
 * @version 11.0.13
 * @since 2022-01-10
 */

class StringStuff {
  public static int maxRun(String theString) {

    // Declare variables.
    int runCount = 1;
    int maxRun = 0;
    char [] theStringArray = theString.toCharArray();

    // Find the maximum run.
    for (int charCounter = 1; charCounter < theStringArray.length; ++charCounter) {
      if (theStringArray[charCounter] == theStringArray[charCounter - 1]) {
        ++runCount;
       	if (runCount > maxRun) {
          maxRun = runCount;
        }
      } else {
        runCount = 1;
      }
    }

    // Return the maximum run.
    return maxRun;
  }

  public static void main(String[] args) {

    try {
      // Declare constants.
      final String runFile = "/home/ubuntu/ICS4U/Assignments/Assign-02/Assign-02-Java/run.txt";

      // Introduce the program.
      System.out.print("This program finds, exports and displays the number of the longest"
                     + " repetition of a character (a.k.a the “run”) when given a string.");

      // Get the user's string.
      Scanner input = new Scanner(System.in);
      System.out.print("\n" + "Enter your string: ");
      String userString = input.next();
      input.close();

      // Call maxRun.
      final int resultRun = maxRun(userString);

      // Write the run to run.txt.
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(runFile));
      bufferedWriter.write("The max run of '" + userString + "' is: " + resultRun);
      bufferedWriter.close();

      // Read and display the run from run.txt.
      String line = null;
      BufferedReader bufferedReader = new BufferedReader(new FileReader(runFile));
      while ((line = bufferedReader.readLine()) != null) {
        System.out.print("\n" + line);
      }
      System.out.print("\n");

    // If the program cannot write to the file, display an error to the user.
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }
}
