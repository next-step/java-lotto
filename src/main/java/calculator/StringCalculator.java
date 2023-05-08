package calculator;

import java.util.*;

import static calculator.Operator.*;
import static calculator.TokenUtils.isInteger;
import static calculator.TokenUtils.isOperator;

public class StringCalculator {
    static Queue<Integer> numbers = new LinkedList<>();
    static Queue<Operator> operators = new LinkedList<>();

    public static int calculate(String input) {
        String[] tokens = Tokenizer.tokenize(input);
        makeQueueFromTokens(tokens);
        return proceedCalculate();
    }

    private static int proceedCalculate() {
        int result = numbers.poll();
        while (!operators.isEmpty()) {
            result = processOperator(result, operators.poll());
        }
        return result;
    }

    private static int processOperator(int result, Operator operator) {
        if (operator == PLUS) {
            result = PLUS.apply(result, numbers.poll());
        }
        if (operator == MINUS) {
            result = MINUS.apply(result, numbers.poll());
        }
        if (operator == MULTIPLY) {
            result = MULTIPLY.apply(result, numbers.poll());
        }
        if (operator == DIVIDE) {
            result = DIVIDE.apply(result, numbers.poll());
        }
        return result;
    }

    private static void makeQueueFromTokens(String[] tokens) {
        Arrays.stream(tokens).forEach(token -> seperateNumberAndOperator(token));
    }

    private static void seperateNumberAndOperator(String token) {
        if (isInteger(token)) {
            numbers.add(Integer.parseInt(token));
        }
        if (isOperator(token)) {
            operators.add(Operator.findOperatorByToken(token));
        }
    }
}
