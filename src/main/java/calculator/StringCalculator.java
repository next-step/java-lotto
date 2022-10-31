package calculator;

public class StringCalculator {
    private final static char ADD_CHAR = '+';
    private final static char SUBTRACT_CHAR = '-';
    private final static char MULTIPLY_CHAR = '*';
    private final static char DIVIDE_CHAR = '/';

    private final String calculateString;

    public StringCalculator(String calculateString) {
        validateString(calculateString);
        this.calculateString = calculateString;

    }

    public void validateString(String calculateString) {
        if(calculateString == null || calculateString.isBlank()) {
            throw new IllegalArgumentException("문자열은 null이거나 공백이어서는 안됩니다.");
        }
    }

    public int calculate() {
        String[] splitString = calculateString.split(" ");
        int result = Integer.parseInt(splitString[0]);
        for(int i=1 ; i<splitString.length ; i+=2) {
            int operatingNumber = Integer.parseInt(splitString[i+1]);
            result = calculateByOperator(splitString[i], result, operatingNumber);
        }
        return result;
    }

    private int calculateByOperator(String operater, int num1, int num2) {
        if(operater.charAt(0) == ADD_CHAR) {
            return add(num1, num2);
        }
        if(operater.charAt(0) == SUBTRACT_CHAR) {
            return subtract(num1, num2);
        }
        if(operater.charAt(0) == MULTIPLY_CHAR) {
            return multiply(num1, num2);
        }
        if(operater.charAt(0) == DIVIDE_CHAR) {
            return divide(num1, num2);
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }

    private int add(int num1, int num2) {
        return num1 + num2;
    }

    private int subtract(int num1, int num2) {
        return num1 - num2;
    }

    private int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private int divide(int num1, int num2) {
        return num1 / num2;
    }

}

