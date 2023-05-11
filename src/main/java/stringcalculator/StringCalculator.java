package stringcalculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class StringCalculator implements Calculator<String> {

    @Override
    public int calculate(String mathematicalExpression) {
        String[] expression = StringUtils.split(mathematicalExpression);
        Queue<Integer> numbers = getNumbers(expression);
        Queue<String> operators = getOperators(expression);
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("수식에 숫자가 없습니다.");
        }
        int result = numbers.poll();
        while (!operators.isEmpty() && !numbers.isEmpty()) {
            result = Operator.getOperator(operators.poll()).apply(result, numbers.poll());
        }
        return result;
    }

    private LinkedList<String> getOperators(String[] expression) {
        return Arrays.stream(expression).filter(StringUtils::isOperator).collect(Collectors.toCollection(LinkedList::new));
    }

    private LinkedList<Integer> getNumbers(String[] expression) {
        return Arrays.stream(expression).filter(StringUtils::isNumber).map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
    }
}