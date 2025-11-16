package calculator;

public class Calculator {

    public static int calculate(String expression) {
        Tokens tokens = new Tokens(expression);
        return tokens.calculate();
    }
}
