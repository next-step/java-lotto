package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalcNumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"3"})
    @DisplayName("숫자를 입력받는다. 문자열타입이어도 숫자로 입력 받는다.")
    void createNumberTest_thenIsEqualToInstance(String input) {
        CalcNumber number = new CalcNumber(input);

        assertThat(number).isEqualTo(new CalcNumber(3));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "a"})
    @DisplayName("정수를 입력받지 못하면 에러가 난다. Null 공백은 허용하지 않는다. 숫자의 입력값만 받는다.")
    void inputNumberTest_thenIllegalArgumentException(String input) {
        assertThatThrownBy(() -> new CalcNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
