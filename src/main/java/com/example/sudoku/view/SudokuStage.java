package com.example.sudoku.view;

import com.example.sudoku.controller.SudokuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuStage extends Stage {

    private SudokuController sudokuController;

    public SudokuStage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/sudoku/main-view.fxml"));
        Parent root = fxmlLoader.load();
        sudokuController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        setScene(scene);
        setTitle("Sudoku");
        setResizable(false);
        show();
    }

    public SudokuController getSudokuController() {
        return sudokuController;
    }
}
