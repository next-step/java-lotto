package lotto.util;

import lotto.domain.*;

public class OperationStrategyFactory {

    public static OperationStrategy getStrategy(String operator) {

        if ("+".equals(operator)) {
            return new AddStrategy();
        }

        if ("-".equals(operator)) {
            return new SubtractStrategy();
        }

        if ("*".equals(operator)) {
            return new MultiplyStrategy();
        }

        return new DivideStrategy();

    }

}
