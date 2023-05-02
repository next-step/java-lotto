package StringCalculator.domain;

import StringCalculator.constant.Operator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StringCalculator {

    public static final List<String> OPERATORS = List.of("+", "-", "*", "/");

    private final Numbers operands;
    private final Operators operators;

    public StringCalculator(List<String> expression) {
        this.operands = new Numbers(convertToNumbers(expression));
        this.operators = new Operators(convertToOperators(expression));
    }

    public Integer calculate() {
        while (operators.hasNext()) {
            Operator operator = operators.remove();
            Integer leftOperand = operands.remove();
            Integer rightOperand = operands.remove();

            operands.addFirst(operator.calculate(leftOperand, rightOperand));
        }

        return operands.remove();
    }

    private static Deque<Integer> convertToNumbers(List<String> expression) {
        Deque<Integer> operands = new ArrayDeque<>();
        for (String elem: expression) {
            if (isNumeric(elem)){
                operands.add(Integer.valueOf(elem));
            }
        }
        return operands;
    }

    private static Queue<Operator> convertToOperators(List<String> expression) {
        Queue<Operator> operators = new LinkedList<>();
        for (String elem: expression) {
            if (OPERATORS.contains(elem)) {
                operators.add(Operator.toOperator(elem));
            }
        }
        return operators;
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
