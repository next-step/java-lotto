package calculator;

import calculator.converter.StringConverter;
import calculator.parser.ExpressionParser;

import java.util.List;

public class IntegerCalculator {
    private final ExpressionParser parser;
    private final StringConverter<Integer> stringToIntegerConverter;
    private final Operators operators;

    public IntegerCalculator(ExpressionParser parser,
                             StringConverter<Integer> stringToIntegerConverter,
                             Operators operators) {
        this.parser = parser;
        this.stringToIntegerConverter = stringToIntegerConverter;
        this.operators = operators;
    }

    public int calculate(String expressionString) {
        List<String> parts = parser.parse(expressionString);
        Integer init = stringToIntegerConverter.convert(parts.get(0));

        for(int idx = 0 ; idx < parts.size() ;idx++) {
            if(idx  % 2 != 0) {
                String operator = parts.get(idx);

                checkArithmeticOperator(operator);
                init = operators.operationOf(operator)
                        .operate(init, stringToIntegerConverter.convert(parts.get(idx + 1)));
            }
        }
        return init;
    }

    private void checkArithmeticOperator(String operator) {
        if(!operators.hasOperator(operator)) {
            throw new IllegalArgumentException("사칙 연산자가 아닙니다.");
        }
    }
}
