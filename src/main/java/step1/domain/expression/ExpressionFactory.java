package step1.domain.expression;

import step1.domain.num.Nums;
import step1.domain.operator.Operator;

import java.util.Map;

public class ExpressionFactory {
    private static final Map<String, Expression> immutableExpressionMap = Map.ofEntries(
            Map.entry("+", new Addition()),
            Map.entry("-", new Subtraction()),
            Map.entry("*", new Multiplication()),
            Map.entry("/", new Division())
    );

    public static Expression of(Operator operator) {
        return immutableExpressionMap.get(operator.getOperator());
    }

}
