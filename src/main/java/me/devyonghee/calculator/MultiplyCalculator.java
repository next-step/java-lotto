package me.devyonghee.calculator;

final class MultiplyCalculator implements Calculator {

    private final Calculator calculator;
    private final Number number;

    private MultiplyCalculator(Calculator calculator, Number number) {
        Assert.notNull(calculator, "'calculator' must not be null");
        Assert.notNull(number, "'number' to multiply must not be null");
        this.calculator = calculator;
        this.number = number;
    }

    static MultiplyCalculator of(Calculator calculator, Number number) {
        return new MultiplyCalculator(calculator, number);
    }

    @Override
    public Number calculate() {
        return calculator.calculate()
                .multiply(number);
    }

    @Override
    public String toString() {
        return "MultiplyCalculator{" +
                "calculator=" + calculator +
                ", number=" + number +
                '}';
    }
}
