package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exceptions.InvalidPatternException;

public class StringAddCalculatorTest {

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
    @Test
    void compute_EmptyString_0() {
        assertThat(StringAddCalculator.compute("")).isEqualTo(0);
        assertThat(StringAddCalculator.compute(null)).isEqualTo(0);
    }

    @DisplayName("올바른 패턴의 숫자를 입력할 경우 합계를 반환한다.")
    @ParameterizedTest(name = "입력: \"{0}\", 합: \"{1}\"")
    @CsvSource(value = {"1=1", "1,2=3", "1,2:3=6", "//;\\n1,2:3;4=10", "//*\\n1*2=3"}, delimiter = '=')
    void compute_Numbers_Success(String input, int expected) {
        assertThat(StringAddCalculator.compute(input)).isEqualTo(expected);
    }

    @DisplayName("잘못된 입력을 할 경우 에러를 발생한다.")
    @ParameterizedTest(name = "입력: \"{0}\"")
    @ValueSource(strings = {"a", "-1", "//;\\n1=2"})
    void compute_InvalidPattern_ExceptionThrown(String input) {
        assertThatExceptionOfType(InvalidPatternException.class).isThrownBy(() -> {
            StringAddCalculator.compute(input);
        });
    }

}
