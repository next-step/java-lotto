package calculator.strategy;

import calculator.domain.Operand;
import calculator.domain.Operator;
import calculator.domain.Strings;

public class InputOrder implements CalculationOrderStrategy {
    @Override
    public Operand calculate(final Strings strings) {
        Operand left = new Operand(strings.getFirst());
        for (int i = 1; i < strings.length() - 1; i += 2) {
            final Operator operator = new Operator(strings.get(i));
            final Operand right = new Operand(strings.getNext(i));
            left = operator.calculate(left, right);
        }
        return left;
    }
}
