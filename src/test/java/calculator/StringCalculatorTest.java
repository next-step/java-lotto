package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @Test
    @DisplayName("계산 테스트")
    void calculate() {
        int result = StringCalculator.run("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @DisplayName("Null 혹은 빈 값 테스트")
    @NullAndEmptySource
    void isNullOrEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.run(input);
        });
    }

    @ParameterizedTest
    @DisplayName("잘못된 연산자 테스트")
    @ValueSource(strings = {"2 + 3 * 4 ! 2", "2 $ 3 * 4 ^ 2"})
    void invalidOperator(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.run(input);
        });
    }
}