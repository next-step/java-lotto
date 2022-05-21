package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class OperatorTest {


    @Test
    void 더하기_테스트() {
        assertThat(Operator.execute("+", 1, 3)).isEqualTo(4);
        assertThat(Operator.execute("+", 2, 3)).isEqualTo(5);
        assertThat(Operator.execute("+", 3, 4)).isEqualTo(7);
        assertThat(Operator.execute("+", 4, 4)).isEqualTo(8);
    }

    @Test
    void 빼기_테스트() {
        assertThat(Operator.execute("-", 1, 3)).isEqualTo(-2);
        assertThat(Operator.execute("-", 2, 3)).isEqualTo(-1);
        assertThat(Operator.execute("-", 3, 4)).isEqualTo(-1);
        assertThat(Operator.execute("-", 4, 4)).isEqualTo(0);
    }

    @Test
    void 곱셉_테스트() {
        assertThat(Operator.execute("*", 1, 3)).isEqualTo(3);
        assertThat(Operator.execute("*", 2, 3)).isEqualTo(6);
        assertThat(Operator.execute("*", 3, 4)).isEqualTo(12);
        assertThat(Operator.execute("*", 4, 4)).isEqualTo(16);
    }

    @Test
    void 나눗셈_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.execute("/", 1, 3));

        assertThat(Operator.execute("/", 4, 4)).isEqualTo(1);
    }
}