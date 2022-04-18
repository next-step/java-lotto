package me.devyonghee.calculator;

final class DivideCalculator implements Calculator {

    private final Calculator calculator;
    private final Number number;

    private DivideCalculator(Calculator calculator, Number number) {
        Assert.notNull(calculator, "'calculation' must not be null");
        Assert.notNull(number, "'number' to divide must not be null");
        validateNumber(number);
        this.calculator = calculator;
        this.number = number;
    }

    static DivideCalculator of(Calculator calculator, Number number) {
        return new DivideCalculator(calculator, number);
    }

    @Override
    public Number calculate() {
        return calculator.calculate()
                .divide(number);
    }

    private void validateNumber(Number number) {
        if (Number.ZERO.equals(number)) {
            throw new IllegalArgumentException("number to divide cannot be zero");
        }
    }
}
