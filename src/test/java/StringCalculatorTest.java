import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculatorTest {

    @Test
    @DisplayName("정상적으로 동작하는지에 대한 테스트.")
    void calculate() {
        int result = StringCalculator.calculateByGivenString("2 + 3 * 4 / 2");
        Assertions.assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("빈문자열이거나 공백일 경우 IllegalArgumentException을 던지는 테스트")
    void calculate(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringCalculator.calculateByGivenString(input));
    }


    @Test
    @DisplayName("사칙연산이 아닌경우 IllegalArgumentException을 던지는 테스트")
    void calculate2() {
        //given
        String givenString = "2 + 3 ! 4 / 2";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringCalculator.calculateByGivenString(givenString));
    }
}