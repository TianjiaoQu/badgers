//////////////////// HEADER COMMENT ///////////////////////////////////////////////////////////////
//
// Title:           Badger.java 
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
 * This class represents a Badger which is designed to live in a Sett. Each Badger object 
 * represents a single node within a BST (known as a Sett).
 * @author Tian Qu
 */
public class Badger {
  private Badger leftLowerNeighbor;  // Reference to the right lower Badger child
  private Badger rightLowerNeighbor; // Reference to the right lower Badger child
  private final int size; // Size of the Badger as data within the node
  
  /**
   * Constructor to create a new Badger with specified size
   * @param size represents the size of the Badger created
   * @throws IllegalArgumentException if size is 0 or negative
   */
  public Badger(int size) {
    if(size <= 0) 
     throw new IllegalArgumentException("Illegal size input");
    this.size = size;
    this.leftLowerNeighbor = null;
    this.rightLowerNeighbor = null;
  }
  
  /**
   * Method to retrieve neighboring badger that is smaller than this one
   * @return The left lower neighbor of current badger.
   */
  public Badger getLeftLowerNeighbor() {
    return leftLowerNeighbor;
  }
  
  /**
   * Method to change this badger's lower left neighbor.
   * @param badger represents the new left lower neighbor of current badger.
   */
  public void setLeftLowerNeighbor(Badger badger) {
    this.leftLowerNeighbor = badger;
  }
  
  /**
   * Method to retrieve neighboring badger that is larger than this one
   * @return The right lower neighbor of current badger.
   */
  public Badger getRightLowerNeighbor() {
    return rightLowerNeighbor;
  }
  
  /**
   * Method to change this badger's lower right neighbor.
   * @param badger represents the new right lower neighbor of current badger.
   */
  public void setRightLowerNeighbor(Badger badger) {
    this.rightLowerNeighbor = badger;
  }
  
  /**
   * Method to retrieve the size of this badger.
   * @return The size of current badger.
   */
  public int getSize() {
    return size;
  }


}
