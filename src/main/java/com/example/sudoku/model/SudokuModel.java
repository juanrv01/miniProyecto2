package com.example.sudoku.model;
import java.util.ArrayList;
import java.util.Collections;

public class SudokuModel {

    private ArrayList<ArrayList<Integer>> board;

    public SudokuModel() {
        board = new ArrayList<>();
        generateSudoku();
    }

    // Metodo para generar un Sudoku 6x6 con subcuadrículas de 2x3
    private void generateSudoku() {
        // Inicializa el tablero con filas vacías
        for (int i = 0; i < 6; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < 6; j++) {
                board.get(i).add(0); // Llena el tablero con ceros temporalmente
            }
        }

        // Llama al metodo recursivo de backtracking para llenar el tablero
        fillBoard(0, 0);
    }

    // Metodo recursivo de backtracking para llenar el tablero
    private boolean fillBoard(int row, int col) {
        // Si llegamos al final del tablero, hemos terminado
        if (row == 6) {
            return true;
        }

        // Si llegamos al final de una fila, pasamos a la siguiente
        int nextRow = (col == 5) ? row + 1 : row;
        int nextCol = (col == 5) ? 0 : col + 1;

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers); // Mezclar los números para hacer la generación aleatoria

        // Probar cada número en la celda actual
        for (int num : numbers) {
            if (isValidPlacement(row, col, num)) {
                board.get(row).set(col, num); // Coloca el número

                // Llamada recursiva para intentar llenar la siguiente celda
                if (fillBoard(nextRow, nextCol)) {
                    return true; // Si se llena correctamente el resto del tablero, retorna verdadero
                }

                // Si falla, deshacemos el número colocado
                board.get(row).set(col, 0);
            }
        }
        return false; // No se pudo colocar un número válido en esta celda
    }

    // Verificar si un número puede ser colocado en una celda sin romper las reglas
    private boolean isValidPlacement(int row, int col, int num) {
        // Verificar la fila
        for (int i = 0; i < 6; i++) {
            if (board.get(row).get(i) == num) {
                return false;
            }
        }

        // Verificar la columna
        for (int i = 0; i < 6; i++) {
            if (board.get(i).get(col) == num) {
                return false;
            }
        }

        // Verificar la subcuadrícula de 2x3
        int boxRowStart = (row / 2) * 2; // Encuentra el inicio de la subcuadrícula
        int boxColStart = (col / 3) * 3;
        for (int i = boxRowStart; i < boxRowStart + 2; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (board.get(i).get(j) == num) {
                    return false;
                }
            }
        }

        return true; // El número puede ser colocado
    }

    // Metodo para obtener el tablero
    public ArrayList<ArrayList<Integer>> getBoard() {
        return board;
    }

    // Metodo para imprimir el tablero en la consola (opcional)
    public void printBoard() {
        for (ArrayList<Integer> row : board) {
            System.out.println(row);
        }
    }
}
