package me.devyonghee.calculator;

final class MinusCalculator implements Calculator {

    private final Calculator calculator;
    private final Number number;

    private MinusCalculator(Calculator calculator, Number number) {
        Assert.notNull(calculator, "'calculator' must not be null");
        Assert.notNull(number, "'number' to minus must not be null");
        this.calculator = calculator;
        this.number = number;
    }

    static MinusCalculator of(Calculator calculator, Number number) {
        return new MinusCalculator(calculator, number);
    }

    @Override
    public Number calculatedNumber() {
        return calculator.calculatedNumber()
                .minus(number);
    }

    @Override
    public String toString() {
        return "MinusCalculator{" +
                "calculator=" + calculator +
                ", number=" + number +
                '}';
    }
}
