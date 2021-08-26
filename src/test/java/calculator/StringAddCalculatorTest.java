package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void beforeEach() {
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("null이 들어왔을 때 빈문자를 반환해야 한다.")
    void splitAndSumByNull() {

        // given
        String input = null;

        // when
        int result = stringAddCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    @DisplayName("공백이 들어왔을 때 0을 반환해야 한다.")
    void splitAndSumByBlank(String input) {

        // when
        int result = stringAddCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("숫자 하나가 들어왔을 때 해당 숫자를 반환해야 한다.")
    void splitAndSumBySingleNum(String input) {

        // given
        int num = Integer.parseInt(input);

        // when
        int result = stringAddCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(num);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "3,4:7"}, delimiter = ':')
    @DisplayName("숫자 두개를 쉼표(,)로 구분지은 경우 두 숫자의 합을 반환해야 한다.")
    void splitAndSumByComma(String input, int expected) {

        // when
        int result = stringAddCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6", "4:5,6=15"}, delimiter = '=')
    @DisplayName("숫자 두개 사이에 콜론(:)을 사용하여 구분할 경우도 두 숫자의 합을 반환해야 한다.")
    void splitAndSumByColon(String input, int expected) {

        // when
        int result = stringAddCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용하여 구분할 경우도 두 숫자의 합을 반환해야 한다.")
    void splitAndSumByCustomSeparator() {

        // given
        String input = "//;\n1;2;3";
        int expected = 6;

        // when
        int result = stringAddCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("음수가 전달될 경우 RuntimeException이 발생해야 한다.")
    void splitAndSumByNegativeNum() {

        // given
        String input = "-1,5";

        // when & then
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> stringAddCalculator.splitAndSum(input))
            .withMessageMatching("음수는 계산할 수 없다.");
    }

}