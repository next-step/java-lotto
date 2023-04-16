package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {
    @Test
    @DisplayName("Operator 생성 테스트")
    void operator() {
        // given
        String input = "+";
        Operator expected = Operator.ADD;

        // when
        Operator actual = Operator.of(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Operator 생성 테스트 (예외)")
    void operatorException() {
        // given
        String input = "x";

        // then
        assertThatThrownBy(() -> Operator.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호가 아닙니다.");
    }
}
