package calculator.domain;

import java.util.function.BiConsumer;

/**
 * Created by seungwoo.song on 2022-10-05
 */
public enum InputType {

    NUMBER((calculator, input) -> calculator.calculate(input.toNumber())),
    OPERATOR((calculator, input) -> calculator.set(input.toOperator()));;

    private final BiConsumer<Calculator, Input> operator;

    InputType(BiConsumer<Calculator, Input> operator) {
        this.operator = operator;
    }

    public static InputType from(Input input) {
        if (input.isOperator()) {
            return OPERATOR;
        }

        return NUMBER;
    }

    public void CalculatorOperate(Calculator calculator, Input input) {
        operator.accept(calculator, input);
    }
}
