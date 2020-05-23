package calculator.domain.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Number 클래스 테스트")
class NumberTest {

    @DisplayName("문자열을 입력받아 Number 객체를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "3"})
    void number (String input) {
        Number number = new Number(input);
        assertThat(number).isNotNull();
    }

    @DisplayName("음수 값이 전달되는 경우 RuntiemException 예외를 throw 할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-10000"})
    void inputValueIsNegative (String input) {
        assertThatThrownBy(() -> new Number(input)).isInstanceOf(NegativeInputException.class);
    }
}
