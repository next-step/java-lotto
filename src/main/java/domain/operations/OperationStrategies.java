package domain.operations;

import java.util.List;

public class OperationStrategies {
    private final static List<CalculateStrategy> strategies = List.of(new Add(), new Minus(), new Division(), new Multiplication());

    public static CalculateStrategy getOperation(String operation) {
        return strategies.stream()
                .filter(calculateStrategy -> calculateStrategy.match(operation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산문자가 잘못 입력 됐습니다. "));
    }
}
