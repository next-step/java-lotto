package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {
    @Test
    @DisplayName("덧셈 기능")
    void plus_test() {
        Operator operator = Operator.from("+");
        Assertions.assertThat(operator.apply(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 기능")
    void minus_test() {
        Operator operator = Operator.from("-");
        Assertions.assertThat(operator.apply(1, 2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈 기능")
    void multiply_test() {
        Operator operator = Operator.from("*");
        Assertions.assertThat(operator.apply(1, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 기능")
    void divide_test() {
        Operator operator = Operator.from("/");
        Assertions.assertThat(operator.apply(1, 2)).isEqualTo(0);
    }
}
