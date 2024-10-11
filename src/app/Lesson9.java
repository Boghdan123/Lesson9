package app;


import java.util.Random;


public class Lesson9 {


    public static void main(String[] args) {
        int[][] matrix = new int[4][4];

        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = random.nextInt(50) + 1;
            }
        }

        System.out.println("Матриця 4x4:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int evenRowSum = 0;
        int oddRowSum = 0;
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 4; j++) {
                    evenRowSum += matrix[i][j];
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    oddRowSum += matrix[i][j];
                }
            }
        }

        long evenColProduct = 1;
        long oddColProduct = 1;
        for (int j = 0; j < 4; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < 4; i++) {
                    evenColProduct *= matrix[i][j];
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    oddColProduct *= matrix[i][j];
                }
            }
        }

        System.out.println("Сума елементів у парних рядках (0, 2): " + evenRowSum);
        System.out.println("Сума елементів у непарних рядках (1, 3): " + oddRowSum);
        System.out.println("Добуток елементів у парних стовпцях (0, 2): " + evenColProduct);
        System.out.println("Добуток елементів у непарних стовпцях (1, 3): " + oddColProduct);

        if (isMagicSquare(matrix)) {
            System.out.println("Матриця є магічним квадратом.");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
    }

    public static boolean isMagicSquare(int[][] matrix) {
        int sumDiag1 = 0;
        int sumDiag2 = 0;
        for (int i = 0; i < 4; i++) {
            sumDiag1 += matrix[i][i];
            sumDiag2 += matrix[i][3 - i];
        }

        if (sumDiag1 != sumDiag2) {
            return false;
        }

        int rowSum;
        int colSum;

        for (int i = 0; i < 4; i++) {
            rowSum = 0;
            colSum = 0;
            for (int j = 0; j < 4; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            if (rowSum != sumDiag1 || colSum != sumDiag1) {
                return false;
            }
        }

        return true;
    }
}
