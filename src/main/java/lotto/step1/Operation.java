package lotto.step1;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    ADD('+', Integer::sum),
    SUBTRACT('-', (result, operand) -> result - operand),
    MULTIPLY('*', (result, operand) -> result * operand),
    DIVIDE('/', Operation::divide);
    
    private static final String DIVIDE_NUMBERS_EXCEPTION_MESSAGE = "나눗셈은 정확히 나누어 떨어지는 경우에만 진행할 수 있습니다. 다시 입력해주세요.";
    private static final String ARITHMETIC_EXCEPTION_MESSAGE = "나눗셈의 분모가 0일 수 없습니다. 다시 입력해주세요.";
    
    private final BiFunction<Integer, Integer, Integer> operation;
    private final char operator;
    
    Operation(char operator, BiFunction<Integer, Integer, Integer> operation) {
        this.operator = operator;
        this.operation = operation;
    }
    
    public static Operation from(Character operator) {
        return Arrays.stream(values())
                .filter(operation -> operation.operator == operator)
                .findAny()
                .orElseThrow();
    }
    
    public int calculate(Integer calculateResult, Integer secondOperand) {
        return operation.apply(calculateResult, secondOperand);
    }
    
    private static Integer divide(Integer firstOperand, Integer secondOperand) {
        if (secondOperand == 0) {
            throw new IllegalArgumentException(ARITHMETIC_EXCEPTION_MESSAGE);
        }
        
        if (firstOperand % secondOperand != 0) {
            throw new IllegalArgumentException(DIVIDE_NUMBERS_EXCEPTION_MESSAGE);
        }
        
        return firstOperand / secondOperand;
    }
}
