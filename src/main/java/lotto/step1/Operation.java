package lotto.step1;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    ADD('+', Integer::sum),
    SUBTRACT('-', (result, operand) -> result - operand),
    MULTIPLY('*', (result, operand) -> result * operand),
    DIVIDE('/', new DivideStrategy());
    
    private final BiFunction<Integer, Integer, Integer> operation;
    private final char operator;
    
    Operation(char operator, BiFunction<Integer, Integer, Integer> operation) {
        this.operator = operator;
        this.operation = operation;
    }
    
    public static Operation mappingOperation(Character operator) {
        return Arrays.stream(values())
                .filter(operation -> operation.operator == operator)
                .findAny()
                .orElseThrow();
    }
    
    public int calculate(Integer calculateResult, Integer secondOperand) {
        return operation.apply(calculateResult, secondOperand);
    }
}
