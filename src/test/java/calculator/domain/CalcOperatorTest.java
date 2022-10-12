package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalcOperatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    @DisplayName("사칙연산자를 생성한다.")
    void createFourOperatorTest_thenIsEqualToInstance(String input) {
        CalcOperator operator = new CalcOperator(input);
        assertThat(operator).isEqualTo(new CalcOperator(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "1", "a", "="})
    @DisplayName("사칙 연산자 이외의 값이 들어가면 에러를 발생한다.")
    void invalidInputTest_thenIllegalArgumentException(String input) {
        assertThatThrownBy(() -> new CalcOperator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
