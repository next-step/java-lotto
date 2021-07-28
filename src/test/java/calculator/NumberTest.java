package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("숫자 문자열로 Number 객체를 생성한다.")
    @ValueSource(strings = {"1", "10", "100"})
    @ParameterizedTest
    void create(String numberString) {
        Number number = new Number(numberString);
        assertThat(number.intValue()).isEqualTo(Integer.parseInt(numberString));
    }

    @DisplayName("음수 또는 숫자가 아닌 문자가 전달되면 RuntimeException 예외가 발생한다.")
    @ValueSource(strings = {"-1", "a", "!", ""})
    @ParameterizedTest
    void invalidNumber(String number) {
        assertThatThrownBy(() -> new Number(number))
            .isInstanceOf(RuntimeException.class);
    }

}
