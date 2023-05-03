/**********************************************************************
 * Final Project
 **********************************************************************/

Name: Shraavasti Bhat
PennKey: shraab
Hours to complete assignment (optional): 10

/**********************************************************************
 *  Please list all help, collaboration, and outside resources
 *  you used here. 
 *
 *  If you did not get any help in outside of TA office hours,
 *  and did not use any materials outside of the standard
 *  course materials and piazza, write the following statement below:
 *  "I did not receive any help outside of TA office hours.  I
 *  did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."
 **********************************************************************/
I did not receive any help outside of TA office hours.  I
did not collaborate with anyone, and I did not use any
resources beyond the standard course materials.

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

I didn't encounter any serious problems


/**********************************************************************
 *  Instructions:     
 *  To start game run the GameRefree class using the following statement:
 *  java GameRefree [Sudoku Filename]
 **********************************************************************/
/**********************************************************************
GameRefree Class Description:
The class uses the methods in the other class to start and play the game - making 
sure that when illegal moves are made they are highlighted and indicated to the user
The class prevents users from making inputs when their move is illegal and allows
the user to play until all the spaces are correctly filled. 

GridSpaces Class Description:
This class contains the properties of the individuals squares in the grid - their 
value and their position (row, column) in the 2D sudoku array
The class contains methods to clear the spaces, add value to the spaces and empty 
checks so that the whole board can be checked in other class methods such as
GameRefree or CheckRowColumnBox.

SudokuGrid Class Description:
Creates a representation of the sudoku grid using a 2d array of grid spaces
Allow the game to fill in the sudoku grid and draw the grid on the system viewer.
The class keeps track of inputs made and is used by the other classes to conduct
illegal input checks. 

CheckRowColumnBox Class:
Contains methods to make the user is following the rules of sudoku. The class
conducts the horizontal, vertical and box checks as well as shows the user
why their input is incorrect by highlighting conflicting values and conflicting
boxes/rows/columns                               
 **********************************************************************/





