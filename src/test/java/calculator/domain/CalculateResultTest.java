package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by seungwoo.song on 2022-10-04
 */
class CalculateResultTest {

    @Test
    void create() {
        CalculateResult calculateResult = new CalculateResult(5);

        assertThat(calculateResult).isEqualTo(new CalculateResult(5));
    }

    @Test
    void 더하기() {
        assertThat(new CalculateResult(5).plus(new InputValue("5"))).isEqualTo(new CalculateResult(10));
    }

    @Test
    void 빼기() {
        assertThat(new CalculateResult(5).minus(new InputValue("5"))).isEqualTo(new CalculateResult(0));
    }

    @Test
    void 곱하기() {
        assertThat(new CalculateResult(5).multiple(new InputValue("5"))).isEqualTo(new CalculateResult(25));
    }

    @Test
    void 나누기() {
        assertThat(new CalculateResult(2).divide(new InputValue("2"))).isEqualTo(new CalculateResult(1));
        assertThat(new CalculateResult(0).divide(new InputValue("2"))).isEqualTo(new CalculateResult(0));
    }

    @Test
    void 나누기_예외() {
        assertThatThrownBy(() -> new CalculateResult(3).divide(new InputValue("2")))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new CalculateResult(2).divide(new InputValue("0")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}