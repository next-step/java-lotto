package lotto.step1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operation {
    ADD(Integer::sum),
    SUBTRACT((result, operand) -> result - operand),
    MULTIPLY((result, operand) -> result * operand),
    DIVIDE(new DivideStrategy());
    
    private static final Map<Character, Operation> operationMapper = new HashMap<>();
    
    private final BiFunction<Integer, Integer, Integer> operation;
    
    static {
        operationMapper.put('+', ADD);
        operationMapper.put('-', SUBTRACT);
        operationMapper.put('*', MULTIPLY);
        operationMapper.put('/', DIVIDE);
    }
    
    Operation(BiFunction<Integer, Integer, Integer> operation) {
        this.operation = operation;
    }
    
    public static Operation mappingOperation(Character operator) {
        return operationMapper.get(operator);
    }
    
    public int calculate(Integer calculateResult, Integer secondOperand) {
        return operation.apply(calculateResult, secondOperand);
    }
}
