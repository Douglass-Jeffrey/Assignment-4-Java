/* 
* This class holds information about a vehicle.
*
* @author  Douglass Jeffrey
* @version 1.0
* @since   2020-12-17
*/

public class Triangle {
  // Initializing fields
  private double angleA;
  private double angleB;
  private double angleC;
  private double sideA;
  private double sideB;
  private double sideC;
  private double area;
  private double perimeter;
  private String triangleType;

  /**
   * Setting field values with a constructor.
   */
  public Triangle() {
    this.angleA = 0;
    this.angleB = 0;
    this.angleC = 0;
    this.sideA = 0;
    this.sideB = 0;
    this.sideC = 0;
    this.area = 0;
    this.perimeter = 0;
    this.triangleType = "";
  }


  /**
   * Method for sorting inputs and finding what the user truly inputted.
   */
  public String sortOptions(String typeInputOne, String typeInputTwo,
                            String typeInputThree, double inputOne,
                            double inputTwo, double inputThree) {
    
    // checks all inputs for first input
    if (typeInputOne.equals("SIDE A")) {
      this.sideA = inputOne;
    } else if (typeInputOne.equals("SIDE B")) {
      this.sideB = inputOne;
    } else if (typeInputOne.equals("SIDE C")) {
      this.sideC = inputOne;
    } else if (typeInputOne.equals("ANGLE A")) {
      this.angleA = inputOne * Math.PI / 180;
    } else if (typeInputOne.equals("ANGLE B")) {
      this.angleB = inputOne * Math.PI / 180;
    } else if (typeInputOne.equals("ANGLE C")) {
      this.angleC = inputOne * Math.PI / 180;
    } else {
      throw null;
    }
    
    // checks all inputs for second input
    if (typeInputTwo.equals("SIDE A")) {
      this.sideA = inputTwo;
    } else if (typeInputTwo.equals("SIDE B")) {
      this.sideB = inputTwo;
    } else if (typeInputTwo.equals("SIDE C")) {
      this.sideC = inputTwo;
    } else if (typeInputTwo.equals("ANGLE A")) {
      this.angleA = inputTwo * Math.PI / 180;
    } else if (typeInputTwo.equals("ANGLE B")) {
      this.angleB = inputTwo * Math.PI / 180;
    } else if (typeInputTwo.equals("ANGLE C")) {
      this.angleC = inputTwo * Math.PI / 180;
    } else {
      throw null;
    }
    
    // checks all inputs for third input
    if (typeInputThree.equals("SIDE A")) {
      this.sideA = inputThree;
    } else if (typeInputThree.equals("SIDE B")) {
      this.sideB = inputThree;
    } else if (typeInputThree.equals("SIDE C")) {
      this.sideC = inputThree;
    } else if (typeInputThree.equals("ANGLE A")) {
      this.angleA = inputThree * Math.PI / 180;
    } else if (typeInputThree.equals("ANGLE B")) {
      this.angleB = inputThree * Math.PI / 180;
    } else if (typeInputThree.equals("ANGLE C")) {
      this.angleC = inputThree * Math.PI / 180;
    } else {
      throw null;
    }
    return ("Inputs sorted");
  }
  
  
  /**
   * Method to find take about a given triangle and derive more
   * information from it. the reason that there are two functions for this is 
   * so that the program doesnt become too laggy.
   */
  public String firstSort() {
    // assesses the information and determines which method to call to get more
    if ((sideA > 0 && angleA > 0 && (angleB > 0 || angleC > 0))) {
      //checks angle b
      if (angleB > 0) {
        this.sideB = sinLawSide(sideA, angleA, angleB);
      
      //checks angle c
      } else if (angleC > 0) {
        this.sideC = sinLawSide(sideA, angleA, angleC);
        
      } else {
        throw null;
      }
    
    //checks if it can use side sin law for c or a
    } else if ((sideB > 0 && angleB > 0 && (angleA > 0 || angleC > 0))) {

      //checks angle A
      if (angleA > 0) {
        this.sideA = sinLawSide(sideB, angleB, angleA);
      
      //checks angle c
      } else if (angleC > 0) {
        this.sideC = sinLawSide(sideB, angleB, angleC);
        
      } else {
        throw null;
      }
    // checks if it can use side sin law for a or B 
    } else if ((sideC > 0 && angleC > 0 && (angleA > 0 || angleB > 0))) {

      //checks angle A
      if (angleA > 0) {
        this.sideA = sinLawSide(sideC, angleC, angleA);
      
      //checks angle b
      } else if (angleB > 0) {
        this.sideB = sinLawSide(sideC, angleC, angleB);
        
      } else {
        throw null;
      }

    // checks if angle sin law can be used for b or c
    } else if ((sideA > 0 && angleA > 0 && (sideB > 0 || sideC > 0))) {

      //checks side b
      if (sideB > 0) {
        this.angleB = sinLawAngle(sideA, angleA, sideB);
      
      //checks side c
      } else if (sideC > 0) {
        this.angleC = sinLawAngle(sideA, angleA, sideC);
        
      } else {
        throw null;
      }
    
    // checks if angle sin law can be used for a or c
    } else if ((sideB > 0 && angleB > 0 && (sideA > 0 || sideC > 0))) {

      //checks side a
      if (sideA > 0) {
        this.angleA = sinLawAngle(sideB, angleB, sideA);
      
      //checks side c
      } else if (sideC > 0) {
        this.angleC = sinLawAngle(sideB, angleB, sideC);
        
      } else {
        throw null;
      }
    
    // checks if angle sin law can be used for a or b
    } else if ((sideC > 0 && angleC > 0 && (sideA > 0 || sideB > 0))) {

      //checks side a
      if (sideA > 0) {
        this.angleA = sinLawAngle(sideC, angleC, sideA);
      
      //checks side b
      } else if (sideB > 0) {
        this.angleB = sinLawAngle(sideC, angleC, sideB);
        
      } else {
        throw null;
      }

    // if sin law cant be used, check if cos law can
    } else if (sideA > 0 && angleB > 0 && sideC > 0) {
      
      this.sideB = cosLaw(sideA, angleB, sideC);
    
    } else if (sideC > 0 && angleA > 0 && sideB > 0) {

      this.sideA = cosLaw(sideC, angleA, sideB);
      
    } else if (sideB > 0 && angleC > 0 && sideA > 0) {

      this.sideC = cosLaw(sideB, angleC, sideA);

    // if niether sin nor cos law can be used check if we have all 3 angles
    } else if (sideA > 0 && sideB > 0 && sideC > 0) {
      this.perimeter = sideA + sideB + sideC;

    /* if we dont have all 3 angles and niether sin nor cos law can be used 
    * find the third angle.
    */
    } else if (angleA > 0 && angleB > 0) {
      this.angleC = angleFinder(angleA, angleB);
      
    } else if (angleA > 0 && angleC > 0) {
      this.angleB = angleFinder(angleA, angleC);
      
    } else if (angleB > 0 && angleC > 0) {
      this.angleA = angleFinder(angleB, angleC);
    
    } else {
      throw null;
    }
    return ("First set of information found");
  
  }

