package calculator;

import java.util.Scanner;

public class CalculatorApplication {

    public static final String MSG_INPUT_EXPRESSION = "계신식을 입력해주세요.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(MSG_INPUT_EXPRESSION);
        String s = scanner.nextLine();

        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(s));
    }
}
