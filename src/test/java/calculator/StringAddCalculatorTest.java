package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"|0", "2|2", "2,3|5", "2:3|5", "2,3:4|9"}, delimiter = '|')
    @DisplayName("주어진 문자열을 구분자로 나누고 합계를 구합니다")
    public void splitAndSum(String input, String expected) {
        // given
        StringAddCalculator stringAddCalculator = new StringAddCalculator(input);

        // when
        int result = stringAddCalculator.splitAndSum();

        // then
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"a", "2:a", "-1"})
    @DisplayName("양의 정수가 아닌 값이 왔을 때 오류를 발생시키는 테스트")
    public void splitAndSumOccurredError(String input) {
        // given
        StringAddCalculator stringAddCalculator = new StringAddCalculator(input);

        // when
        Throwable throwable = catchThrowable(() -> {
            stringAddCalculator.splitAndSum();
        });

        // then
        assertThat(throwable).isInstanceOf(RuntimeException.class)
                             .hasMessageContaining("숫자가 아니거나 음의 값입니다.");
    }

    @Test
    @DisplayName("커스텀구분자가 포함된 문자열을 구분자로 나누고 합계를 구합니다")
    public void splitAndSumCustom() {
        // given
        String expression = "//;\n1,2:3;4";
        StringAddCalculator stringAddCalculator = new StringAddCalculator(expression);

        // when
        int result = stringAddCalculator.splitAndSum();

        // then
        assertThat(result).isEqualTo(10);
    }
}
