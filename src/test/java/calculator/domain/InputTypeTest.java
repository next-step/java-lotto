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
        InputType.NUMBER.operate(calculator, new Input("3"));

        assertThat(calculator.getResult()).isEqualTo(3);
    }

    @Test
    void 연산자() {
        Calculator calculator = new Calculator();
        InputType.OPERATOR.operate(calculator, new Input("+"));
        InputType.NUMBER.operate(calculator, new Input("4"));

        assertThat(calculator.getResult()).isEqualTo(4);
    }

    @Test
    void create() {
        assertThat(InputType.from(new Input("*"))).isEqualTo(InputType.OPERATOR);
        assertThat(InputType.from(new Input("1"))).isEqualTo(InputType.NUMBER);
    }
}