package calculator.domain;

import calculator.view.InputView;
import calculator.view.OutputView;

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

    public int calculate() {
        List<List<String>> operandAndOperator;
        List<String> operands;
        List<String> operators;

        operandAndOperator = inputView.operandAndOperator();
        operands = operandAndOperator.get(operand);
        operators = operandAndOperator.get(operator);

        int result = CalculationMethod.calculate(operators.get(0), operands.get(0), operands.get(1));
        for (int i = 1; i < (operators.size()); i++) {
            result = CalculationMethod.calculate(operators.get(i), String.valueOf(result), operands.get(i + 1));
        }

        outputView.printOutput(result);

        return result;
    }
}