  /**
   * Public method used to find the remaining values that havent been found in
   * the triangle.
   */
  public String secondSort() {
    // checks to see if an angle and its side are still 0
    if (sideC + angleC == 0 || sideB + angleB == 0 || sideA + angleA == 0) {
      if (angleA == 0) {
        // find angle A
        this.angleA = angleFinder(angleB, angleC);
        //finds side A
        this.sideA = cosLaw(sideB, angleA, sideC);

      } else if (angleB == 0) {
        // find angle B
        this.angleB = angleFinder(angleA, angleC);
        //finds side B
        this.sideB = cosLaw(sideA, angleB, sideC);
      
      } else if (angleC == 0) {
        // find angle C
        this.angleC = angleFinder(angleA, angleB);
        //finds side C
        this.sideC = cosLaw(sideA, angleC, sideB);
      }

    // checks to see if cos law can be used to fins an angle
    } else if (angleA + angleC == 0 || angleA + angleB == 0 || angleB + angleC == 0) {
      if (angleA + angleC == 0) {
        this.angleA = sinLawAngle(sideB, angleB, sideA);
        this.angleC = angleFinder(angleA, angleB);

      } else if (angleA + angleB == 0) {
        this.angleB = sinLawAngle(sideC, angleC, sideB);
        this.angleA = angleFinder(angleC, angleB);

      } else if (angleB + angleC == 0) {
        this.angleC = sinLawAngle(sideA, angleA, sideC);
        this.angleB = angleFinder(angleC, angleA);
      }

    // checks if side sin law can be used to find the last 2 sides
    } else if (sideA + sideB == 0 || sideB + sideC == 0 || sideC + sideA == 0) {
      if (sideA + sideB == 0) {
        this.sideA = sinLawSide(sideC, angleC, angleA);
        this.sideB = sinLawSide(sideC, angleC, angleB);

      } else if (sideB + sideC == 0) {
        this.sideB = sinLawSide(sideA, angleA, angleB);
        this.sideC = sinLawSide(sideA, angleA, angleC);

      } else if (sideC + sideA == 0) {
        this.sideC = sinLawSide(sideB, angleB, angleC);
        this.sideA = sinLawSide(sideB, angleB, angleA);
      }
    }
    return ("Information gathering complete...");
  }
  
  
  /**
   * method to find the type of the triangle.
   */
  public String getType() {
    int validCheck = validityCheck();

    // Checks type 1 triangles
    if ((sideA > sideB) && (sideA > sideC)) {
      double tempVal = Math.pow(sideA, 2);
      double tempVal2 = Math.pow(sideB, 2) + Math.pow(sideC, 2);
      if (tempVal < tempVal2) {
        this.triangleType = "Acute Triangle";
      } else if (tempVal > tempVal2) {
        this.triangleType = "Obtuse Triangle";
      } else if (tempVal == tempVal2) {
        this.triangleType = "Right angle Triangle";
      }

    // Checks type 2 triangles
    } else if ((sideB > sideA) && (sideB > sideC)) {
      double tempVal = Math.pow(sideB, 2);
      double tempVal2 = Math.pow(sideA, 2) + Math.pow(sideC, 2);
      if (tempVal < tempVal2) {
        this.triangleType = "Acute Triangle";
      } else if (tempVal > tempVal2) {
        this.triangleType = "Obtuse Triangle";
      } else if (tempVal == tempVal2) {
        this.triangleType = "Right angle Triangle";
      }
    
    // checks type 3 triangles
    } else if ((sideC > sideA) && (sideC > sideB)) {
      double tempVal = Math.pow(sideC, 2);
      double tempVal2 = Math.pow(sideA, 2) + Math.pow(sideB, 2);
      if (tempVal < tempVal2) {
        this.triangleType = "Acute Triangle";
      } else if (tempVal > tempVal2) {
        this.triangleType = "Obtuse Triangle";
      } else if (tempVal == tempVal2) {
        this.triangleType = "Right angle Triangle";
      }
    } 

    if (validCheck == -1) {
      this.triangleType = "Invalid triangle. One or more sides is negative";
    } else if (validCheck == -2) {
      this.triangleType = "Invalid triangle. One or more angles is negative";
    }
    return triangleType;

  }
  
