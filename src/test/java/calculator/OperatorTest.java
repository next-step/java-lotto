package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    @Test
    public void 덧셈연산을_수행한다() {
        int result = Operator.calculate(2, 3, "+");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 뺄셈연산을_수행한다() {
        int result = Operator.calculate(3, 2, "-");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 곱셈연산을_수행한다() {
        int result = Operator.calculate(3, 2, "*");
        assertThat(result).isEqualTo(6);
    }


    @Test
    public void 나눗셈연산을_수행한다() {
        int result = Operator.calculate(6, 2, "/");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 사칙연산_기호가_아닌경우_예외를_발생시킨다() {
        assertThatThrownBy(() -> Operator.calculate(6, 2, "&"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("지원하지 않는 연산자");
    }



}
