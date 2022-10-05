package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-05
 */
class InputTest {

    @Test
    void create() {
        Input input = new Input("+");
        assertThat(input).isEqualTo(new Input("+"));
    }

    @Test
    void 연산자판단() {
        assertThat(new Input("+").isOperator()).isTrue();
        assertThat(new Input("1").isOperator()).isFalse();
    }

    @Test
    void 연산자변환() {
        assertThat(new Input("+").toOperator()).isEqualTo(Operator.PLUS);
    }

    @Test
    void 숫자변환() {
        assertThat(new Input("1").toNumber()).isEqualTo(1);
    }
}