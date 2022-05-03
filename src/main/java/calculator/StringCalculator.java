package calculator;

import calculator.model.Formula;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String CALCULATION_DELIMITER = " ";
    private static final String NUMBER_REGEX = "[0-9]";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);
    private static final String OPERATOR_REGEX = "[-+*/]";
    private static final Pattern OPERATOR_PATTERN = Pattern.compile(OPERATOR_REGEX);

    private final Queue<Integer> numbers = new LinkedList<>();
    private final Queue<String> operators = new LinkedList<>();


    public StringCalculator(Formula formula) {
        String[] formulaCharacters = formula.split(CALCULATION_DELIMITER);

        for (String formulaCharacter : formulaCharacters) {
            separateFormula(formulaCharacter);
        }
    }

    private void separateFormula(String formulaCharacter) {
        if (isNumber(formulaCharacter)) {
            numbers.add(toNumber(formulaCharacter));
        }

        if (isOperator(formulaCharacter)) {
            operators.add(formulaCharacter);
        }
    }

    private boolean isNumber(String formulaCharacter) {
        return NUMBER_PATTERN.matcher(formulaCharacter).matches();
    }

    private Integer toNumber(String formulaCharacter) {
        return Integer.parseInt(formulaCharacter);
    }

    private boolean isOperator(String formulaCharacter) {
        return OPERATOR_PATTERN.matcher(formulaCharacter).matches();
    }

    public int start() {
        int number = this.numbers.poll();
        while (!numbers.isEmpty()) {
            number = calculate(number, operators.poll(), this.numbers.poll());
        }

        return number;
    }

    private int calculate(int number1, String operator, int number2) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "*":
                return number1 * number2;
            case "-":
                return number1 - number2;
            case "/":
                return number1 / number2;
            default:
                throw new IllegalStateException();
        }
    }

}
