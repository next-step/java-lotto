package step1;

import java.util.HashMap;
import java.util.Map;

public class OperationMapper {

    private final Map<String, OperationStrategy> strategyMap;

    public OperationMapper() {
        this.strategyMap = new HashMap<>();
        for (Operator operator : Operator.values()) {
            strategyMap.put(operator.getValue(), operator.getOperationStrategy());
        }
    }

    public boolean isOperator(String input) {
        return this.strategyMap.containsKey(input);
    }

    public OperationStrategy getOperationStrategy(String input) {
        if (!isOperator(input)) {
            throw new IllegalArgumentException("사칙연산 부호가 아닙니다.");
        }
        return this.strategyMap.get(input);
    }
}
