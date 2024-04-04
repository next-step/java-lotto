package calculator.controller;

import calculator.domain.Calculate;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class Calculator {
    static final int OPERAND = 0;
    static final int OPERATOR = 1;
    static final InputView inputView = new InputView();
    static final OutputView outputView = new OutputView();

    public void calculator() {
        List<List<String>> operandAndOperator = inputView.operandAndOperator();
        List<String> operands = operandAndOperator.get(OPERAND);
        List<String> operators = operandAndOperator.get(OPERATOR);

        int result = Calculate.calculate(operands, operators);

        outputView.printOutput(result);
    }
}
