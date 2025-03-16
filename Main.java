
import java.io.*;
import java.util.Arrays;

public class Main {

    static final int NUMBER_PLAYERS = 10; // число игроков в команде

    public static void main(String[] args) throws IOException {
        int[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
    }

    /**
     * Метод для слияния всех команд в одну национальную
     */
    public static int[] mergeAll(int[][] teams) {
        // Ваш код
        int[] intermediate = teams[0]; // промежуточный массив
        int count = 1;

        while (count <= teams.length - 1) {
            int[] mergeTwo_One = merge(intermediate, teams[count]); // передаем данные для слияния
            intermediate = mergeTwo_One; // записываем результат слияния в промежуточный
            count += 1;
        }
        return intermediate;
    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static int[] merge(int[] teamA, int[] teamB) {
        // Ваш код
        int[] teamC = new int[NUMBER_PLAYERS];
        int iA = 0;
        int iB = 0;
        int iC = 0;

        while (iC < teamC.length) {

            if (teamA[iA] >= teamB[iB]) {
                teamC[iC] = teamA[iA];
                iA += 1;
            } else {
                teamC[iC] = teamB[iB];
                iB += 1;
            }

            iC += 1;

        }
        //System.out.println(Arrays.toString(teamC));

        return teamC;
    }
}