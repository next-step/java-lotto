package calculator.controller;

import calculator.domain.Operator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {
    public static void main(String[] args) {
        String inputFormula = InputView.inputFormula();
        List<Integer> operands = InputView.parseOperands(inputFormula);
        List<String> operators = InputView.parseOperators(inputFormula);

        int totalSum = Operator.calculate(operands, operators);
        OutputView.printResult(totalSum);
    }
}
