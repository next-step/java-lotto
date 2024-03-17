package calculator;

public class Service {

    private Calculator calculator = new Calculator();

    public int start(String input) {
        String[] inputs = input.split(" ");
        int result = calculator.validate(inputs[0]);
        for (int i = 1; i < inputs.length; i += 2) {
            int nextInput = calculator.validate(inputs[i + 1]);
            result = calculator(inputs[i], result, nextInput);
        }
        return result;
    }

    private int calculator(String operator, int input1, int input2) {
        if (operator.equals("+")) {
            return calculator.add(input1, input2);
        }
        if (operator.equals("-")) {
            return calculator.minus(input1, input2);
        }
        if (operator.equals("*")) {
            return calculator.multiply(input1, input2);
        }
        if (operator.equals("/")) {
            return calculator.divide(input1, input2);
        }
        throw new IllegalArgumentException("잘못된 기호입니다.");
    }
}
