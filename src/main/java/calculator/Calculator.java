package calculator;

import calculator.number.Number;
import calculator.operator.Operation;
import calculator.parse.Parser;
import calculator.token.Tokens;

public class Calculator {
    public static final int calculate(String text) {
        Tokens tokens = Parser.parse(text);

        while (!tokens.last()) {
            Number first = tokens.number();
            Operation operation = tokens.operation();
            Number second = tokens.number();

            int result = operation.calculate(first.value(), second.value());

            tokens.add(result);
        }
        return tokens.number().value();
    }
}
