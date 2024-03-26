package calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("문자열 계산 테스트")
    void sumTest() {
        // Given
        final String input = "2 + 3 * 4 / 2";
        final StringCalculator stringCalculator = new StringCalculator();

        // When
        int actual = stringCalculator.result(input);

        // Then
        int expected = 10;
        assertThat(actual).isEqualTo(expected);
    }

}
