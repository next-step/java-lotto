package calculator;

import java.util.ArrayList;
import java.util.List;

public class Extractor {
    static private String START_CUSTOM_DELIMITER = "//";
    static private String END_CUSTOM_DELIMITER = "\n";
    static private String BASIC_DELIMITER = ":|,";

    String equation;

    public Extractor(String equation) {
        this.equation = equation;
    }

    public String getDelimiter() {
        if (checkCustomDelimiter()) {
            int start = START_CUSTOM_DELIMITER.length();
            int end = equation.indexOf(END_CUSTOM_DELIMITER);

            return equation.substring(start, end);
        }

        return BASIC_DELIMITER;
    }

    public String getRefinedEquation() {
        if (checkCustomDelimiter()) {
            int end = equation.indexOf(END_CUSTOM_DELIMITER);

            return equation.substring(end + 1);
        }

        return equation;
    }

    public List<Integer> getOperands(String delimiter) {
        String[] operands = getRefinedEquation().split(delimiter);

        ArrayList<Integer> numbers = new ArrayList<>();
        for (String operand : operands) {
            numbers.add(convertToInt(operand));
        }

        return numbers;
    }

    private boolean checkCustomDelimiter() {
        return equation.contains(START_CUSTOM_DELIMITER)
                && equation.contains(END_CUSTOM_DELIMITER);
    }

    private int convertToInt(String operand) {
        int converted = Integer.parseInt(operand);

        checkValidInput(converted);

        return converted;
    }

    private void checkValidInput(int input) {
        if (input < 0) {
            throw new RuntimeException();
        }
    }
}