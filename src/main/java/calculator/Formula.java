package calculator;

import java.util.Arrays;

public class Formula {
    private final String[] elements;
    private Calculator calculator;
    private int result;

    public Formula(String formula) {
        validate(formula);
        this.elements = formula.split(" ");
        this.calculator = new AddCalculator();
    }

    public Formula(String[] elements) {
        this.elements = elements;
        this.calculator = new AddCalculator();
    }

    private void validate(String formula) {
        if(formula == null){
            throw new IllegalArgumentException("null 사용 금지");
        }
        if(formula.isBlank()){
            throw new IllegalArgumentException("빈 문자열 사용 금지");
        }
    }

    public int calculate() {
        for (String element : elements) {
            calculate(element);
        }
        return result;
    }

    private void calculate(String element) {
        if (isNumber(element)) {
            result = calculator.calculate(result, Integer.parseInt(element));
        }
        calculator = CalculatorFactory.getCalculator(element);
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
