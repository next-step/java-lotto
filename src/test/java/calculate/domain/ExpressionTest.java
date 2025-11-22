package calculate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {

    @Test
    @DisplayName("입력값은 숫자와 사칙연산 기호로 나뉜다")
    void expressionValidate() {
        assertThatThrownBy(() -> new Expression("2 & 3")).isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null이거나 빈 문자열이면 IllegalArgumentException")
    void expressionNullOrEmpty(String input) {
        assertThatThrownBy(() -> new Expression(input)).isInstanceOf(IllegalArgumentException.class);
    }
}