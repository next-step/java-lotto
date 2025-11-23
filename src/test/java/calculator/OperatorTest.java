package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    @Test
    void 덧셈() {
        assertThat(Operator.getOperator("+").apply(1,2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(Operator.getOperator("-").apply(1,2)).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        assertThat(Operator.getOperator("*").apply(1,2)).isEqualTo(2);
    }

    @Test
    void 나눗셈() {
        assertThat(Operator.getOperator("/").apply(4,2)).isEqualTo(2);
    }

    @Test
    void 알_수_없는_수식_오류() {
        assertThatThrownBy(()->Operator.getOperator("^"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("알 수 없는 연산입니다.");
    }
}
