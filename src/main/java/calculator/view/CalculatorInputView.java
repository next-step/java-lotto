package calculator.view;

import java.util.Scanner;

public class CalculatorInputView {

    public static final String QUESTION_START = "연산식을 입력하세요";

    static Scanner scanner = new Scanner(System.in);

    public static String scanString() {
        printQuestionStart();
        return StringResult();
    }

    private static String StringResult() {
        return scanner.nextLine();
    }

    private static void printQuestionStart() {
        System.out.println(QUESTION_START);
    }

}
