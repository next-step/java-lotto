package caculator;

import caculator.domain.StringCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @DisplayName("Null 또는 공백 IllegalArgumentException 예외처리")
    @NullSource
    @ValueSource(strings = {"", " "})
    void 널값및공백예외처리(String input) {
        assertThatThrownBy(() -> {
            stringCalculator.playCalculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("뺄셈 테스트")
    @CsvSource(value = {"1 + 1:2", "1 + 2 + 3 + 4:10"}, delimiter = ':')
    void 덧셈(String input, int result) {
        Assertions.assertThat(stringCalculator.playCalculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("잘못된 계산식이 입력되었을 경우 IllegalArgumentException 예외처리")
    @ValueSource(strings = {"3 ! 1", "1 + ", "1 + +", "1 + 1 +"})
    void 잘못된계산식예외처리(String input) {
        assertThatThrownBy(() -> {
            stringCalculator.playCalculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("뺄셈 테스트")
    @CsvSource(value = {"1 - 1:0", "10 - 8 - 1:1"}, delimiter = ':')
    void 뺄셈(String input, int result) {
        Assertions.assertThat(stringCalculator.playCalculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("곱셈 테스트")
    @CsvSource(value = {"2 * 3:6", "2 * 2 * 2 * 2:16"}, delimiter = ':')
    void 곱셈(String input, int result) {
        Assertions.assertThat(stringCalculator.playCalculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("나눗셈 테스트")
    @CsvSource(value = {"4 / 2:2", " 8 / 2 / 2:2"}, delimiter = ':')
    void 나눗셈(String input, int result) {
        Assertions.assertThat(stringCalculator.playCalculate(input)).isEqualTo(result);
    }
}
