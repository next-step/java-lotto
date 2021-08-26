package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

}