  /**
   * protected method to check if a triangle is valid.
   */
  protected int validityCheck() {
    int triangleVal = 0;
    if (sideA < 0 || sideB < 0 || sideC < 0) {
      triangleVal = -1;
    } else if (angleA < 0 || angleB < 0 || angleC < 0) {
      triangleVal = -2;
    }

    return triangleVal;
  }
  
  /**
   * protected method to do cos law on values.
   */
  protected double cosLaw(double sideOne, double angleOne, double sideTwo) {
  
    double cosSide = Math.sqrt((sideOne * sideOne) + (sideTwo * sideTwo) - 2 
                                * sideOne * sideTwo * Math.cos(angleOne));
    return cosSide;
  }
  
  /**
   * protected method to do sin law for a side.
   */
  protected double sinLawSide(double sideTemp, double angleTemp,
                              double exAngleTemp) {

    double sinSide = sideTemp * (Math.sin(exAngleTemp) / Math.sin(angleTemp));
    return sinSide;
  }
  
  /**
   * protected method to do sin law for an angle.
   */
  protected double sinLawAngle(double sideTemp, double angleTemp,
                               double exSideTemp) {

    double tempAngle = Math.asin(exSideTemp
                                 * ((Math.sin(angleTemp)) / sideTemp));
    return tempAngle;
  }

  /**
   * method that finds angles when angles are inputted.
   */
  protected double angleFinder(double angle1, double angle2) {
    double finalAngle = Math.PI - (angle1 + angle2);
    return finalAngle;
  }

  /**
   * Method that sets perimeter.
   */
  public void perimeterSet() {
    this.perimeter = sideA + sideB + sideC;
  }


  /**
   * method that finds area.
   */
  public void areaFinder() {
    this.area = Math.sqrt(perimeter / 2 * (perimeter / 2 - sideA) 
                          * (perimeter / 2 - sideB) * (perimeter / 2 - sideC));
  }

  /**
   * getter to get area.
   */
  public double areaGetter() {
    return area;

  }
  
  /**
   * getter to get perimeter.
   */
  public double perimeterGetter() {
    return perimeter;
  }

  /**
   * method that calculates height.
   */
  public double heightFinder() {
    double base = 0;
    
    if (sideA >= sideB && sideA >= sideC) {
      base = this.sideA;
    } else if (sideB >= sideA && sideB >= sideC) {
      base = this.sideB;
    } else if (sideC >= sideA && sideC >= sideB) {
      base = this.sideC;
    }
    double height  = (area * 2) / base;
    return height;
  }

  /**
   * method that calculates and returns the inradius.
   */
  public double inradius() {

    double foundInradius = area / (perimeter / 2);
    return foundInradius;
  }
  
  /**
   * method that calculates the circumradius.
   */
  public double circumradius() {
  
    double foundCircumradius = sideA / (2 * Math.sin(angleA));
    return foundCircumradius;
  }

  /**
   * method to output all values of the triangle.
   */
  public String valueOutputter() {
    
    String infoString = (" angle A " + angleA * 180 / 3.14159 + " angle B "
                         + angleB * 180 / 3.14159 + " angle C " 
                         + angleC * 180 / 3.14159 + " side a " + sideA 
                         + " side b " + sideB + " side c " + sideC);
    return infoString;
  }
}