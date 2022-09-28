package step1.domain;

public class MinusCalculator implements CalculatorPolicy {

    private final Number number;

    public MinusCalculator(Number number) {
        this.number = number;
    }

    @Override
    public Number calculate(Number number) {
        return this.number.minus(number);
    }
}
