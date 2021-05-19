package kr.insup.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @DisplayName("문자열 받아 합 계산")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3!6", "1:2,4!7", "0,4,2!6"}, delimiter = '!')
    void 문자열_받아_합_계산(String input, int expected) {
        //given
        int result = stringAddCalculator.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("문자열 하나일 때 계산")
    @ParameterizedTest
    @CsvSource({"6, 6", "4, 4"})
    void 문자열_하나일_때_계산(String input, int expected) {
        //given
        int result = stringAddCalculator.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("문자열 비어있을 때 계산")
    @Test
    void 문자열_비어있을_때_계산() {
        //given
        int result = stringAddCalculator.calculate("");

        //then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("구분자 잘 뽑아내는지 테스트")
    @ParameterizedTest
    @MethodSource("kr.insup.calculator.TestHelper#provideDelimiterExample")
    void 구분자_추출_테스트(String input, String expected) {
        //given
        String delimiter = stringAddCalculator.getDelimiter(input);

        //then
        assertThat(delimiter).isEqualTo(expected);
    }

    @DisplayName("숫자영역만 잘 뽑아내는지 테스트")
    @ParameterizedTest
    @MethodSource("kr.insup.calculator.TestHelper#provideNumbersExample")
    void 숫자영역_추출_테스트(String input, String expected) {
        //given
        String onlyNumbers = stringAddCalculator.getOnlyNumbers(input);

        //then
        assertThat(onlyNumbers).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자 있을 때 계산")
    @ParameterizedTest
    @MethodSource("kr.insup.calculator.TestHelper#provideCalculateExample")
    void 커스텀_구분자_있을_때_계산(String input, int expected) {
        //given
        int result = stringAddCalculator.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
