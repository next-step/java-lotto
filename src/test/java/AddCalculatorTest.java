import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class AddCalculatorTest {

    @ParameterizedTest
    @EmptySource
    @NullSource
    @DisplayName("input text가 null 또는 비어있는 값이 입력될 경우 0 정상 반환 여부 테스트")
    void splitAndSum_null_or_empty(String text) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "0:0", "10:10"}, delimiter = ':')
    @DisplayName("input text가 숫자 하나일때 해당값 정상 반환 여부 테스트")
    void splitAndSum_one_number(String text, int expected) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("쉼표 구분자를 이용하여 덧셈 연산 정상적으로 계산하는지 여부 테스트")
    void splitAndSum_rest_delimiter() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 구분자, 콤마 구분자를 이용하여 덧셈 연산 정상적으로 계산하는지 여부 테스트")
    void splitAndSum_rest_or_colon_delimiter() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 이용하여 덧셈 연산 정상적으로 계산하는지 여부 테스트")
    void splitAndSum_custom_delimiter() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3")).isInstanceOf(RuntimeException.class);
    }
}
