package me.devyonghee.calculator;

final class MinusCalculator implements Calculator {

    private final Calculator calculator;
    private final Number number;

    private MinusCalculator(Calculator calculator, Number number) {
        Assert.notNull(calculator, "'calculation' must not be null");
        Assert.notNull(number, "'number' to minus must not be null");
        this.calculator = calculator;
        this.number = number;
    }

    static MinusCalculator of(Calculator calculator, Number number) {
        return new MinusCalculator(calculator, number);
    }

    @Override
    public Number calculate() {
        return calculator.calculate()
                .minus(number);
    }
}
