package com.example.sudoku.controller;

import java.awt.*;

public interface ISudokuController {
    void initializeGame(); // Inicializa el juego
    void handleCellInput(int row, int col, String value); // Maneja la entrada de una celda
    void setTextFieldValue(int row, int col, String value);
    void showHelp(); // Muestra ayuda al jugador
}