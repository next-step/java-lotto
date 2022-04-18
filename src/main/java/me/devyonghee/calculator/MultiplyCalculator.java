package me.devyonghee.calculator;

public class MultiplyCalculator implements Calculator {

    private final Calculator calculator;
    private final Number number;

    private MultiplyCalculator(Calculator calculator, Number number) {
        Assert.notNull(calculator, "'calculation' must not be null");
        Assert.notNull(number, "'number' to multiply must not be null");
        this.calculator = calculator;
        this.number = number;
    }

    public static MultiplyCalculator of(Calculator calculator, Number number) {
        return new MultiplyCalculator(calculator, number);
    }

    @Override
    public Number calculate() {
        return calculator.calculate()
                .multiply(number);
    }
}
