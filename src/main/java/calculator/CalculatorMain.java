package calculator;

import calculator.domain.Formula;
import java.util.Scanner;

public class CalculatorMain {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("수식을 입력하세요");
        String input = scanner.nextLine();

        Formula formula = new Formula(input);
        int result = formula.calculate();

        System.out.println("결과 : " + result);
    }
}
