/**
* Name: Shraavasti Bhat
* Pennkey: shraab
* Execution: java SudokuGrid
*
* Description: Creates the 2D array of GridSpaces that is used to construct the
* sudoku. The class draws the initial values and contains methods to:
* Get values from the spaces with the row and column
* Input values given a row and column
* Remove values in the grid given a row and column
**/
public class SudokuGrid {
    private GridSpaces[][] grid;
    private String initialSudokuValues;
    
    /**
    * Inputs: String of initiatl sudoku values presented in the file,
    * the number of rows in the sudoku grid and the number of columns
    * Outputs:
    * Description: TODO
    */
    public SudokuGrid(String initialSudokuValues) {
        PennDraw.picture(0.5, 0.5, "sudokucanvas.png", 460.8, 460.8);
        this.initialSudokuValues = initialSudokuValues;
        //int p = 0;
        int i = 0;
        int j = 0;
        grid = new GridSpaces[9][9];
        if (initialSudokuValues.length() == 81) {
            int p = 0;
            for (i = 0; i < grid.length; i++) {
                for (j = 0; j < grid[i].length; j++) {
                    if (p < 81) {
                        String value = "" + initialSudokuValues.charAt(p);
                        this.grid[i][j] = new GridSpaces(i, j, value);
                        String a = "" + initialSudokuValues.charAt(p);
                        if (!a.equals(" ")) {
                            this.grid[i][j].makeSpaceUntouchable();
                        }
                        p++;
                    }
                }
            }
            drawInitialValuesOnSudokuBoardInBold(this.initialSudokuValues);
            
        }
        
        else {
            throw new IllegalArgumentException();
        }
        
    }
    
    /**
    * Inputs: String of intial sudoku values given by the text file
    * Outputs: no output
    * Description: draws the initial given values on the sudoku board
    */
    public void drawInitialValuesOnSudokuBoardInBold(String initialSudokuValues) {
        PennDraw.picture(0.5, 0.5, "sudokucanvas.png", 460.8, 460.8);
        int p = 0;
        int i = 0;
        int j = 0;
        PennDraw.setFontBold();
        
        if (initialSudokuValues.length() == 81) {
            for (i = 0; i < grid.length; i++) {
                for (j = 0; j < grid[i].length; j++) {
                    if (p < this.initialSudokuValues.length()) {
                        String value = "" + initialSudokuValues.charAt(p);
                        
                        double centerY = (9 - i) * 0.1;
                        double centerX = (0.1 * j) + 0.1;
                        PennDraw.text(centerX, centerY, value);
                        p++;
                    }
                }
            }
        }
        
        else if (initialSudokuValues.length() != 81) {
            throw new IllegalArgumentException();
        }
        PennDraw.setFontPlain();
    }
    
    /**
    * Inputs: row and column of input and value of user input
    * Outputs: no output
    * Description: puts the users input into the sudoku 2D array
    */
    public void inputValue(int row, int column, String value) {
        GridSpaces p = grid[row][column];
        p.fillWithValue(value);
    }
    
    /**
    * Inputs: no input
    * Outputs: 2D array of grid spaces
    * Description: getter method for current grid
    */
    public GridSpaces[][] getCurrentGrid() {
        return this.grid;
    }
    
    /**
    * Inputs: row position of value and column position of value
    * Outputs: The string value in the 2d grid at the row and column position
    * in the 2d array
    * Description: getter method for String value in 2D array
    */
    public String getValueFromGrid(int rowPos, int colPos) {
        GridSpaces temp = this.grid[rowPos][colPos];
        return temp.getValue();
        
    }
    
    /**
    * Inputs: no input
    * Outputs: boolean - if the grid spaces in the 2d array are empty
    * Description: checks if the grid spaces in the sudoku 2d array are empty
    */
    public boolean checkIfEmpty() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String a = grid[i][j].getValue();
                if (a.equals(" ")) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
    * Inputs: row position of grid space, column position of grid space
    * Outputs: GridSpace object
    * Description: getter method for the GridSpace in the 2D suodku array
    */
    public GridSpaces getGridSpace(int row, int column) {
        GridSpaces a = this.grid[row][column];
        return a;
    }
    
    /**
    * Inputs: row position of value and column position of value
    * Outputs: no output
    * Description: clears the GridSpace at the given row and column of the 2d array
    */
    public void removeValueFromGrid(int row, int column) {
        grid[row][column].clear();
    }
    
}
