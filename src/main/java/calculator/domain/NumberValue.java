package calculator.domain;

/**
 * Created by seungwoo.song on 2022-09-27
 */
class NumberValue implements CalculateInfo {

    private final int value;
    public NumberValue(int value) {
        this.value = value;
    }

    @Override
    public void calculate(CalculateResult calculateResult) {
        calculateResult.calculate(value);
    }
}
