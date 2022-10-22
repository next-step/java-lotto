package calculator.domain;

import static calculator.exception.ExceptionMessage.ERROR_EMPTY_VALUE;
import static calculator.exception.ExceptionMessage.ERROR_INVALID_VALUE_TO_CONVERT;
import static calculator.exception.ExceptionMessage.ERROR_NEGATIVE_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.domain.Operator;
import calculator.domain.PositiveInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveIntTest {

    @ParameterizedTest
    @ValueSource(ints = {-3, -100})
    @DisplayName("0 미만의 숫자로 PositiveInt 객체를 생성할 수 없다.")
    void create_withUnderZero(int value) {
        assertThatThrownBy(() -> new PositiveInt(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_NEGATIVE_VALUE.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null이나 빈 문자열로 PositiveInt 객체를 생성할 수 없다.")
    void create_withNullOrEmpty(String value) {
        assertThatThrownBy(() -> PositiveInt.from(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_EMPTY_VALUE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-9", "##51"})
    @DisplayName("숫자 이외의 문자열로 PositiveInt 객체를 생성할 수 없다.")
    void create_withInvalidString(String value) {
        assertThatThrownBy(() -> PositiveInt.from(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_INVALID_VALUE_TO_CONVERT.getMessage());
    }

    @Test
    @DisplayName("calculate 메소드는 주어진 연산자로 다른 PositiveInt 객체와 계산한다.")
    void calculate() {
        PositiveInt x = new PositiveInt(2);
        PositiveInt y = new PositiveInt(3);
        assertThat(x.calculate(y, Operator.MULTIPLY)).isEqualTo(new PositiveInt(6));
    }
}