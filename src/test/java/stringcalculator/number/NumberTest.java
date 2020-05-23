package stringcalculator.number;

import stringcalculator.exception.NegativeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {

    @DisplayName("생성 실패: 음수값 문자의 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = "-1")
    void createFailureByNegativeNumber(final String number) {
        assertThatExceptionOfType(NegativeNumberException.class)
                .isThrownBy(() -> Number.of(number));
    }

    @DisplayName("생성 실패: 숫자 이외의 값, null, empty 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "숫자 이외의 값")
    void createFailureByNotNumberFormat(final String number) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> Number.of(number));
    }

    @DisplayName("0 이상의 양의 값 문자가 들어오면 Number 객체를 생성")
    @ParameterizedTest
    @ValueSource(strings = { "0", "1000" })
    void create(final String number) {
        assertThatCode(() -> Number.of(number))
                .doesNotThrowAnyException();
    }

    @DisplayName("인수로 받은 값과 합한 값의 Number 객체를 반환")
    @ParameterizedTest
    @MethodSource()
    void plus(final String value, final Number expected) {
        Number operand = Number.of("1");
        assertThat(Number.of(value).plus(operand))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> plus() {
        return Stream.of(
                Arguments.of("0", Number.of("1")),
                Arguments.of("1", Number.of("2")),
                Arguments.of("100", Number.of("101"))
        );
    }

    @DisplayName("자신의 숫자값 반환")
    @ParameterizedTest
    @ValueSource(strings = { "0", "10", "1000" })
    void getValue(final String number) {
        assertThat(Number.of(number).getValue())
                .isEqualTo(Integer.parseInt(number));
    }
}
