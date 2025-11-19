package calculator.view;

import java.util.Scanner;
import calculator.model.Number;

public class CalculatorView {
    public static String readExpressionInput() {
        Scanner scanner = new Scanner(System.in);
        print("계산식을 입력하세요 (예: 2 + 3 * 4 / 2)");
        return scanner.nextLine();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printResult(Number number) {
        System.out.println("계산 결과: " + number.value());
    }
}
