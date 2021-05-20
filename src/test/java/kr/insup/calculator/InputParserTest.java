package kr.insup.calculator;

import kr.insup.calculator.domain.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {

    @DisplayName("구분자 잘 뽑아내는지 테스트")
    @ParameterizedTest
    @MethodSource("kr.insup.calculator.TestHelper#provideDelimiterExample")
    void 구분자_추출_테스트(String input, String expected) {
        //given
        String delimiter = InputParser.getDelimiter(input);

        //then
        assertThat(delimiter).isEqualTo(expected);
    }

    @DisplayName("숫자영역만 잘 뽑아내는지 테스트")
    @ParameterizedTest
    @MethodSource("kr.insup.calculator.TestHelper#provideNumbersExample")
    void 숫자영역_추출_테스트(String input, String expected) {
        //given
        String onlyNumbers = InputParser.getOnlyNumbers(input);

        //then
        assertThat(onlyNumbers).isEqualTo(expected);
    }
}
