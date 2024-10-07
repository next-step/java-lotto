package calculator;

import calculator.domain.CalculateParameter;

public class StringCalculator {

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";
    public static final String SPACE = " ";
    private static StringCalculator INSTANCE = null;

    private StringCalculator() {
    }

    public static StringCalculator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StringCalculator();
        }
        return INSTANCE;
    }

    public String[] split(String text) {
        if (isBlank(text)) {
            throw new IllegalStateException("문자열이 비어있습니다.");
        }
        return text.split(SPACE);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }


    public int calculate(Integer first, Integer second, String operator) {
        if (first == null || second == null || operator == null) {
            throw new IllegalStateException("null을 허용하지 않습니다.");
        }
        if (PLUS.equals(operator)) {
            return first + second;
        }
        if (MINUS.equals(operator)) {
            return first - second;
        }
        if (MULTIPLY.equals(operator)) {
            return first * second;
        }
        if (DIVIDE.equals(operator)) {
            return first / second;
        }
        throw new IllegalStateException("연산자가 아닌 문자는 허용하지 않습니다.");
    }

    public int calculate(String text) {
        CalculateParameter parameter = makeParameter(text);
        parameter.isValidQueueSize();
        return getResult(parameter);
    }

    private int getResult(CalculateParameter parameter) {
        int result = firstCalculate(parameter);
        while (!parameter.isEmpty()) {
            result = calculate(result, parameter.getNumber(), parameter.getOperator());
        }
        return result;
    }

    private CalculateParameter makeParameter(String text) {
        CalculateParameter parameter = new CalculateParameter();

        String[] splitText = split(text);
        addSplitTexts(splitText, parameter);

        return parameter;
    }

    private int firstCalculate(CalculateParameter parameter) {
        return calculate(parameter.getNumber(), parameter.getNumber(), parameter.getOperator());
    }

    private void addSplitTexts(String[] splitText, CalculateParameter parameter) {
        for (int i = 0; i < splitText.length; i++) {
            addQueue(i, splitText, parameter);
        }
    }

    private void addQueue(int index, String[] splitText, CalculateParameter parameter) {
        if (isEven(index)) {
            parameter.addNumbers(splitText[index]);
        }
        if (isOdd(index)) {
            parameter.addOperators(splitText[index]);
        }
    }

    private static boolean isOdd(int i) {
        return i % 2 == 1;
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }
}
