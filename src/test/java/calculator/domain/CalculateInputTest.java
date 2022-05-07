package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculateInputTest {

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void construct_fail(String inputData) {
        assertThatIllegalArgumentException().isThrownBy(() -> new CalculateInput(inputData))
                .withMessageContaining("빈 값을 입력할 수 없습니다.");
    }

    @DisplayName("사칙연산을 모두 포함하는 기능 구현")
    @ParameterizedTest
    @CsvSource(value = {"3 + 5 - 2 * 7 / 2 : 21"}, delimiter = ':')
    void calculate(String calculateData, int expected) {
        CalculateInput calculateInput = new CalculateInput(calculateData);
        assertThat(calculateInput.splitAndCalculate()).isEqualTo(expected);
    }

    @DisplayName("덧셈")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3: 6"}, delimiter = ':')
    void calculate_sum(String calculateData, int expected) {
        CalculateInput calculateInput = new CalculateInput(calculateData);
        assertThat(calculateInput.splitAndCalculate()).isEqualTo(expected);
    }
}
