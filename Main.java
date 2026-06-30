import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;

    public static int[][] generateMatrix() {
        Random random = new Random();
        int[][] matrix = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = random.nextInt(256);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] rotate90(int[][] matrix) {
        int[][] result = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[i][j] = matrix[SIZE - 1 - j][i];
            }
        }
        return result;
    }

    public static int[][] rotate180(int[][] matrix) {
        int[][] result = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[i][j] = matrix[SIZE - 1 - i][SIZE - 1 - j];
            }
        }
        return result;
    }

    public static int[][] rotate270(int[][] matrix) {
        int[][] result = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[i][j] = matrix[j][SIZE - 1 - i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = generateMatrix();
        System.out.println("Исходная матрица: ");
        printMatrix(matrix);
        while (true) {
            System.out.println("Выберите номер угла поворота");
            String[] flip = {"90 градусов", "180 градусов", "270 градусов"};
            for (int i = 0; i < flip.length; i++) {
                System.out.println((i + 1) + "." + flip[i]);
            }
            String input = scanner.nextLine();
            if (input.equals("end") || input.equals("утв")) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    printMatrix(rotate90(matrix));
                    break;
                case 2:
                    printMatrix(rotate180(matrix));
                    break;
                case 3:
                    printMatrix(rotate270(matrix));
                    break;
                default:
                    System.out.println("Неккоректный выбор");
            }
        }
    }
}
