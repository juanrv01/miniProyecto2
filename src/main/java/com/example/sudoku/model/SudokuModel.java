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

        // Llama al metodo recursivo para llenar el tablero de acuerdo con las reglas
        fillBoard();
    }

    // Metodo para llenar el tablero aleatoriamente con valores válidos
    private boolean fillBoard() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }

        // Llenar fila por fila
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                Collections.shuffle(numbers); // Mezcla los números en cada iteración
                for (int num : numbers) {
                    if (isValidPlacement(row, col, num)) {
                        board.get(row).set(col, num); // Coloca el número si es válido
                        break;
                    }
                }
            }
        }
        return true;
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
