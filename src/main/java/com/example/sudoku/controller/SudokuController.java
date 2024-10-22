package com.example.sudoku.controller;

import com.example.sudoku.model.SudokuModel;
import com.example.sudoku.model.ISudokuModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import java.util.Random;
import javafx.scene.Node;

import java.util.concurrent.atomic.AtomicInteger;

public class SudokuController implements ISudokuController {

    private ISudokuModel sudokuModel;

    @FXML
    private VBox sudokuBase;

    @FXML
    GridPane grid = new GridPane();

    @Override
    public void initializeGame() {

        sudokuModel = new SudokuModel(); // O podrías inyectar otra implementación del modelo si fuera necesario

        grid.getStyleClass().add("custom-grid");

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                TextField cell = createTextField(row, col);
                grid.add(cell, col, row);
            }
        }
        sudokuBase.getChildren().add(grid);

        for (int i = 0; i < 20; i++) {
            showHelp();
        }
    }

    @FXML
    void helpButton(ActionEvent event) {
        showHelp();
    }

    public void setTextFieldValue(int row, int col, String value) {
        // Busca el nodo (TextField) en la posición específica
        for (Node node : grid.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col) {
                // Si encontramos el nodo en la fila y columna especificadas
                if (node instanceof TextField) {
                    ((TextField) node).setText(value); // Asignar el valor al TextField
                }
                break;
            }
        }
    }

    @Override
    public void showHelp() {
        Random random = new Random();
        int randomRow = random.nextInt(5);
        int randomCol = random.nextInt(5);
        String aux = sudokuModel.getBoard().get(randomRow).get(randomCol).toString();
        setTextFieldValue(randomRow, randomCol,aux);

    }

    @Override
    public void handleCellInput(int row, int col, String value) {

    }

    private TextField createTextField(int row, int col) {
        TextField textField = new TextField();
        textField.setPrefWidth(50); // Tamaño del TextField
        textField.setMaxWidth(50);

        // Limitar el TextField a una sola letra y números del 1 al 6
        textField.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String input = event.getCharacter();
            // Si el input no es un número entre 1 y 6, o si ya tiene un carácter, cancelar el evento

            if (!input.matches("[1-6]") || !textField.getText().isEmpty()) {
                event.consume();
            }

        });

        // Añadir el estilo del archivo CSS al TextField
        textField.getStyleClass().add("text-field");
        return textField;
    }

    @FXML
    public void initialize() {
        initializeGame(); // Llamar al metodo de inicialización
    }
}
