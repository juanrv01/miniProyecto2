package com.example.sudoku.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class SudokuController implements ISudokuController {

    @FXML
    private VBox sudokuBase;

    @FXML
    void helpButton(ActionEvent event) {
        showHelp();
    }

    @Override
    public void initializeGame() {
        // Crear el GridPane
        GridPane grid = new GridPane();
        grid.getStyleClass().add("custom-grid");

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                TextField cell = createTextField(row, col);
                grid.add(cell, col, row);
            }
        }
        sudokuBase.getChildren().add(grid);
    }

    @Override
    public void showHelp() {
        System.out.println("Ayudando al jugador");
    }

    @Override
    public void handleCellInput(int row, int col, String value) {
        // Aquí puedes manejar la lógica para la entrada de cada celda
        System.out.println("Celda [" + row + ", " + col + "] valor: " + value);
    }

    private TextField createTextField(int row, int col) {
        TextField textField = new TextField();
        textField.setPrefWidth(50); // Tamaño del TextField
        textField.setMaxWidth(50);

        // Limitar el TextField a una sola letra y números del 1 al 6
        textField.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String input = event.getCharacter();
            // Si el input no es un número entre 1 y 6, o si ya tiene un carácter, cancelar el evento
            if (!input.matches("[1-6]") || textField.getText().length() >= 1) {
                event.consume();
            } else {
                handleCellInput(row, col, input); // Manejar la entrada
            }
        });

        // Añadir el estilo del archivo CSS al TextField
        textField.getStyleClass().add("text-field");

        textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Cuando el TextField es seleccionado
                textField.getStyleClass().add("selected");
            } else { // Cuando el TextField pierde el enfoque
                textField.getStyleClass().remove("selected");
            }
        });

        return textField;
    }

    @FXML
    public void initialize() {
        initializeGame(); // Llamar al metodo de inicialización
    }
}
