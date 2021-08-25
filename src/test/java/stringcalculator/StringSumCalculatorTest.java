package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringSumCalculatorTest {

    private StringSumCalculator stringSumCalculator;

    @BeforeEach
    void setUp() {
        stringSumCalculator = new StringSumCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("문자열을 입력받을 때, 빈 문자열인 경우 0을 리턴한다.")
    void input_test(String inputText) {
        int result = stringSumCalculator.sum(inputText);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 입력 테스트를 해본다.")
    void one_number_test() {
        int result = stringSumCalculator.sum("1");
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1:2,3=6"}, delimiter = '=')
    @DisplayName("쉼표와 콜론으로 split한 숫자를 합해서 반환하는지 확인한다.")
    void split_colon_comma_test(String input, int expected) {
        int result = stringSumCalculator.sum(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("쉼표와 콜론으로 split한 숫자를 합해서 반환하는지 확인한다.")
    void custom_separator_test() {
        int result = stringSumCalculator.sum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1,2=3", "1:2,-3=6"}, delimiter = '=')
    @DisplayName("음수를 입력할 경우 RuntimeException 발생")
    void minus_number_test(String input, int expected) {
        assertThatThrownBy(() -> stringSumCalculator.sum(input))
                .isInstanceOf(RuntimeException.class);
    }
}