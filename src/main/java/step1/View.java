package step1;

import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);

    public static String readInput() {
        System.out.println("문자열 입력");

        return scanner.nextLine();
    }

    public static void printResult(int result) {
        System.out.println("결과: " + result);
    }
}
