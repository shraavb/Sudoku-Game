**********************************************************************/

Name: Shraavasti Bhat

/**********************************************************************
 *  Instructions:     
 *  To start game run the GameRefree class using the following statement:
 *  java GameRefree [Sudoku Filename]
 **********************************************************************/
 
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





