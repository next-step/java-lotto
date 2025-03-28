package calculator.domain;

public class Calculator {

    public Number calculate(String input) {
        String[] tokens = input.split(" ");
        Number result = new Number(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            Operator operator = Operator.from(tokens[i]);
            Number right = new Number(tokens[i + 1]);
            result = operator.apply(result, right);
        }
        return result;
    }
}
