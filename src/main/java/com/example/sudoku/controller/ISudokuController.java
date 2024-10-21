package com.example.sudoku.controller;

public interface ISudokuController {
    void initializeGame(); // Inicializa el juego
    void handleCellInput(int row, int col, String value); // Maneja la entrada de una celda
    void showHelp(); // Muestra ayuda al jugador
}
