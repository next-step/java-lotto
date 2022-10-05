package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-05
 */
class InputTypeTest {

    @Test
    void 숫자연산() {
        Calculator calculator = new Calculator();
        InputType.NUMBER.CalculatorOperate(calculator, new Input("3"));

        assertThat(calculator.getResult()).isEqualTo(3);
    }

    @Test
    void 연산자() {
        Calculator calculator = new Calculator();
        InputType.OPERATOR.CalculatorOperate(calculator, new Input("+"));
        InputType.NUMBER.CalculatorOperate(calculator, new Input("4"));

        assertThat(calculator.getResult()).isEqualTo(4);
    }
}