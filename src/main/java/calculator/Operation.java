package calculator;

import java.util.Arrays;
import java.util.Map;
import java.util.function.ToIntBiFunction;

import static java.util.stream.Collectors.toUnmodifiableMap;

public enum Operation {
    ADD(Operator.ADD, Integer::sum);

    private static final Map<Operator, Operation> VALUE_MAP
            = Arrays.stream(Operation.values())
            .collect(toUnmodifiableMap(Operation::getOperator, e -> e));

    private final Operator operator;
    private final ToIntBiFunction<Integer, Integer> calculate;


    Operation(Operator operator, ToIntBiFunction<Integer, Integer> calculate) {
        this.operator = operator;
        this.calculate = calculate;
    }

    public static Operation findType(Operator operator) {
        return VALUE_MAP.get(operator);
    }

    private Operator getOperator() {
        return operator;
    }

    public int calculate(int a, int b) {
        return calculate.applyAsInt(a, b);
    }

}