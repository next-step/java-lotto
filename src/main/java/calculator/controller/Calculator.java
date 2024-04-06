package calculator.controller;

import calculator.domain.Calculate;
import calculator.domain.Operator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    static final int OPERAND = 0;
    static final int OPERATOR = 1;
    static final InputView INPUT_VIEW = new InputView();
    static final OutputView OUTPUT_VIEW = new OutputView();

    public static void calculator() {
        String expression = INPUT_VIEW.expression();
        int result = Calculate.calculate(expression);
        OUTPUT_VIEW.printOutput(result);
    }

    public static List<Integer> operands(List<List<String>> operandsAndOperators) {
        List<String> stringOperands = operandsAndOperators.get(OPERAND);
        List<Integer> operands = new ArrayList<>();
        try {
            for (String stringOperand : stringOperands) {
                operands.add(Integer.parseInt(stringOperand));
            }
        }
        catch (Exception exception) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다. (피연산자는 숫자여야 합니다.)");
        }
        return operands;
    }

    public static List<Operator> operators(List<List<String>> operandsAndOperators) {
        List<String> StringOperators = operandsAndOperators.get(OPERATOR);
        List<Operator> operators = new ArrayList<>();
        try {
            stringOperatorToOperator(StringOperators, operators);
        }
        catch (Exception exception) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다. (연산자는 +, -, *, / 중 하나여야 합니다.)");
        }
        return operators;
    }

    public static void stringOperatorToOperator(List<String> StringOperators, List<Operator> operators) {
        for (String stringOperator : StringOperators) {
            operators.add(Operator.find(stringOperator));
        }
    }

    public static List<List<String>> operandsAndOperators(String expression) {
        List<String> operands = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        List<List<String>> operandsAndOperators = new ArrayList<>();
        operandsAndOperators.add(operands);
        operandsAndOperators.add(operators);

        String[] splitExpression;
        try {
            splitExpression = expression.split(" ");
        }
        catch (NullPointerException exception) {
            throw new IllegalArgumentException("입력이 잘못되었습니다. (입력값은 null일 수 없습니다.)");
        }

        for (int i = 0; i < splitExpression.length ; i++ ) {
            int operandOrOperator = ( i%2 == 0 )? OPERAND : OPERATOR;
            operandsAndOperators.get(operandOrOperator).add(splitExpression[i]);
        }
        if (operands.size() != (operators.size() + 1)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다. (operand 개수는 operator 개수보다 하나 더 많아야 합니다.)");
        }
        return operandsAndOperators;
    }
}
