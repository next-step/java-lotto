package calculator.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.operator.Operator;
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
            .hasMessage("0 미만의 숫자는 허용되지 않습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null이나 빈 문자열로 PositiveInt 객체를 생성할 수 없다.")
    void create_withNullOrEmpty(String value) {
        assertThatThrownBy(() -> PositiveInt.from(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력 값이 누락되었습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-9", "##51"})
    @DisplayName("숫자 이외의 문자열로 PositiveInt 객체를 생성할 수 없다.")
    void create_withInvalidString(String value) {
        assertThatThrownBy(() -> PositiveInt.from(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("변환할 수 없는 문자가 포함되어 있습니다.");
    }

    @Test
    @DisplayName("calculate 메소드는 주어진 연산자로 다른 PositiveInt 객체와 계산한다.")
    void calculate() {
        PositiveInt x = new PositiveInt(2);
        PositiveInt y = new PositiveInt(3);
        assertThat(x.calculate(y, Operator.MULTIPLY)).isEqualTo(new PositiveInt(6));
    }
}