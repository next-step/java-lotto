package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    private static final String DEFAULT_DELIMITER = ":";

    @ParameterizedTest
    @DisplayName("숫자 덧셈 성공")
    @CsvSource(value = {"3:4=7", "5:5=10"}, delimiter = '=')
    void addNumberSuccess(String input, Integer result) {
        String[] numbers = input.split(DEFAULT_DELIMITER);
        assertThat(Number.add(numbers[0], numbers[1]).getResult()).isEqualTo(result);

    }

    @ParameterizedTest
    @DisplayName("숫자 덧셈 1보다 작은 값으로 실패")
    @ValueSource(strings = {"3:0", "3:-1"})
    void addNumberIllegalArgumentException(String input) {
        String[] numbers = input.split(DEFAULT_DELIMITER);
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Number.add(numbers[0], numbers[1]));
    }

    @ParameterizedTest
    @DisplayName("숫자 외 다른 값으로 인한 실패")
    @ValueSource(strings = {"3:a", "3:{"})
    void addNumberFormatException(String input) {
        String[] numbers = input.split(DEFAULT_DELIMITER);
        assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> Number.add(numbers[0], numbers[1]));
    }

}
