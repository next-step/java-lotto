package step1;

import java.util.Iterator;

import step1.domain.Number;
import step1.domain.Operator;

public class StringCalculator {
    private final String expression;

    public StringCalculator(String expression) {
        this.expression = expression;
    }

    public Number calculate() {
        ParserResult parserResult = InputParser.parseExpression(expression);

        Iterator<Number> numberIterator = parserResult.getNumbers().iterator();
        Iterator<Operator> operatorIterator = parserResult.getOperators().iterator();
        Number result = numberIterator.next();

        while(operatorIterator.hasNext() && numberIterator.hasNext()) {
            result = operatorIterator.next().calculate(result, numberIterator.next());
        }

        return result;
    }
}
