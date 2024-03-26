package calculator.domain;

public class Calculator {
    private static final String NUMBER_REGEX = "\\d+";

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";

    private static final int FIRST_NUM_INDEX = 1;
    private static final int OPERAND_INDEX = 2;

    public static int calculate(String input) {
        String[] inputs = input.split(" ");
        int result = isNumber(inputs[0]);

        for(int i=FIRST_NUM_INDEX; i<inputs.length; i+=OPERAND_INDEX) {
            result = operate(inputs[i], result, isNumber(inputs[i+1]));
        }
        return result;
    }

    public static int operate(String operater, int num1, int num2) {
        return CalculateOperater.fromSymbol(operater).apply(num1, num2);
    }

    private static int isNumber(String input) {
        if(!input.matches(NUMBER_REGEX)){
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(input);
    }

}
