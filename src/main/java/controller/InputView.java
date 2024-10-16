package controller;

import parser.InputParser;
import validator.Validator;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputCalculationString() {
        System.out.println("계산할 문자열을 입력하세요.(단, 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있어야 합니다.)");

        String calculateString = scanner.nextLine();

        Validator.isValidInput(calculateString);

        return calculateString;
    }

    public static List<Integer> getNumbers(String calculateString) {
        return InputParser.parseNumbers(calculateString);
    }

    public static List<Character> getOperations(String calculateString) {
        return InputParser.parseOperations(calculateString);
    }
}
