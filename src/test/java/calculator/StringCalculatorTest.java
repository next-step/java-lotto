package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("컴마(,), 콜론(:) 기준으로 문자열을 분리할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1:2", "1,2:3"})
    void splitFromComma(String input) {
        final String[] expect = input.split(",|:");

        String[] splitInput = stringCalculator.splitInput(input);

        assertThat(splitInput).isEqualTo(expect);
    }

    @DisplayName("분리된 문자열을 합한다.")
    @Test
    void add() {
        final String input = "1,2:3";
        final int expect = 6;

        int sum = stringCalculator.calculate(input);

        assertThat(sum).isEqualTo(expect);
    }
}