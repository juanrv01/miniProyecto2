package com.example.sudoku.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SudokuController {

    @FXML
    private VBox sudokuBase;

    @FXML
    void helpButton(ActionEvent event) {
        System.out.println("Ayudando al jugador");
    }

    @FXML
    public void initialize() {
        // Crear el GridPane
        GridPane grid = new GridPane();
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                TextField cell = createTextField();
                grid.add(cell, col, row);
            }
        }
        sudokuBase.getChildren().add(grid);

    }

    private TextField createTextField() {
        TextField textField = new TextField();
        textField.setPrefWidth(50); // Tamaño del TextField
        textField.setMaxWidth(50);

        // Limitar el TextField a una sola letra y números del 1 al 6
        textField.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String input = event.getCharacter();
            // Si el input no es un número entre 1 y 6, o si ya tiene un carácter, cancelar el evento
            if (!input.matches("[1-6]") || textField.getText().length() >= 1) {
                event.consume();
            }
        });

        // Añadir el estilo del archivo CSS al TextField
        textField.getStyleClass().add("text-field");

        return textField;
    }

}

