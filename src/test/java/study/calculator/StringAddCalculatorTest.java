package study.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
