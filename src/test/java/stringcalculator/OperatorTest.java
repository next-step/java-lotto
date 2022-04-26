package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사칙연산 계산 클래스 테스트")
public class OperatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    void addOperatorTest() {
        // given
        Operator operator = OperatorFactory.get("+");

        // when
        int result = operator.calculate(1, 2);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void minusOperatorTest() {
        // given
        Operator operator = OperatorFactory.get("-");

        // when
        int result = operator.calculate(1, 2);

        // then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divideOperatorTest() {
        // given
        Operator operator = OperatorFactory.get("/");

        // when
        int result = operator.calculate(2, 1);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multipleOperatorTest() {
        // given
        Operator operator = OperatorFactory.get("*");

        // when
        int result = operator.calculate(2, 2);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("잘못된 연산자가 입력으로 들어오면 예외가 발생한다.")
    void OperatorFailTest() {
        assertThatThrownBy(() -> OperatorFactory.get("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
