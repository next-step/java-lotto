package study.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import study.calculator.exception.CalculatorException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @ParameterizedTest(name = "null 또는 empty 문자 처리")
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String given) {
        int result = StringAddCalculator.splitAndSum(given);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest(name = "숫자로 캐스팅이 가능한 문자 입력 시 결과 값 테스트")
    @CsvSource(value = {"1, 1", "2, 2"})
    public void splitAndSum_숫자하나(String given, int expected) throws Exception {
        int result = StringAddCalculator.splitAndSum(given);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "길이가 1이지만 숫자가 아닌경우({0}) 예외 처리 테스트")
    @CsvSource(value = {"a", "%"})
    void splitAndSum_숫자가_아닌_문자_입력시_예외처리(String given) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    StringAddCalculator.splitAndSum(given);
                }).withMessageContaining("숫자로 캐스팅할 수 없는 문자입니다.");
    }

    @ParameterizedTest(name = "두 숫자({0})를 더한 결과 값이 {1}")
    @CsvSource(value = {"1,2:3", "2,3:5"}, delimiter = ':')
    public void splitAndSum_쉼표구분자(String given, int expected) throws Exception {
        int result = StringAddCalculator.splitAndSum(given);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "여러 숫자{0}를 더한 결과 값 {1}")
    @CsvSource(value = {"1,2:3^6", "2:2,4^8"}, delimiter = '^')
    public void splitAndSum_쉼표_또는_콜론_구분자(String given, int expected) throws Exception {
        int result = StringAddCalculator.splitAndSum(given);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> customPatternEntry() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//#\n4#3", 7)
        );
    }
    @ParameterizedTest(name = "{0} 문자열을 합산한 결과물: {1}")
    @MethodSource(value = "customPatternEntry")
    public void splitAndSum_custom_구분자(String given, int expected) throws Exception {
        // when
        int result = StringAddCalculator.splitAndSum(given);
        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(CalculatorException.class);
    }
}
