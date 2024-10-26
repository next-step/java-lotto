package stringCalculator.view;

import stringCalculator.domain.MathExpression;
import stringCalculator.domain.MathExpressionFactory;

import java.util.Scanner;

public class StringCalculatorInputView {
    private static Scanner scanner;

    public static void initiateScanner() {
        scanner = new Scanner(System.in);
    }

    public static String scanString() {
        System.out.println("사칙연산을 입력해주세요. (숫자와 연산 사이에는 반드시 공백을 넣어주세요) : ");
        return scanner.nextLine();
    }

    public static MathExpression createMathExpressionWithScan() {
        return MathExpressionFactory.seperateAndCreateMathExpression(scanString());
    }
}
