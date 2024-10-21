package com.example.sudoku;

import com.example.sudoku.view.SudokuStage;
import com.example.sudoku.model.SudokuModel;
import javafx.application.Application;
import javafx.stage.Stage;


import java.io.IOException;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        new SudokuStage();
    }
}



/*
public class main extends SudokuModel {
    // Declare sudoku as a class variable
    static SudokuModel sudoku;

    public static void main(String[] args) {
        // Initialize sudoku in the main method
        sudoku = new SudokuModel();
        sudoku.printBoard();
    }

    // ... rest of your code ...
}
*/
