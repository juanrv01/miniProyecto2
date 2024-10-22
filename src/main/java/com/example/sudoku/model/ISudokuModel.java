package com.example.sudoku.model;

import java.util.ArrayList;

public interface ISudokuModel {
    ArrayList<ArrayList<Integer>> generateSudoku(); // Genera un nuevo Sudoku
    ArrayList<ArrayList<Integer>> generateEmptySudoku(); // Genera un nuevo Sudoku vacio
    boolean isValidPlacement(int row, int col, int num); // Verifica si se puede colocar un número
    ArrayList<ArrayList<Integer>> getBoard(); // Obtiene el tablero actual
    ArrayList<ArrayList<Integer>> getAttempt(); // Obtiene el tablero actual
    void printBoard(); // Imprime el tablero en la consola
}
