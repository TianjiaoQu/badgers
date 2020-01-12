import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

//////////////////// HEADER COMMENT ///////////////////////////////////////////////////////////////
//
// Title:           Sett.java 
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
 * This class represents a Sett, where a group of Badgers live together. 
 * Each Sett is organized as a Binary Search Tree (BST) of Badger nodes.
 * @author Tian Qu
 */
public class Sett {
  
  private Badger topBadger; // Root of the BST
  
  /**
   * Constructor to create an empty Sett 
   */
  public Sett() {
    topBadger = null;
  }
  
  /**
   * Method to check whether this Sett is empty.
   * @return true if this Sett is empty, false otherwise.
   */
  public boolean isEmpty() {
    return topBadger == null;
  }
  
  /**
   * Method to retrieve the top Badger within this Sett (the one that was settled first).
   * @return the Badger living on the top of the current Sett.
   */
  
  public Badger getTopBadger() {
    return topBadger;
    
  }
  
  /**
   * Method to creates a new Badger object with the specified size, and inserts them into 
   * this Sett (BST).
   * @param size represents the size of the new Badger that will be settled.
   * @throws IllegalArgumentException if Badger with the size already exists within the Sett.
   */
  public void settleBadger(int size) throws IllegalArgumentException {
    if (isEmpty()) // If the Sett is empty add new Badger at the root
      topBadger = new Badger(size);
    else { // For Sett with a root call recursive helper
      Badger newBadger = new Badger(size);
      settleHelper(topBadger, newBadger);
    }
      
    
  }
  
  /**
   * This recursive helper method is used to help settle a new Badger within this Sett.
   * @param current represents the current Badger (previously settled within this Sett) that 
   * we are considering settling the newBadger beneath (either to its left or right).
   * @param newBadger represents the new Badger that needs to be settled within this Sett.
   * @throws IllegalArgumentException if Badger with the size already exists within the Sett.
   */
  private void settleHelper(Badger current, Badger newBadger) 
      throws IllegalArgumentException {
    
    if(newBadger.getSize() < current.getSize()) { // Add to the left subtree
      if(current.getLeftLowerNeighbor()==null) // No left child
        current.setLeftLowerNeighbor(newBadger);
      else
        settleHelper(current.getLeftLowerNeighbor(), newBadger); // recur the left subtree
    } else if (newBadger.getSize() > current.getSize()) { // Add to the right subtree
      if(current.getRightLowerNeighbor()==null) // No right child
        current.setRightLowerNeighbor(newBadger);
      else
        settleHelper(current.getRightLowerNeighbor(), newBadger); // recur the right subtree
    } else // For duplicate size throw exception
      throw new IllegalArgumentException("WARNING: failed to settle the badger with "
          + "size " + newBadger.getSize() + ", as there is already a badger with the "
              + "same size in this sett");  
  }
  
  /**
   * Method to find a Badger of a specified size in this Sett.
   * @param size represents the size of the Badger object to search for and return.
   * @return The Badger found with the specified size.
   * @throws NoSuchElementException if there is no Badger in this Sett with the specified size.
   */
  public Badger findBadger(int size) throws NoSuchElementException {
    return findHelper(topBadger, size);
    
  }
  
  /**
   * This recursive helper method is used to help find a Badger within this Sett.
   * @param size represents the size of the Badger object to search for and return.
   * @param current represents current Badger that is the root of a (sub) tree that we are 
   * searching for a Badger with the specified size within.
   * @return The Badger found with the specified size.
   * @throws NoSuchElementException if there is no Badger in this Sett with the specified size.
   */
  private Badger findHelper(Badger current, int size) throws NoSuchElementException {
    if(current == null) // Reach the leaf or binary tree empty
      throw new NoSuchElementException("WARNING: failed to find a badger with "
          + "size " + size + " in the sett");
    if(current.getSize() == size) // successful search
      return current;
    else if(current.getSize() > size) // Recur the left subtree
      return findHelper(current.getLeftLowerNeighbor(), size);
    else // Recur the right subtree
      return findHelper(current.getRightLowerNeighbor(), size); 
  }
  
