package calculator;

import inputview.InputView;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    InputView inputView;

    public Calculator() {
        inputView = new InputView();
    }

    public CalculationMethod checkOperator(String operator) {
        if (operator.equals("+"))
        {
            return new Sum();
        }
        if (operator.equals("-"))
        {
            return new Subtraction();
        }
        if (operator.equals("*"))
        {
            return new Multiplication();
        }
        if (operator.equals("/"))
        {
            return new Division();
        }
        throw new IllegalArgumentException("문자열 입력이 잘못되었습니다. 입력 가능한 연산자값은 +, -, *, /입니다.");
    }

    public List<CalculationMethod> operatorsStringToCalculationMethod(List<String> stringOperators) {
        List<CalculationMethod> calculationMethodOperators = new ArrayList<>();
        for (int i = 0; i < stringOperators.size(); i++) {
            calculationMethodOperators.add(checkOperator(stringOperators.get(i)));
        }
        return calculationMethodOperators;
    }

    public int calculate() {
        List<List<String>> operandAndOperator;
        List<String> operands;
        List<CalculationMethod> operators;

        operandAndOperator = inputView.operandAndOperator();
        operands = operandAndOperator.get(0);
        operators = operatorsStringToCalculationMethod(operandAndOperator.get(1));

        int result = operators.get(0).calculate(operands.get(0), operands.get(1));
        for (int i = 1; i < (operators.size()); i++) {
            result = operators.get(i).calculate(String.valueOf(result), operands.get(i + 1));
        }

        return result;
    }
}
