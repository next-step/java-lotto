package step1.domain;

public class DivideCalculator implements CalculatorPolicy{

    private final Number number;

    public DivideCalculator(Number number) {
        this.number = number;
    }

    @Override
    public Number calculate(Number number) {
        validation(number);
        return this.number.divide(number);
    }

    private void validation(Number number) {
        if (number.value() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}
