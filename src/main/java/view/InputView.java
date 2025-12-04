package view;

import calculator.Calculator;

import java.util.Scanner;

import static calculator.Calculator.calculate;

public class InputView {

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("사칙 연산을 수행할 문자열을 입력하세요: ");

        calculate(parseInput(scanner.nextLine()));
    }

    public static String[] parseInput(String input) {
        return input.split(" ");
    }
}
