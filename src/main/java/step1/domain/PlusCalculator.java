package step1.domain;

public class PlusCalculator implements CalculatorPolicy {

    private final Number number;

    public PlusCalculator(Number number) {
        this.number = number;
    }

    @Override
    public Number calculate(Number number) {
        return this.number.plus(number);
    }
}
