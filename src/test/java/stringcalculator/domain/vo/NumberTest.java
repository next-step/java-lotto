package stringcalculator.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class NumberTest {

    @DisplayName("Number는 int 또는 Integer 타입으로도 비교할 수 있다.")
    @Test
    void numberCanCompareIntegerType() {
        Integer boxed = 1;
        int primary = 1;
        Number number = Number.stringToNumber("1");

        assertAll(
                () -> assertThat(number).isEqualTo(boxed),
                () -> assertThat(number).isEqualTo(primary)
        );
    }

    @DisplayName("Number는 빈문자열 또는 Null이 들어오면 Number는 0을 가진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyStringIs0(String value) {
        Number number = Number.stringToNumber(value);
        assertThat(number).isEqualTo(0);
    }

    @DisplayName("Number는 숫자가 아닌 값이 들어오면 RuntimeException Throw")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "?", ","})
    void notNumeralThrowException(String value) {
        assertThatThrownBy(() -> Number.stringToNumber(value))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 아닙니다.");
    }

    @DisplayName("Number는 음수가 들어오면 RuntimeException Throw")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    void negativeNumeralThrowException(String value) {
        assertThatThrownBy(() -> Number.stringToNumber(value))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수가 입력되었습니다.");
    }

    @DisplayName("Number는 sum 메소드는 두개의 Number를 더한다.")
    @ParameterizedTest
    @CsvSource({"0, 1, 1", "1, 2, 3", "121, 233, 354"})
    void addNumber(String original, String source, int result) {
        Number originalNumber = Number.stringToNumber(original);
        Number sourceNumber = Number.stringToNumber(source);

        Number resultNumber = Number.sum(originalNumber, sourceNumber);

        assertThat(resultNumber).isEqualTo(result);
    }
}
