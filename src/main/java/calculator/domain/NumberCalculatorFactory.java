package calculator.domain;

import java.util.HashMap;
import java.util.Map;

public class NumberCalculatorFactory {

    private final Map<String, TwoNumbersCalculator> calculators = new HashMap<>();

    public NumberCalculatorFactory() {
        /*this.calculators.put(PLUS.getSymbol(), new AddTwoNumbers());*/
    }
}
