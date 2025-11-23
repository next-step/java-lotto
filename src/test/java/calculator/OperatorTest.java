package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    @Test
    void validOperatorsFromString() {
        assertThat(Operator.fromString("+")).isEqualTo(Operator.ADD);
        assertThat(Operator.fromString("-")).isEqualTo(Operator.SUBTRACT);
        assertThat(Operator.fromString("*")).isEqualTo(Operator.MULTIPLY);
        assertThat(Operator.fromString("/")).isEqualTo(Operator.DIVIDE);
    }

    @Test
    void invalidOperator() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.fromString("^"))
                .withMessageContaining("사용할 수 없는 연산자");
    }

    @Test
    void applyEachOperator() {
        assertThat(Operator.ADD.apply(2, 3)).isEqualTo(5);
        assertThat(Operator.SUBTRACT.apply(5, 3)).isEqualTo(2);
        assertThat(Operator.MULTIPLY.apply(2, 3)).isEqualTo(6);
        assertThat(Operator.DIVIDE.apply(6, 3)).isEqualTo(2);
    }

    @Test
    void divideByZero() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.DIVIDE.apply(5, 0))
                .withMessageContaining("0으로 나눌 수 없습니다");
    }
}
