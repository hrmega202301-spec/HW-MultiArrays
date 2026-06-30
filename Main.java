import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Дана следующая матрица");
        int[][] colors = new int[SIZE][SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }

        while (true) {
            System.out.println("Введите номер градуса на сколько хотите перевернуть");
            String[] flip = {"90", "180", "270"};
            for (int i = 0; i < flip.length; i++) {
                System.out.println((i + 1) + ". " + flip[i] + " градусов");
            }
            String input = scanner.nextLine();
            int[][] rotatedColors = new int[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (input.equals("end") || input.equals("утв")) {
                        break;
                    }
                    int operation = Integer.parseInt(input);
                    switch (operation) {
                        case 1:
                            rotatedColors[i][j] = colors[SIZE - 1 - j][i];
                            break;
                        case 2:
                            rotatedColors[i][j] = colors[SIZE - 1 - i][SIZE - 1 - j];
                            break;
                        case 3:
                            rotatedColors[i][j] = colors[j][SIZE - 1 - i];
                            break;
                    }
                    System.out.format("%4d", rotatedColors[i][j]);
                }
                System.out.println();
            }
        }
    }
}