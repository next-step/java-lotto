package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringSumCalculatorTest {

    private StringSumCalculator stringSumCalculator;

    @BeforeEach
    void setUp() {
        stringSumCalculator = new StringSumCalculator();
    }

    @Test
    @DisplayName("문자열을 입력받을 때, 빈 문자열인 경우 0을 리턴한다.")
    void input_test() {
        int result = stringSumCalculator.sum(null);
        assertThat(result).isEqualTo(0);

        result = stringSumCalculator.sum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1:2,3=6"}, delimiter = '=')
    @DisplayName("쉼표와 콜론으로 split한 숫자를 합해서 반환하는지 확인한다.")
    void split_colon_comma_test(String input, int expected) {
        int result = stringSumCalculator.sum(input);
        assertThat(result).isEqualTo(expected);
    }
}