package calculator.domain;

/**
 * Created by seungwoo.song on 2022-09-27
 */
public class OpercatorValue implements CalculateInfo {

    private final Operator operator;

    public OpercatorValue(Operator operator) {
        this.operator = operator;
    }

    @Override
    public void calculate(CalculateResult calculateResult) {
        calculateResult.addOperate(operator);
    }
}
