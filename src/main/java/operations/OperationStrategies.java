package operations;

import java.util.List;

public class OperationStrategies {
    private final static List<CalculateStrategy> strategies = List.of(new Add(), new Minus());

    public static CalculateStrategy getOperation(String[] strings, int i) {
        return strategies.stream()
                .filter(calculateStrategy -> calculateStrategy.match(strings[i]))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산문자가 잘못 입력 됐습니다. "));
    }
}
