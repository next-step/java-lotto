package kr.insup.calculator;

import kr.insup.calculator.StringAddCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @ParameterizedTest
    @CsvSource(value = {"1,2,3!6", "1:2,4!7", "0,4,2!6"}, delimiter = '!')
    void 문자열_받아_합_계산(String input, int expected) {
        //given
        int result = stringAddCalculator.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"6, 6", "4, 4"})
    void 문자열_하나일_때_계산(String input, int expected) {
        //given
        int result = stringAddCalculator.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 문자열_비어있을_때_계산() {
        //given
        int result = stringAddCalculator.calculate("");

        //then
        assertThat(result).isEqualTo(0);
    }
}
