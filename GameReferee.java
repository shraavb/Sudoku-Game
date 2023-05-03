/**
* Name: Shraavasti Bhat
* Pennkey: shraab
* Execution: java GameReferee [file containing sudokuValues]
*
* Description: Create a new game that takes in a given file and inserts the values
* into the sudoku grid
* Converts user values into row and column which can be used by SudokuGrid class
* Inputs users values into the sudoku grid
* Checks if the user input is correct using functions from the CheckRowColumnBox
* class
* Highlights incorrect regions using CheckRowColumnBox functions
* ReDraws board if previous values were incorrect to remove the red higlights
* Contains main method - starts the game
**/

public class GameReferee {
    private String fileName;
    private String sudokuValues;
    private SudokuGrid newSudokuGrid;
    
    /**
    * Inputs: fileName of file contains values for sudoku games
    * Outputs: no output
    * Description: checks if starting sudoku given is valid and converts it into
    * a string that can be used by other classes
    */
    public GameReferee(String filename) {
        In inStream = new In(filename);
        String sudokuValuesTest = "";
        String allSudokuValues = inStream.readAll();
        
        if (allSudokuValues.length() != 89) {
            throw new IllegalArgumentException(
            "Impossible grid - insufficient values to play sudoku");
        }
        
        this.sudokuValues = "" + allSudokuValues.substring(0, 9) +
        allSudokuValues.substring(10, 19) +
        allSudokuValues.substring(20, 29) +
        allSudokuValues.substring(30, 39) +
        allSudokuValues.substring(40, 49) +
        allSudokuValues.substring(50, 59) +
        allSudokuValues.substring(60, 69) +
        allSudokuValues.substring(70, 79) +
        allSudokuValues.substring(80, 89);
        
        if (sudokuValues.length() != 81) {
            throw new IllegalArgumentException("Impossible grid");
        }
        
        for (int i = 0; i < allSudokuValues.length(); i++) {
            if (allSudokuValues.charAt(i) != '\n' && !isInputValid(
            allSudokuValues.charAt(i))) {
                throw new IllegalArgumentException("Contains other characters");
            }
        }
        newSudokuGrid = new SudokuGrid(sudokuValues);
        
        if (!checkIfCurrentSudokuGridIsCorrect()) {
            throw new IllegalArgumentException("Invalid Grid from text file");
        }
    }
    
    /**
    * Inputs: row
    * Outputs: double - the Y center value for that space in the 2D sudoku grid
    * Description: converts the row to the Y center value for that space in the
    * 2D sudoku grid
    */
    public double convertRowToYCenter(int rowPos) {
        return (9 - rowPos) * 0.1;
    }
    
    /**
    * Inputs: column
    * Outputs: double - the X center value for that space in the 2D sudoku grid
    * Description: converts the column to the X center value for that space in the
    * 2D sudoku grid
    */
    public double convertColToXCenter(int colPos) {
        return (colPos * 0.1) + 0.1;
    }
    
