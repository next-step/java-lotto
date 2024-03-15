package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("연산 성공 : 20 + 20 * 4 / 2 = 40")
    void calculate__WithPluralOperators() {
        // given
        String input = "20 + 20 * 4 / 2";

        // when
        long answer = stringCalculator.calculate(input);

        // then
        assertThat(answer).isEqualTo(80);
    }

    @Test
    @DisplayName("연산 성공 : 2")
    void calculate__WithSingleNumber() {
        // given
        String input = "2";

        // when
        long answer = stringCalculator.calculate(input);

        // then
        assertThat(answer).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings={"a + b - c", "10 - 9 ! 3", "10 +", "- 10 +", "* 10"})
    @DisplayName("허용되지 않은 값, 또는 유효하지 않은 시퀀스에 대한 에러")
    void calculate__ShouldThrowException__InvalidInput(String input) {
        // when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculate(input);
        });
    }
}
