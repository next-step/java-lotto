package stringcalculator.view;

import java.util.Scanner;

public class ResultView {
    private static Scanner scanner = new Scanner(System.in);

    public static void result(int result) {
        System.out.println("정답: " + result);
    }
}
