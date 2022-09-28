package step1.domain;

public class DivideCalculator implements CalculatorPolicy{

    private final Number number;

    public DivideCalculator(Number number) {
        this.number = number;
    }

    @Override
    public Number calculate(Number number) {
        return this.number.divide(number);
    }
}
