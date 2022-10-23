package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "1", "a", "="})
    @DisplayName("사칙 연산자 이외의 값이 들어가면 에러를 발생한다.")
    void invalidInputTest_thenIllegalArgumentException(String input) {
        assertThatThrownBy(() -> Operation.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