  /**
   * Method to count how many Badgers live in this Sett.
   * @return The number of Badgers living in this Sett.
   */
  public int countBadger() {
    if(topBadger == null)
      return 0; // Empty Sett
    else
      return countHelper(topBadger);
  }
  
  /**
   * This recursive helper method is used to help count the number of Badgers in this Sett.
   * @param current represents the current Badger that is the root of a (sub) tree 
   * that we are counting the number of Badgers within.
   * @return the number of Badgers living in the Sett rooted at the current Badger.
   */
  private int countHelper(Badger current) {
    int count = 1; // Count the current in
    if(current.getLeftLowerNeighbor() != null) // recur on the left tree if current has one
      count = count + countHelper(current.getLeftLowerNeighbor());
    if(current.getRightLowerNeighbor() != null) // recur on the right tree if current has one
      count = count + countHelper(current.getRightLowerNeighbor());
    return count;
  }
  
  /**
   * Gets all Badgers living in the Sett as a list in ascending order of their size: 
   * smallest one in the front (at index zero), through the largest one at the end (at index size-1).
   * @return A list of all Badgers living in the Sett in ascending order by size.
   */
  public java.util.List<Badger> getAllBadgers() {
    
    java.util.List<Badger> allBadgers = new ArrayList<Badger>(); 
    // Create the list to store all Badgers
    if(!isEmpty())
      getAllHelper(topBadger, allBadgers);
    else 
      throw new NullPointerException("No Badgers live in the Sett now.");
    return allBadgers;
    
  }
  
  /**
   * This recursive helper method is used to help collect the Badgers within this Sett into a List.
   * @param allBadgers represents the list of all Badgers living in the Sett that is rooted at the 
   * current Badger node. The contents of this list should be in ascending order by Badger size.
   * @param current represents the current Badger that is the root of a (sub) tree that we are 
   * collecting all contained Badgers within, into the allBadgers List.
   */
  private void getAllHelper(Badger current, java.util.List<Badger> allBadgers) {
    // Apply in-order traversal of BST to store Badgers in ascending order by size
    if(current.getLeftLowerNeighbor() != null)
      getAllHelper(current.getLeftLowerNeighbor(), allBadgers); // Recur left subtree
    allBadgers.add(current); // Add current to the list
    if(current.getRightLowerNeighbor() != null)
      getAllHelper(current.getRightLowerNeighbor(), allBadgers); // Recur right subtree
  }
  
  /**
   * Computes the height of the Sett.
   * @return The depth of this Sett.
   */
  public int getHeight(){
    return getHeightHelper(topBadger); 
  }
  
  /**
   * This recursive helper method is used to help compute the height of this Sett.
   * @param current represents the current Badger that is the root of a (sub) tree 
   * that we are calculating the height of.
   * @return The height of the (sub) tree that we are calculating.
   */
  private int getHeightHelper(Badger current) {
    if(current == null) // Height is zero for empty Sett
      return 0;
    
    // Height as the max height among all left and right subtrees
    return 1 + Math.max(getHeightHelper(current.getLeftLowerNeighbor()), 
        getHeightHelper(current.getRightLowerNeighbor())); 
  }
  
  /**
   * Method to retrieve the largest Badger living in this Sett.
   * @return The largest Badger living in this Sett.
   */
  public Badger getLargestBadger() {
    if(topBadger == null)
      throw new NullPointerException("No Badgers live in the Sett now.");
    Badger largest = topBadger;
    // Start from the root the largest Badger is the rightmost leaf
    while(largest.getRightLowerNeighbor() != null) { 
      largest = largest.getRightLowerNeighbor();
    }
    return largest;
  }
  
  /**
   * Method to empty this Sett, to no longer contain any Badgers.
   */
  public void clear() { // Set topBadger to null and release all the nodes
    this.topBadger = null;
  }
}
