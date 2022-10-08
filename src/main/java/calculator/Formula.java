package calculator;

import java.util.Arrays;

public class Formula {
    private final String[] elements;
    private Calculator calculator;

    public Formula(String formula) {
        this.elements = formula.split(" ");
        this.calculator = new AddCalculator();
    }

    public Formula(String[] elements) {
        this.elements = elements;
        this.calculator = new AddCalculator();
    }

    public int calculate() {
        int result = 0;
        for (String element : elements) {
            if (isNumber(element)) {
                result = calculate(result, element);
            } else {
                calculator = CalculatorFactory.getCalculator(element);
            }
        }
        return result;
    }

    private int calculate(int result, String element) {
        return calculator.calculate(result, Integer.parseInt(element));
    }

    private boolean isNumber(final String element) {
        try {
            Integer.parseInt(element);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formula formula = (Formula) o;
        return Arrays.equals(elements, formula.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }
}
