package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("빈 문자열을 입력할 경우 0을 반환해야 한다.")
    @Test
    void returnZeroWhenEmptyString() {
        final String emptyString = "";

        int actual = stringCalculator.calculate(emptyString);

        assertThat(actual).isZero();
    }

    @DisplayName("null을 입력할 경우 0을 반환해야 한다.")
    @Test
    void returnZeroWhenNull() {
        int actual = stringCalculator.calculate(null);

        assertThat(actual).isZero();
    }

    @DisplayName("분리된 문자열을 합한다.")
    @Test
    void add() {
        final String input = "1,2:3";
        final int expect = 6;

        int sum = stringCalculator.calculate(input);

        assertThat(sum).isEqualTo(expect);
    }

    @DisplayName("숫자 이외의 값 or 음수일경우 RuntimeException 을 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "-1"
            , "!"
            , "-1,1"
            , "!,1"})
    void throwExceptionWhenInvalidInput(String input) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
                () -> stringCalculator.calculate(input)
        );
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @Test
    void returnOneNumber() {
        final String input = "1";
        final int expect = 1;

        int sum = stringCalculator.calculate(input);

        assertThat(sum).isEqualTo(expect);
    }
}