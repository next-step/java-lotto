package step1.view;

import java.util.Scanner;

public class CalculatorInput {
    private static final String INPUT_MENT = "숫자오 구분자 문자열을 입력하시오 : ";

    public static String inputGameCoin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_MENT);
        String scanString = scanner.nextLine();

        return scanString;
    }
}