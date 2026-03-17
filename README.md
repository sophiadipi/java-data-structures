# java-data-structures
This project implements tree-based data structures in Java including binary trees, binary search trees, and decision trees. 

The system demonstrates how tree structures can be used for decision-making, as well as data storage. 

---

## Features
- Linked binary tree implementation using a node-based structure.
- Binary search tree with insertion, removal, and search operations.
- Tree traversal iterators (in-order, pre-order, post-order, level-order).
- Binary search tree balancing algorithm.
- Decision tree engine that reads a tree structure from a file.
- Interactive command-line programs that evaluate user responses.

---

## Example Applications
### Back Pain Diagnostic System
An interactive decision tree that asks users a series of yes/no questions and produces a possible diagnosis based on their
responses. 
Example flow:
```
  So, you're having back pain. 

  Did the pain occur after a blow or jolt? (Y/N)
  Y

  Do you have difficulty controlling your arms or legs? (Y/N)
  N

  Do you have pain or numbness in one arm or leg? (Y/N)
  N

  You may have a sprain or strain.
```
  
### Vacation Destination Recommendation System
A decision tree that asks questions about travel preferences (e.g., budget, climate, activities) and recommends a destination
based on the user's responses. 
Example flow: 
```
  So, you want to go on a trip but can't pick a destination. Maybe I can help!

  Do you want to go somewhere warm? (Y/N)
  N

  Do you want to experience a cold climate with snow? (Y/N)
  Y

  Do you  like to ski or snowboard? (Y/N)
  N

  Do you enjoy being in nature? (Y/N)
  Y

  Iceland is the perfect destination for someone who enjoys the cold and being in nature. It has a wide range of natrual landscapes
  including glaciers, volcanoes, hot springs, waterfalls, and ice caves. So much to explore!
```
  
Both applications use a binary decision tree that evaluates user responses to navigate through the tree and produce
a final recommendation. 

---

## Project Structure
```
src/
BackPainAnalyzer.java
VacationDestinationDecider.java
BalanceTreeDriver.java
DecisionTree.java
input.txt
vacationTree.txt
jsjf/
  ArrayList.java
  ArrayUnorderedList.java
  BinarySearchTreeADT.java
  BinaryTreeADT.java
  BinaryTreeNode.java
  LinkedBinarySearchTree.java
  LinkedBinaryTree.java
  ListADT.java
  TreeIterator.java
  UnorderedListADT.java
  exceptions\
    ElementNotFoundException.java
    EmptyCollectionException.java
    NonComparableElementException.java
```
---

## Technologies
- Java
- OOP
- Data Structures
- Algorithms

## Author
**Sophia DiPietro**,
Computer Science Student
