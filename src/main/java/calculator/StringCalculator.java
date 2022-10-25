package calculator;

import calculator.operator.Operator;
import calculator.operator.OperatorFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int calculate(final String input) {
        List<String> inputList = Arrays.stream(input.split("\\s"))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        Queue<Integer> operands = extractedOperands(inputList);
        Queue<Operator> operators = extractedOperators(inputList);

        return calculateResult(operands, operators);
    }

    private static int calculateResult(final Queue<Integer> operands, final Queue<Operator> operators) {
        if (operands.isEmpty()) {
            return 0;
        }

        int result = operands.poll();
        while (!operators.isEmpty()) {
            Operator operator = operators.poll();
            int operand = operands.poll();

            result = operator.operate(result, operand);
        }

        return result;
    }

    private static Queue<Integer> extractedOperands(final List<String> inputList) {
        Queue<Integer> operands = new LinkedList<>();
        for (int i = 0; i < inputList.size(); i = i + 2) {
            operands.add(Integer.parseInt(inputList.get(i)));
        }

        return operands;
    }

    private static Queue<Operator> extractedOperators(final List<String> inputList) {
        Queue<Operator> operators = new LinkedList<>();
        for (int i = 1; i < inputList.size(); i = i + 2) {
            operators.add(OperatorFactory.getOperator(inputList.get(i)));
        }

        return operators;
    }
}
