package calculator.view;

import calculator.domain.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMETER_BLANK = " ";

    private InputView() {
        throw new AssertionError();
    }

    public static String inputFormula() {
        System.out.println("수식을 입력하세요.");

        String inputFormula = SCANNER.nextLine();
        validateInput(inputFormula);

        return inputFormula;
    }

    private static void validateInput(String inputFormula) {
        Validator.validateInputFormula(inputFormula);
        Validator.validateArithmeticFormula(inputFormula);
    }

    public static List<Integer> parseOperands(String input) {
        return splitInputFormula(input).stream()
                .filter(string -> string.matches("[0-9]+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> parseOperators(String input) {
        return splitInputFormula(input).stream()
                .filter(string -> !string.matches("[0-9]+"))
                .collect(Collectors.toList());
    }

    private static List<String> splitInputFormula(String input) {
        return Arrays.asList(input.split(DELIMETER_BLANK));
    }
}
