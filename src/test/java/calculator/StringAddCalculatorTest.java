package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSum_빈문자열_널_0반환(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "3:3", "5:5"}, delimiter = ':')
    void splitAndSum_숫자하나(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void splitAndSum_구분자_컴마() {
        int result = StringAddCalculator.splitAndSum("1,2,5");
        assertThat(result).isEqualTo(8);
    }

    @Test
    void splitAndSum_구분자_컴마또는콜론() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("//와 \n문자 사이로 커스텀 구분자를 지정 가능")
    @Test
    void splitAndSum_구분자_커스텀() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3;10");
        assertThat(result).isEqualTo(16);
    }

    @DisplayName("숫자 이외의 값이나 음수가 오는 경우 RuntimeException")
    @Test
    void splitAndSum_숫자이외의값_음수_예외() {

    }

}
