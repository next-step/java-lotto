package calculator.domain;

import calculator.domain.InputValue;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-04
 */
public class InputValueTest {

    @Test
    void create() {
        InputValue number = new InputValue("1");
        InputValue operator = new InputValue("+");

        assertThat(number).isEqualTo(new InputValue("1"));
        assertThat(operator).isEqualTo(new InputValue("+"));
    }

    @Test
    void isOperate() {
        InputValue operator = new InputValue("+");
        assertThat(operator.isOperator()).isTrue();
    }
}
