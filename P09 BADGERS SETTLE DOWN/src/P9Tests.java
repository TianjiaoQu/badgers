import java.util.NoSuchElementException;

//////////////////// HEADER COMMENT ///////////////////////////////////////////////////////////////
//
// Title:           P9Tests.java 
// Files            Badger.java, Sett.java, P9Tests.java.
// Course:          CS 300 Fall 2018
//
// Author:          Tian Qu
// Email:           tqu6@wisc.edu
// Lecturer's Name: Gary Dahl
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
  /**
   * This class contain tests for both the Sett and Badger classes including two methods that 
   * test the functionality of the Badger class and one methods that test each of the public 
   * methods within the Sett class.
   * @author Tian Qu
   */
public class P9Tests {

  /**
   * This method creates a Badger object and use getSize to verify its size 
   * @return true when test verifies correct functionality, and false otherwise. 
   */
  public static boolean testBadgerMethodOne() {
    Boolean passed = false;
    Badger badger1 = new Badger(10); // Constructor test
    if(badger1.getSize() == 10) // Size test
      passed = true;
    else {
      System.out.println("The size of Badger is not as expected");
    }
    return passed;  
  }
  
  /**
   * This method creates a Badger object, sets its neighbor and verifies the neighbor
   * @return true when test verifies correct functionality, and false otherwise. 
   */
  public static boolean testBadgerMethodTwo() {
    Boolean passed = false;
    Badger badger1 = new Badger(10);
    badger1.setLeftLowerNeighbor(new Badger(5)); // Set lower left neighbor
    badger1.setRightLowerNeighbor(new Badger(15)); // Set lower right neighbor
    if( (badger1.getLeftLowerNeighbor().getSize() == 5) &&  
        (badger1.getRightLowerNeighbor().getSize() == 15) ) // Verify the result
      passed = true;
    else
      System.out.println("Set neighbor method result is not right.");
    return passed;
  }
  
  /**
   * This method test the Constructor in Sett
   * @return true when test verifies correct functionality, and false otherwise. 
   */
  public static boolean testSettConstructor() {
    Sett sett = new Sett();
    if(sett.getTopBadger() == null) // Verify if an empty Sett has been created
      return true;
    else {
      System.out.println("Sett constructor test failed.");
      return false;
    }
  }
  
  /**
   * This method test the isEmpty() method in Sett
   * @return true when test verifies correct functionality, and false otherwise. 
   */
  public static boolean testSettIsEmpty() {
    Sett sett = new Sett(); // Creates an empty Sett
    if(sett.isEmpty()) 
      return true;
    else {
      System.out.println("Sett isEmpty method failed.");
      return false;
    }
  } 
  
  /**
   * This method test the getTopBadger() method in Sett
   * @return true when test verifies correct functionality, and false otherwise. 
   */
  public static boolean testSettGetTopBadger() {
    Sett sett = new Sett(); // Creates an empty Sett
    if(sett.getTopBadger() == null) // Call getTopBadger
      return true;
    else {
      System.out.println("Sett getTopBadger() failed.");
      return false;
    }
  }
  
