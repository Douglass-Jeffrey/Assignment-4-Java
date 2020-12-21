/*
* This program receives and outputs information about a triangle when prompted.
*
* @author  Douglass Jeffrey
* @version 1.0
* @since   2020-12-17
*/

// Import the Scanner class
import java.util.Scanner;

public class TriangleMain {

  /**
  * This program receives and outputs information about a triangle
  * when prompted.
  */

  public static void main(String[] args) {

    // create scanner object for doubles
    Scanner userInput = new Scanner(System.in);
    
    // create scanner object for strings
    Scanner userStr = new Scanner(System.in);
    
    // initializing triangle from triangle class
    Triangle triangle = new Triangle();
    
    // try to catch any errors
    try {
      // print triaggle image and explain program to user
      System.out.println("                  Angle A                "
                          + '\n' + "                    /\\                  "
                          + '\n' + "                   /  \\                 "
                          + '\n' + "                  /    \\                "
                          + '\n' + "          side c /      \\ side b        "
                          + '\n' + "                /        \\              "
                          + '\n' + "               /          \\             "
                          + '\n' + "              /            \\            "
                          + '\n' + "     Angle B /______________\\ Angle C   "
                          + '\n' + "                  side a                 "
                          + '\n');
            
      System.out.println("Welcome to the Triangle information program. Specify " 
                         + "which 3 values you will input by first writing "
                         + "their names as specified in the diagram above then "
                         + "inputting their value on the next line. Side "
                         + "lengths will be measured in cm and angles in "
                         + "degrees.");
      
      // prompt user to enter an input type
      System.out.println("Enter the type of your first input "
                        + "('side a/b/c' or 'angle a/b/c'): ");
      String typeInputOneLow = userStr.nextLine();
      String typeInputOne = typeInputOneLow.toUpperCase();

      // prompt user to enter their input
      System.out.println("Enter the value of your first input: ");
      double inputOne = userInput.nextDouble();
      System.out.println();
      
      // prompt user to enter an input type
      System.out.println("Enter the type of your second input "
                        + "('side a/b/c' or 'angle a/b/c'): ");
      String typeInputTwoLow = userStr.nextLine();
      String typeInputTwo = typeInputTwoLow.toUpperCase();

      // prompt user to enter their input
      System.out.println("Enter the value of your second input: ");
      double inputTwo = userInput.nextDouble();
      System.out.println();

      // prompt user to enter an input type
      System.out.println("Enter the type of your third input "
                        + "('side a/b/c' or 'angle a/b/c'): ");
      String typeInputThreeLow = userStr.nextLine();
      String typeInputThree = typeInputThreeLow.toUpperCase();

      // prompt user to enter their input
      System.out.println("Enter the value of your Three input: ");
      double inputThree = userInput.nextDouble();
      System.out.println();
      
      
      // Catches if user chooses same side or angle and if there are 3 angles
      if (typeInputOne.equals(typeInputTwo) 
          || typeInputTwo.equals(typeInputThree) 
          || typeInputThree.equals(typeInputOne) 
          || typeInputOne.contains("ANGLE") && typeInputTwo.contains("ANGLE") 
          && typeInputThree.contains("ANGLE")) {

        // if any of these are caught, throw null to cause error catch
        throw null;
      } else {

        // sort the options to find what sides and angles were inputted
        System.out.println(triangle.sortOptions(typeInputOne, typeInputTwo,
                           typeInputThree, inputOne, inputTwo, inputThree));
      }
      
      // calls methods that gain new information about the triangles
      System.out.println(triangle.firstSort());
      System.out.println(triangle.secondSort());

      //calculates perimeter value
      System.out.println("Finding perimeter...");
      triangle.perimeterSet();
      
      //calculates area value
      System.out.println("Finding area....");
      triangle.areaFinder();
      System.out.println();
      
      // telling user triangle type:
      System.out.println(triangle.getType());
      System.out.println();

      // telling the user the area of the triangle
      System.out.println("Area of triangle: " + triangle.areaGetter()
                         + " cm^2");
      System.out.println();
      
      // telling the user the perimeter of the triangle
      System.out.println("Perimeter of triangle: " + triangle.perimeterGetter() 
                         + " cm:");
      System.out.println();
      
      // finds triangle height
      System.out.println("Triangle Height: " + triangle.heightFinder());
      System.out.println();
      
      // finds inradius
      System.out.println("Inradius of the circle: " + triangle.inradius());
      System.out.println();
      
      // finds circumradius
      System.out.println("Circumradius of the circle: " 
                         + triangle.circumradius());
      System.out.println();
      
      // this calls a function that can be used to check values.
      //it is commented out because it is only needed to check
      //System.out.println(triangle.valueOutputter());


    // catch for general problems like bad user inputs
    } catch (Exception e) {
      System.out.println("Invalid Input");
    }
  }
}
