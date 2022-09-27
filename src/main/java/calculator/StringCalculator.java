package calculator;

import calculator.type.Operator;

import java.util.Queue;

public class StringCalculator {

    public int calculate(String input) {
        InputTokenizer tokenizer = new InputTokenizer(input);

        Queue<Integer> numbers = tokenizer.numbers();
        Queue<Operator> operators = tokenizer.operators();

        return operate(numbers, operators);
    }

    private int operate(Queue<Integer> numbers, Queue<Operator> operators) {
        int result = numbers.remove();

        while (hasMoreTokens(numbers)) {
            Operator operator = operators.remove();
            result = operator.operate(result, numbers.remove());
        }

        return result;
    }

    private boolean hasMoreTokens(Queue<Integer> numbers) {
        return !numbers.isEmpty();
    }
}
