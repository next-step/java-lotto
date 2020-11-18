package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class MathExpression {

    private List<Integer> operands;

    /**
     * @param mathExpression custom delimiter 가 포함되지 않은 수식 문자열
     */
    public MathExpression(String mathExpression, String delimiter) {
         List<Integer> operands = Arrays.stream(mathExpression.split(delimiter))
                 .map(Integer::valueOf)
                 .collect(Collectors.toList());
         this.operands = validateAndGet(operands);
    }

    private List<Integer> validateAndGet(List<Integer> operands) {
        if(operands.stream().anyMatch(this::lessThanZero))
            throw new RuntimeException("수식에는 0 또는 양수만 입력 가능합니다.");
        return operands;
    }

    private boolean lessThanZero(Integer value) {
        return value < 0;
    }

    public int execute(BinaryOperator<Integer> operator) {
        return operands.stream().reduce(0, operator);
    }
}
