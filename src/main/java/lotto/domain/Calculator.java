package lotto.domain;

public class Calculator {
    private static final String NUMBER_REGEX = "\\d+";

    private final static String PLUS = "+";
    private final static String MINUS = "-";
    private final static String MULTIPLICATION = "*";
    private final static String DIVISION = "/";

    public static int calculate(String input) {
        String[] inputs = input.split(" ");
        int result = isNumber(inputs[0]);

        for(int i=1; i<inputs.length; i+=2) {
            result = operate(inputs[i], result, isNumber(inputs[i+1]));
        }
        return result;
    }

    public static int operate(String operater, int num1, int num2) {
        if(operater.equals(PLUS)) {
            return add(num1,num2);
        }
        if(operater.equals(MINUS)) {
            return minus(num1,num2);
        }
        if(operater.equals(MULTIPLICATION)) {
            return multiply(num1,num2);
        }
        if(operater.equals(DIVISION)) {
            return divide(num1,num2);
        }
        throw new IllegalArgumentException("사칙연산만 (+, -, *, /)가능합니다.");
    }

    private static int add(int input1, int input2) {
        return input1 + input2;
    }

    private static int minus(int input1, int input2) {
        return input1 - input2;
    }

    private static int multiply(int input1, int input2) {
        return input1 * input2;
    }

    private static int divide(int input1, int input2) {
        return input1 / input2;
    }

    private static int isNumber(String input) {
        if(!input.matches(NUMBER_REGEX)){
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(input);
    }

}
