package controller;

import parser.InputParser;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private static final InputParser inputParser = new InputParser();

    public String inputCalculationString() {
        System.out.println("계산할 문자열을 입력하세요.(단, 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있어야 합니다.)");

        String calculateString = scanner.nextLine();

        if (isValidInput(calculateString)) {
            return calculateString;
        }

        return null;
    }

    private boolean isValidInput(String calculateString) {

        if (calculateString.isEmpty()) {
            throw new IllegalArgumentException("입력은 비어있을 수 없습니다.");
        }

        String regex = "^[\\d+\\-*/\\s]+";

        if (!calculateString.matches(regex)) {
            throw new IllegalArgumentException("입력은 숫자와 사칙연산 기호로만 이루어질 수 있습니다");
        }

        regex = "\\d+([ ]+[^\\w\\s][ ]+\\d+)*";

        if (!calculateString.matches(regex)) {
            throw new IllegalArgumentException("숫자와 사칙연산 기호 사이에는 반드시 하나의 공백이 포함되어야 합니다.");
        }



        return true;
    }

    public List<Integer> getNumbers(String calculateString) {
        return inputParser.parseNumbers(calculateString);
    }

    public List<Character> getOperations(String calculateString) {
        return inputParser.parseOperations(calculateString);
    }
}
