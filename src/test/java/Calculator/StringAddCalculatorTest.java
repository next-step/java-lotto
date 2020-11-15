package Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringAddCalculatorTest {

    @DisplayName("splitAndSum() 메소드 테스트 : validate 체크")
    @ParameterizedTest(name = "[{index}] {0} = 0")
    @NullAndEmptySource
    void validate(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isZero();
    }

    @DisplayName("splitAndSum() 메소드 테스트 : 기본 구분자")
    @ParameterizedTest(name = "[{index}] {0} = {1}")
    @CsvSource(value = {
            // input, result
            "      1 | 1",
            "    1,2 | 3",
            "  1,2:3 | 6",
    }, delimiter = '|')
    void calculate1(String input, int result) {
        int sum = StringAddCalculator.splitAndSum(input);
        assertThat(sum).isEqualTo(result);
    }

    @DisplayName("splitAndSum() 메소드 테스트 : custom 구분자")
    @Test
    void calculate2() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("splitAndSum() 메소드 테스트 : 계산식이 잘못된 경우")
    @ParameterizedTest(name = "[{index}] {0} = {1}")
    @ValueSource(strings = {"-1,2,3", "1,2,A"})
    void calculate3(String input) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }
}
