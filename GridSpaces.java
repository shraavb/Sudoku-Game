/**
* Name: Shraavasti Bhat
* Pennkey: shraav
* Execution: java GridSpaces - But there is no main method
*
* Description: Creates a grid space object that is the 81 spaces in the sudoku grid
* Each space is assigned a column, row position and a value. Also the space contains
* information as to whether the space is among the original input text values used to
* construct the grid. If it is, the user will not be able to edit this space.
**/

public class GridSpaces {
    private int arrColPos;
    private int arrRowPos;
    private String value;
    private boolean givenGridInput; //value that cannot be edited by the player
    
    /**
    * Inputs: row position in the array, column position in the array, value
    * contains in the space
    * Outputs: no output
    * Description: Constructor that creates grid
    */
    public GridSpaces(int arrRowPos, int arrColPos, String value) {
        this.arrRowPos = arrRowPos;
        this.arrColPos = arrColPos;
        this.value = value;
        this.givenGridInput = false; //default value spaces for all
    }
    
    /**
    * Inputs: given String value/input
    * Outputs: no output
    * Description: fills space with a given value
    */
    public void fillWithValue(String newValue) {
        this.value = newValue;
    }
    
    /**
    * Inputs: no input
    * Outputs: String of the value in the repsective grid space object
    * Description: getter methods that extract the value in the grid space
    */
    public String getValue() {
        return this.value;
    }
    
    /**
    * Inputs: no input
    * Outputs: no output
    * Description: classifies the respective grid space as being on of the given
    * input values from the txt.file given at the start of the game. This condition
    * prevents the user from making inputs in the grid space.
    */
    public void makeSpaceUntouchable() {
        this.givenGridInput = true;
    }
    
    /**
    * Inputs: no input
    * Outputs: boolean - whether the grid space is one of the original values (true)
    * or changeable by the user
    * Description: extracts whether the grid space was one of the original values
    * to determine if it can be changed by the user
    */
    public boolean getIfSpaceIsUnchangeable() {
        return this.givenGridInput;
    }
    
    /**
    * Inputs: no input
    * Outputs: int - row number of grid space
    * Description: getter method for row number
    */
    public int getRowNo() {
        return this.arrRowPos;
    }
    
    /**
    * Inputs: no input
    * Outputs: int - column number of grid space
    * Description: getter method for column position
    */
    public int getColNo() {
        return this.arrColPos;
    }
    /**
    * Inputs: no input
    * Outputs: boolean - if the space is filled(true) or not (false)
    * Description: determines if the grid space is filled or not
    */
    public boolean isSpaceFilled() {
        if (this.value.equals(" ")) {
            return false;
        }
        
        else {
            return true;
        }
    }
    
    /**
    * Inputs: none
    * Outputs: none
    * Description: clears the grid space by making its value to a space string " "
    */
    public void clear() {
        this.value = " ";
    }
}
