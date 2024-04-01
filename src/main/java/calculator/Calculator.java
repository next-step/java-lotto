package calculator;

import inputview.InputView;
import outputview.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    InputView inputView;
    OutputView outputView;
    static final int operand = 0;
    static final int operator = 1;

    public Calculator() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public CalculationMethod checkOperator(String operator) {
        CalculationMethod calculationMethod2 = CalculationMethod.find(operator);
        return calculationMethod2;
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
        operands = operandAndOperator.get(operand);
        operators = operatorsStringToCalculationMethod(operandAndOperator.get(operator));

        int result = operators.get(0).calculate(operands.get(0), operands.get(1));
        for (int i = 1; i < (operators.size()); i++) {
            result = operators.get(i).calculate(String.valueOf(result), operands.get(i + 1));
        }

        outputView.printOutput(result);

        return result;
    }

    // 테스트용
    public int calculate(String userInput) {
        List<List<String>> operandAndOperator;
        List<String> operands;
        List<CalculationMethod> operators;

        operandAndOperator = inputView.operandAndOperator(userInput);
        operands = operandAndOperator.get(operand);
        operators = operatorsStringToCalculationMethod(operandAndOperator.get(operator));

        int result = operators.get(0).calculate(operands.get(0), operands.get(1) );
        for (int i = 1; i < (operators.size()); i++) {
            result = operators.get(i).calculate( String.valueOf(result), operands.get(i + 1) );
        }

        outputView.printOutput(result);

        return result;
    }
}
