package calculator;

import view.InputView;

import java.util.Scanner;

public class CalculatorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("사칙 연산을 수행할 문자열을 입력하세요: ");
        String input = scanner.nextLine();

        InputView.calculate(input);
    }
}
