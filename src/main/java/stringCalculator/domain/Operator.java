package stringCalculator.domain;

import stringCalculator.strategy.*;

public class Operator {

    private CalculatorStrategy calculatorStrategy;

    public Operator(String operator) {
        isEmpty(operator);
        create(operator);
    }

    private void create(String operator) {
        OperatorMap operatorMap = new OperatorMap();

        this.calculatorStrategy = operatorMap.getStrategy(operator);
    }

    public int calculate(int prevOperand, int nextOperand) {
        return this.calculatorStrategy.applyAsInt(prevOperand, nextOperand);
    }

    private void isEmpty(String inputText) {
        if(inputText == null || inputText.isEmpty()) {
            throw new IllegalArgumentException("문자열이 올바르지 않습니다.");
        }
    }
}
