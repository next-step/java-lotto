package domain;

import java.util.HashMap;
import java.util.Map;

public class CalculationFactory {

    private final Map<String, Calculation> calculator = new HashMap<>();

    public CalculationFactory() {
        calculator.put(Operator.PLUS.getSymbol(), new Addition());
        calculator.put(Operator.MINUS.getSymbol(), new Subtraction());
        calculator.put(Operator.DIVIDE.getSymbol(), new Division());
        calculator.put(Operator.MULTIPLE.getSymbol(), new Multiplication());
    }

    public Calculation getCalculatorByOperator(String operator) {
        return calculator.get(operator);
    }
}
