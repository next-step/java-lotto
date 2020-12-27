package calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @ParameterizedTest
    @CsvSource(value = {"1,2,3=6", "4,5:6=15", "0,1,0=1"}, delimiter = '=')
    @DisplayName("전체 통합 테스트")
    void integrationTest(String input,String result) {
        stringCalculator = new StringCalculator(input);
        assertThat(stringCalculator.sumNumbers()).isEqualTo(Integer.parseInt(result));
    }

    @Test
    @DisplayName("커스텀 패턴 테스트")
    void customPatternIntegrationTest() {
        String input = "//;\n1;2;3";
        stringCalculator = new StringCalculator(input);
        assertThat(stringCalculator.sumNumbers()).isEqualTo(6);
    }

}