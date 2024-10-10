package calculator.strategy;

import calculator.domain.Strings;
import calculator.enumeration.OperationSymbol;

public class InputOrder implements CalculationOrderStrategy {
    @Override
    public int calculate(final Strings strings) {
        int left = Integer.parseInt(strings.getFirst());
        for (int i = 1; i < strings.length() - 1; i += 2) {
            final int right = Integer.parseInt(strings.getNext(i));
            left = OperationSymbol.from(strings.get(i)).calculate(left, right);
        }
        return left;
    }
}
