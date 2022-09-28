package step1.domain;

public class MultipleCalculator implements CalculatorPolicy{

    private final Number number;

    public MultipleCalculator(Number number) {
        this.number = number;
    }

    @Override
    public Number calculate(Number number) {
        return this.number.multiple(number);
    }
}
