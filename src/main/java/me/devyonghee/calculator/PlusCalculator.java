package me.devyonghee.calculator;

final class PlusCalculator implements Calculator {

    private final Calculator calculator;
    private final Number number;

    private PlusCalculator(Calculator calculator, Number number) {
        Assert.notNull(calculator, "'calculator' must not be null");
        Assert.notNull(number, "'number' to plus must not be null");
        this.calculator = calculator;
        this.number = number;
    }

    static PlusCalculator of(Calculator calculator, Number number) {
        return new PlusCalculator(calculator, number);
    }

    @Override
    public Number calculate() {
        return calculator.calculate()
                .plus(number);
    }

    @Override
    public String toString() {
        return "PlusCalculator{" +
                "calculator=" + calculator +
                ", number=" + number +
                '}';
    }
}
