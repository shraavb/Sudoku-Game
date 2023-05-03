/**
* Name: Shraavasti Bhat
* Pennkey: shraab
* Execution: java CheckRowColumnBox
*
* Description:
* Contains checking method for sudoku game:
* Checks row of a given user input
* Checks column of a given user input
* Checks the smaller sudoku boxes where the user input lies
* Draws any conflicting values and rows/columns/boxes founded by these checks in red

**/

public class CheckRowColumnBox {
    private int row;
    private int column;
    private int boxNum;
    private SudokuGrid newSudokuGrid;
    
    /**
    * Inputs: row, column and sudoku grid that is being checked
    * Outputs: no output
    * Description: contructor
    */
    public CheckRowColumnBox(int row, int column, SudokuGrid newSudokuGrid) {
        this.row = row;
        this.column = column;
        this.newSudokuGrid = newSudokuGrid;
        
    }
    
    /**
    * Inputs: users string input
    * Outputs: boolean - if the users input is valid in its respective sudoku row
    * Description: determines if the users input is legal/illegal in terms of the
    * row it is inserted in. If the input is illegal the respective row and
    * conflicting values are higlighted in red
    */
    public boolean checkIfIllegalMoveHorizontal(String input) {
        if (input != null && !input.equals(" ")) {
            for (int j = 0; j < 9; j++) {
                //check in horizontal line/array
                if (j != this.column && input.equals(
                this.newSudokuGrid.getValueFromGrid(this.row, j))) {
                    drawConflictingValueInRed(this.row, j, input);
                    double rectangleCenterY = (9.0 - this.row) * 0.1;
                    PennDraw.setPenColor(255, 0, 0);
                    PennDraw.rectangle(0.5, rectangleCenterY, 0.45, 0.05);
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
    * Inputs: users string input - key pressed
    * Outputs: boolean - if the users input is valid in its respective sudoku column
    * Description: determines if the users input is legal/illegal in terms of the
    * column it is inserted in. If the input is illegal the respective column and
    * conflicting values are higlighted in red
    */
    public boolean checkIfIllegalMoveVertical(String input) {
        if (input != null && !input.equals(" ")) {
            for (int i = 0; i < 9; i++) {
                //check in vertical line/array
                if (i != this.row && input.equals(
                this.newSudokuGrid.getValueFromGrid(i, this.column))) {
                    PennDraw.setPenColor(255, 0, 0);
                    drawConflictingValueInRed(i, this.column, input);
                    double rectangleCenterX = 1.0 - ((9.0 - this.column) * 0.1);
                    PennDraw.rectangle(rectangleCenterX, 0.5, 0.05, 0.45);
                    
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
    * Inputs: users string input - key pressed
    * Outputs: boolean - if the users input is valid in its respective sudoku box
    * Description: determines if the users input is legal/illegal in terms of the
    * box it is inserted in. If the input is illegal the respective box and
    * conflicting values are higlighted in red
    */
    public boolean checkIfIllegalMoveInBox(String input) {
        if (input != null && !input.equals(" ")) {
            //box 1
            if (this.row < 3 && this.row >= 0 && this.column >= 0 && this.column < 3
            ) {
                if (checkIfBoxesIsInCorrect(0, 0, input)) {
                    PennDraw.setPenColor(255, 0, 0);
                    PennDraw.rectangle(0.2, 0.8, 0.15, 0.15);
                    return true;
                }
            }
            //box 2
            if (this.row < 3 && this.row >= 0 && this.column >= 3 && this.column < 6
            ) {
                if (checkIfBoxesIsInCorrect(0, 3, input)) {
                    PennDraw.setPenColor(255, 0, 0);
                    PennDraw.rectangle(0.5, 0.8, 0.15, 0.15);
                    
                    return true;
                }
            }
            //box 3
            if (this.row < 3 && this.row >= 0 && this.column >= 6 && this.column < 9
            ) {
                if (checkIfBoxesIsInCorrect(0, 6, input)) {
                    PennDraw.setPenColor(255, 0, 0);
                    PennDraw.rectangle(0.8, 0.8, 0.15, 0.15);
                    
                    return true;
                }
            }
            //box 4
            if (this.row < 6 && this.row >= 3 && this.column >= 0 && this.column < 3
            ) {
                if (checkIfBoxesIsInCorrect(3, 0, input)) {
                    PennDraw.setPenColor(255, 0, 0);
                    PennDraw.rectangle(0.2, 0.5, 0.15, 0.15);
                    
                    return true;
                }
            }
            //box 5
            if (this.row < 6 && this.row >= 3 && this.column >= 3 && this.column < 6
            ) {
                if (checkIfBoxesIsInCorrect(3, 3, input)) {
                    PennDraw.setPenColor(255, 0, 0);
                    PennDraw.rectangle(0.5, 0.5, 0.15, 0.15);
                    
                    return true;
                }
            }
            //box 6
            if (this.row < 6 && this.row >= 3 && this.column >= 6 && this.column < 9
            ) {
                if (checkIfBoxesIsInCorrect(3, 6, input)) {
                    PennDraw.setPenColor(255, 0, 0);
                    PennDraw.rectangle(0.8, 0.5, 0.15, 0.15);
                    
                    return true;
                }
            }
            //box 7
            if (this.row < 9 && this.row >= 6 && this.column >= 0 && this.column < 3
            ) {
                if (checkIfBoxesIsInCorrect(6, 0, input)) {
                    PennDraw.setPenColor(255, 0, 0);
                    PennDraw.rectangle(0.2, 0.2, 0.15, 0.15);
                    
                    return true;
                }
            }
            //box 8
            if (this.row < 9 && this.row >= 6 && this.column >= 3 && this.column < 6
            ) {
                if (checkIfBoxesIsInCorrect(6, 3, input)) {
                    PennDraw.setPenColor(255, 0, 0);
                    PennDraw.rectangle(0.5, 0.2, 0.15, 0.15);
                    return true;
                }
            }
            //box 9
            if (this.row < 9 && this.row >= 6 && this.column >= 6 && this.column < 9
            ) {
                if (checkIfBoxesIsInCorrect(6, 6, input)) {
                    PennDraw.setPenColor(255, 0, 0);
                    PennDraw.rectangle(0.8, 0.2, 0.15, 0.15);
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
    * Inputs: starting row of the box to check in, starting column of the box to
    * check in and the users input
    * Outputs: boolean - if the users input in the box is correct or incorrect
    * Description: checks if the users input is valid in the current states of its
    * respective box
    */
    public boolean checkIfBoxesIsInCorrect(int startingRow, int startingColumn,
    String input) {
        if (startingRow < 7 && startingColumn < 7) {
            for (int i = startingRow; i < startingRow + 3; i++) {
                for (int j = startingColumn; j < startingColumn + 3; j++) {
                    if (input != null && !input.equals(" ") &&
                    i != this.row && j != this.column && input.equals(
                    this.newSudokuGrid.getValueFromGrid(i, j))) {
                        String a = this.newSudokuGrid.getValueFromGrid(i, j);
                        drawConflictingValueInRed(i, j, a);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
    * Inputs: row position of value, column position of value and the String value
    *(integer between 1-9) that should be highlighted in red
    * Outputs: no output
    * Description: draws the conflicting value in bold and red then resets
    * the penn draw font and colour
    */
    public void drawConflictingValueInRed(int rowPos, int colPos, String value) {
        double centerY = (9 - rowPos) * 0.1;
        double centerX = (colPos * 0.1) + 0.1;
        PennDraw.setFontBold();
        PennDraw.setPenColor(255, 0, 0);
        PennDraw.text(centerX, centerY, value);
        PennDraw.setFontPlain();
    }
    
}
