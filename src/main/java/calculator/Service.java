package calculator;

public class Service {

    private final static String ADDITION = "+";
    private final static String SUBTRACTION = "-";
    private final static String MULTIPLICATION = "*";
    private final static String DIVISION = "/";


    public int start(String input) {
        Calculator.validateInputNullOrEmpty(input);
        String[] inputs = input.split(" ");
        int result = Calculator.validateInputIsNumber(inputs[0]);
        for (int i = 1; i < inputs.length; i += 2) {
            int nextInput = Calculator.validateInputIsNumber(inputs[i + 1]);
            result = calculator(inputs[i], result, nextInput);
        }
        return result;
    }

    private int calculator(String operator, int input1, int input2) {
        if (operator.equals(ADDITION)) {
            return Calculator.add(input1, input2);
        }
        if (operator.equals(SUBTRACTION)) {
            return Calculator.minus(input1, input2);
        }
        if (operator.equals(MULTIPLICATION)) {
            return Calculator.multiply(input1, input2);
        }
        if (operator.equals(DIVISION)) {
            return Calculator.divide(input1, input2);
        }
        throw new IllegalArgumentException("잘못된 기호입니다.");
    }
}
