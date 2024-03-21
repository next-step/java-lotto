package calculator.controller;

import calculator.model.Calculator;
import calculator.model.MathUtil;
import calculator.model.Validator;
import calculator.view.InputView;
import calculator.view.ResultView;

import java.util.List;

public class CalculatorManager {
    public void start() {
        // 입력
        // 5 -9*69 +8
        String inputExpression = InputView.inputMathExprssion();

        // 5-9*69+8
        String splitExpression = MathUtil.splitString(inputExpression);
        //String splitExpression = Validator.check(MathUtil.splitString(inputExpression));

        Calculator calculator = new Calculator();
        // 59698
        List<String> operands = calculator.splitOperands(splitExpression);
        // -*+
        List<String> operators = calculator.splitOperators(splitExpression);

        int calculationResult = calculator.operationFormula(operands,operators);

        // 결과
        ResultView.printExpressionResult(calculationResult);


    }
}