    /**
    * Inputs: no input
    * Outputs: on output
    * Description: redraws board with current values in the 2D sudoku grid array
    * This is used if the previous move was illegal so the screen needs to be
    * cleared and the board needs to be re-drawn
    */
    public void reDrawCurrentBoard() {
        PennDraw.picture(0.5, 0.5, "sudokucanvas.png", 460.8, 460.8);
        this.newSudokuGrid.drawInitialValuesOnSudokuBoardInBold(this.sudokuValues);
        int noInArray = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String a = "" + this.sudokuValues.charAt(noInArray);
                if (a.equals(" ")) {
                    PennDraw.text(convertColToXCenter(j), convertRowToYCenter(i),
                    this.newSudokuGrid.getValueFromGrid(i, j));
                }
                noInArray++;
            }
        }
    }
    
    /**
    * Inputs: mouse x position, mouse y position and number typed
    * Outputs: no output
    * Description: converts mouse click to row and column, checks if inputting the
    * users value at that position in the 2D array is legal and if the input is
    * valid in the game
    */
    public void input(double mouseX, double mouseY, String numberTyped) {
        PennDraw.setPenColor(0, 0, 0);
        //Convert mouse input to location of nummber in array
        int row = convertMouseYToRow(mouseY);
        int column = convertMouseXToCol(mouseX);
        CheckRowColumnBox checkForCurrentGrid = new CheckRowColumnBox(
        row, column, this.newSudokuGrid);
        
        char input = numberTyped.charAt(0);
        if (isInputValid(input)) {
            checkForCurrentGrid.checkIfIllegalMoveVertical(numberTyped);
            checkForCurrentGrid.checkIfIllegalMoveHorizontal(numberTyped);
            checkForCurrentGrid.checkIfIllegalMoveInBox(numberTyped);
            PennDraw.text(
            convertColToXCenter(column), convertRowToYCenter(row), numberTyped);
            this.newSudokuGrid.inputValue(row, column, numberTyped);
        }
    }
    
    /**
    * Inputs: the players input in char form
    * Outputs: boolean - whether the users input is valid in the game
    * Description: check if the input is a number between 1-9 and not any other
    * value
    */
    public boolean isInputValid(char input) {
        int asciiValue = (int) input;
        if (asciiValue == 32) {
            return true;
        }
        
        else if (asciiValue <= 57 && asciiValue >= 49) {
            return true;
        }
        
        else {
            return false;
        }
    }
    
    /**
    * Inputs: no input
    * Outputs: boolean values that states if the game is over
    * Description: checks if the game is over by making sure that there are no more
    * empty space in the 2D sudoku array
    */
    public boolean checkIfGameOver() {
        if (!this.newSudokuGrid.checkIfEmpty() && checkIfCurrentSudokuGridIsCorrect(
        )) {
            return true;
        }
        return false;
    }
    
    /**
    * Inputs: the current SudokuGrid in the game
    * Outputs: boolean - if the sudoku is correct and follows all of the rules(true)
    * if the sudoku is incorrect(false)
    * Description: checks if the current state of the sudoku grid is correct
    */
    public boolean checkIfCurrentSudokuGridIsCorrect() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                CheckRowColumnBox fullCheck = new CheckRowColumnBox(
                i, j, this.newSudokuGrid);
                
                if (fullCheck.checkIfIllegalMoveHorizontal(
                this.newSudokuGrid.getGridSpace(i, j).getValue())) {
                    return false;
                }
                if (fullCheck.checkIfIllegalMoveVertical(
                this.newSudokuGrid.getValueFromGrid(i, j))) {
                    return false;
                }
                if (fullCheck.checkIfIllegalMoveInBox(
                this.newSudokuGrid.getGridSpace(i, j).getValue())) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
    * Inputs: mouse x position
    * Outputs: the column x position corresponds to in the sudoku 2d array grid
    * Description: converts mouse x position to column values
    */
    public int convertMouseXToCol(double mouseX) {
        return (int) (mouseX / 0.111111111111111);
    }
    
    /**
    * Inputs: mouse y position
    * Outputs: the row that the users click corresponds to in the sudoku grid
    * Description: converts the users click into the row position in the 2d array
    */
    public int convertMouseYToRow(double mouseY) {
        return 9 - 1 - (int) (mouseY / 0.111111111111111);
    }
    
    /**
    * Inputs: row, column, number typed by user and the sudoku grid to check in
    * Outputs: boolean - whether an illegal move was made
    * Description: checks if the input numberTyped at the respective row and column
    * was illegal
    */
    public boolean checkIfIllegalMoveWasMade(int row, int column, String numberTyped
    , SudokuGrid newSudokuGrid) {
        int numOfErrors = 0;
        CheckRowColumnBox checkForCurrentGrid = new CheckRowColumnBox(
        row, column, newSudokuGrid);
        
        if (checkForCurrentGrid.checkIfIllegalMoveVertical(numberTyped)) {
            numOfErrors++;
        }
        if (checkForCurrentGrid.checkIfIllegalMoveHorizontal(numberTyped)) {
            numOfErrors++;
        }
        if (checkForCurrentGrid.checkIfIllegalMoveInBox(numberTyped)) {
            numOfErrors++;
        }
        
        if (numOfErrors > 0) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        String filename = args[0];
        GameReferee s = new GameReferee(filename);
        double mouseX = 0.0;
        double mouseY = 0.0;
        double previousMouseX = 0.0;
        double previousMouseY = 0.0;
        boolean clickedBox = false;
        String prevInput = "";
        int rowClicked = 0;
        int colClicked = 0;
        int rowPrev = 0;
        int colPrev = 0;
        String numberTyped = "";
        PennDraw.enableAnimation(30);
        boolean hasClickedAtLeastOnce = false;
        SudokuGrid prevSudokuGrid = s.newSudokuGrid;
        
        while (!s.checkIfGameOver()) {
            if (hasClickedAtLeastOnce) {
                numberTyped = " ";
            }
            
            if (PennDraw.mousePressed()) {
                prevSudokuGrid = s.newSudokuGrid;
                clickedBox = true;
                //Stores and draws the value of the key if it has been typed
                mouseX = PennDraw.mouseX();
                mouseY = PennDraw.mouseY();
                rowClicked = s.convertMouseYToRow(mouseY);
                colClicked = s.convertMouseXToCol(mouseX);
                
                //If previous move was illegal this blocks user from clicking box
                //other than illegal value that disrupts the game
                if (hasClickedAtLeastOnce && !s.checkIfCurrentSudokuGridIsCorrect()
                ) {
                    //if box other than box containing value was pressed it should
                    //have no effect on the sudoku grid as the game cannot go on
                    if (s.newSudokuGrid.getGridSpace(rowPrev, colPrev) !=
                    s.newSudokuGrid.getGridSpace(rowClicked, colClicked)) {
                        //illegal click - clicked different square when input is
                        //wrong
                        clickedBox = false;
                    }
                }
                //User cannot edit original sudoku values given by the file
                if (s.newSudokuGrid.getGridSpace(rowClicked, colClicked
                ).getIfSpaceIsUnchangeable()) {
                    clickedBox = false;
                }
                
            }
            
            if (clickedBox) {
                if (PennDraw.hasNextKeyTyped()) {
                    PennDraw.setPenColor(0, 0, 0);
                    numberTyped = "" + PennDraw.nextKeyTyped();
                    previousMouseY = mouseY;
                    previousMouseX = mouseX;
                    prevInput = numberTyped;
                    rowPrev = s.convertMouseYToRow(previousMouseY);
                    colPrev = s.convertMouseXToCol(previousMouseX);
                    if (hasClickedAtLeastOnce) {
                        if (s.checkIfIllegalMoveWasMade(rowPrev, colPrev, prevInput,
                        prevSudokuGrid)) {
                            //remove the illegal value from the sudoku grid
                            s.newSudokuGrid.removeValueFromGrid(rowPrev, colPrev);
                        }
                        
                        else {
                            s.newSudokuGrid.removeValueFromGrid(rowClicked,
                            colClicked);
                        }
                        
                        PennDraw.setPenColor(0, 0, 0);
                        PennDraw.clear();
                        s.reDrawCurrentBoard();
                        //keep track of the current state of the board in case
                        //the next input is illegal
                        prevSudokuGrid = s.newSudokuGrid;
                        s.input(mouseX, mouseY, numberTyped);
                    }
                    //For the first click there will be no previous SudokuGrid so
                    //the users input will just be inputted
                    if (hasClickedAtLeastOnce == false) {
                        s.input(mouseX, mouseY, numberTyped);
                    }
                    
                    clickedBox = false;
                }
            }
            
            if (hasClickedAtLeastOnce == false) {
                hasClickedAtLeastOnce = true;
            }
            PennDraw.advance();
        }
        
        if (s.checkIfGameOver() && !clickedBox) {
            PennDraw.clear();
            String winMessage = "You have won!";
            PennDraw.setPenColor(255, 165, 0);
            PennDraw.setFontSize(20);
            PennDraw.setFontBold();
            PennDraw.text(0.5, 0.5, winMessage);
            PennDraw.advance();
            PennDraw.disableAnimation();
        }
    }
}