  /**
   * This method test the settleBadger() method in Sett
   * @return true when test verifies correct functionality, and false otherwise. 
   */
  public static boolean testSettSettleBadger() {
    Sett sett = new Sett(); // Creates an empty Sett
    try {
      sett.settleBadger(50); // Settle Badgers of different sizes with size 50 as the topBadger
      sett.settleBadger(20);
      sett.settleBadger(60);
      sett.settleBadger(50); // Duplicate IllegalArgumentException should be thrown
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
    if(sett.getTopBadger().getSize() == 50) // Call getTopBadger
      return true;
    else {
      System.out.println("Sett settleBadger() failed.");
      return false;
    }
  }

  
  /**
   * This method test the findBadger(int) method in Sett
   * @return true when test verifies correct functionality, and false otherwise. 
   */
  public static boolean testSettFindBadger() {
    Sett sett = new Sett(); // Creates an empty Sett
    try {
      sett.settleBadger(50); // Settle Badgers of different sizes with size 50 as the topBadger
      sett.settleBadger(20);
      sett.settleBadger(60);
      sett.settleBadger(10); 
      sett.settleBadger(30);
      sett.findBadger(70);  // NoSuchElementException should be thrown
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
    if(sett.findBadger(30).getSize() == 30) // Verify if Badger with size 30 is found
      return true;
    else {
      System.out.println("Sett findBadger(int) failed.");
      return false;
    }
  }
  
  /**
   * This method test the countBadger() method in Sett
   * @return true when test verifies correct functionality, and false otherwise. 
   */
  public static boolean testSettCountBadger() {
    Sett sett = new Sett(); // Creates an empty Sett
    try {
      sett.settleBadger(50); // Settle Badgers of different sizes with size 50 as the topBadger
      sett.settleBadger(20);
      sett.settleBadger(60);
      sett.settleBadger(10); 
      sett.settleBadger(30);
      sett.settleBadger(70);  // 6 Badgers have been settled
      sett.settleBadger(-70); // IllegalArgumentException should be thrown with negative size
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
    if(sett.countBadger() == 6) // Verify if Badger with count 6 is found
      return true;
    else {
      System.out.println("Sett countBadger() failed.");
      return false;
    }
  }
  
  /**
   * This method test the getAllBadger() method in Sett
   * @return true when test verifies correct functionality, and false otherwise. 
   */
  public static boolean testSettGetAllBadger() {
    Sett sett = new Sett(); // Creates an empty Sett
    sett.settleBadger(50); // Settle Badgers of different sizes with size 50 as the topBadger
    sett.settleBadger(20);
    sett.settleBadger(60);
    sett.settleBadger(10); 
    sett.settleBadger(30);
    sett.settleBadger(70);  // 6 Badgers have been settled with order 10, 20, 30, 50, 60, 70
    if(sett.getAllBadgers().get(2).getSize() == 30) // Determine if Index 2 is Badger with size 30
      return true;
    else {
      System.out.println("Sett getAllBadger() failed.");
      return false;
    }
  }
  
  /**
   * This method test the getHeight() method in Sett
   * @return true when test verifies correct functionality, and false otherwise. 
   */
  public static boolean testSettGetHeight() {
    Sett sett = new Sett(); // Creates an empty Sett
    sett.settleBadger(50); // Settle Badgers of different sizes with size 50 as the topBadger
    sett.settleBadger(20);
    sett.settleBadger(60);
    sett.settleBadger(10); 
    sett.settleBadger(30);
    sett.settleBadger(70); 
    sett.settleBadger(40); // 7 Badgers have been settled with height 4
    if(sett.getHeight() == 4) // Determine if the Sett height is 4
      return true;
    else {
      System.out.println("Sett getHeight() failed.");
      return false;
    }
  }
  
  /**
   * This method test the getLargestBadger() method in Sett
   * @return true when test verifies correct functionality, and false otherwise. 
   */
  public static boolean testSettGetLargestBadger() {
    Sett sett = new Sett(); // Creates an empty Sett
    sett.settleBadger(50); // Settle Badgers of different sizes with size 50 as the topBadger
    sett.settleBadger(20);
    sett.settleBadger(60);
    sett.settleBadger(10); 
    sett.settleBadger(30);
    sett.settleBadger(70); 
    sett.settleBadger(40); // 7 Badgers have been settled with the LargestBadger size 70
    if(sett.getLargestBadger().getSize() == 70) // Determine if the LargestBadger is the size 70
      return true;
    else {
      System.out.println("Sett getLargestBadger() failed.");
      return false;
    }
  }
  
  /**
   * This method test the clear() method in Sett
   * @return true when test verifies correct functionality, and false otherwise. 
   */
  public static boolean testSettClear() {
    Sett sett = new Sett(); // Creates an empty Sett
    sett.settleBadger(50); // Settle Badgers of different sizes with size 50 as the topBadger
    sett.settleBadger(20);
    sett.settleBadger(60);
    sett.settleBadger(10); 
    sett.settleBadger(30);
    sett.settleBadger(70); 
    sett.settleBadger(40); // 7 Badgers have been settled 
    sett.clear();
    if(sett.isEmpty()) // Determine if the Sett has been cleared
      return true;
    else {
      System.out.println("Sett clear() failed.");
      return false;
    }
  }
  
  /**
   * Method to run all of the tests for Badger class together
   * @return true when all Badger tests pass and false otherwise
   */
  public static boolean runAllBadgerTests() {
    if(testBadgerMethodOne() && testBadgerMethodTwo())
      return true;
    return false;
  } 
  
  /**
   * Method to run all of the tests for the Sett class together
   * @return true when all Sett tests pass and false otherwise
   */
  public static boolean runAllSettTests() {
    if( (testSettConstructor()) && (testSettConstructor()) && (testSettGetTopBadger()) && 
        (testSettSettleBadger()) && (testSettFindBadger()) && (testSettCountBadger()) && 
        (testSettGetAllBadger()) && (testSettGetHeight()) && (testSettGetLargestBadger()) && 
        (testSettClear()) )
      return true;
    return false;
  } 
  
  /**
   * Run all of the tests and print out the results
   */
  public static void main(String[] args) {
    System.out.println(runAllBadgerTests());
    System.out.println(runAllSettTests());  
  }

}
