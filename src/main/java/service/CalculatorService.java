package service;

import constants.Operator;

import java.util.List;

public class CalculatorService {

    public Integer calculate(String calculationFormula) {

        Preprocessor preprocessor = new Preprocessor();
        List<String> processedValue = preprocessor.process(calculationFormula);

        int calculatedValue =  calculateStart(processedValue);;

        return calculatedValue;
    }

    private int calculateStart(List<String> calculateTargets) {

        int result = Integer.parseInt(calculateTargets.get(0));

        for(int i = 1; i < calculateTargets.size(); i+=2) {
            int nextNumber = Integer.parseInt(calculateTargets.get(i + 1));
            result = chooseOperator(calculateTargets.get(i)).calculate(result, nextNumber);
        }

        return result;
    }

    private CalculatorImpl chooseOperator(String calculateTarget) {

        CalculatorImpl calculator = null;
        Operator operator = Operator.find(calculateTarget);

        switch (operator) {
            case PLUS:
                calculator = new Plus();
                break;
            case MINUS:
                calculator = new Minus();
                break;
            case MULTIPLICATION:
                calculator = new Multiplication();
                break;
            case DIVISION:
                calculator = new Division();
                break;
        }

        return calculator;
    }

}
