package calculator.domain;

import static calculator.domain.OperatorsConstant.DIVIDE;
import static calculator.domain.OperatorsConstant.MINUS;
import static calculator.domain.OperatorsConstant.MULTIPLY;
import static calculator.domain.OperatorsConstant.PLUS;

import java.util.HashMap;
import java.util.Map;

public class NumberCalculatorFactory {

    private final Map<String, TwoNumbersCalculator> calculators = new HashMap<>();

    public NumberCalculatorFactory() {
        this.calculators.put(PLUS.getSymbol(), new AddTwoNumbers());
        this.calculators.put(MINUS.getSymbol(), new MinusTwoNumbers());
        this.calculators.put(MULTIPLY.getSymbol(), new MultiplyTwoNumbers());
        this.calculators.put(DIVIDE.getSymbol(), new DivideTwoNumbers());
    }

    public TwoNumbersCalculator getHandlerBySymbol(String symbol) {
        return calculators.get(symbol);
    }
}
