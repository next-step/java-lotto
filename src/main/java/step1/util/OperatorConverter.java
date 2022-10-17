package step1.util;

import java.util.ArrayList;
import java.util.List;
import step1.domain.AdditionOperator;
import step1.domain.DivisionOperator;
import step1.domain.MultiplicationOperator;
import step1.domain.Operator;
import step1.domain.SubtractionOperator;

public class OperatorConverter {

    private static final List<Operator> OPERATORS = new ArrayList<>();

    private OperatorConverter() {

    }

    static {
        OPERATORS.add(new AdditionOperator());
        OPERATORS.add(new SubtractionOperator());
        OPERATORS.add(new MultiplicationOperator());
        OPERATORS.add(new DivisionOperator());
    }

    public static Operator convert(String rawOperator) {
        return OPERATORS.stream()
                .filter(operator -> operator.supports(rawOperator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
