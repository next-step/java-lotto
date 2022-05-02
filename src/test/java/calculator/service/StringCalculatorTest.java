package calculator.service;

import calculator.domain.StringNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTest {

    @DisplayName("문자열을 분리하고 계산하는 기능 테스트 - 연산자 우선순위 정방향, 역방향")
    @CsvSource(value = {"10 + 11 * 12 / 3:84", "10 * 11 / 5 + 2 - 1:23"}, delimiter = ':')
    @ParameterizedTest
    void splitStringAndCalculateTest(String input, String result) {
        Assertions.assertThat(StringCalculator.splitStringAndCalculate(input))
                .isEqualTo(new StringNumber(result));
    }
}