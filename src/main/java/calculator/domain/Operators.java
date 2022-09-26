package calculator.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Operators {

    private static final int INDEX_NEXT_OPERATOR = 2;

    private final List<Operator> operators;

    public Operators(final List<String> operators) {

        this.operators = convert(operators);
    }

    public List<Operator> convert(final List<String> input) {

        return input.stream()
                .filter(this::match)
                .map(Operator::new)
                .collect(Collectors.toList());
    }

    private boolean match(final String str) {

        return Operation.match(str);
    }

    public String finalOperate(final Expressions expressions) {

        int index = 1;
        for (Operator operator : operators) {
            final int value = operate(operator.getOperator(), expressions.before(index), expressions.after(index));
            expressions.saveAfter(index, value);
            index += INDEX_NEXT_OPERATOR;
        }
        return expressions.findLast();
    }

    private int operate(final String operation, final String target1, final String target2) {

        final int number1 = convertInt(target1);
        final int number2 = convertInt(target2);
        return Operation.from(operation).calculate(number1, number2);
    }

    private int convertInt(final String str) {

        return Integer.parseInt(str);
    }
}
