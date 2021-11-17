package calcalator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null을 입력할 경우 true 반환")
    void isEmpty(String input) {
        assertThat(Calculator.isEmpty(input)).isTrue();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null을 입력할 경우 0 반환")
    void parseEmpty(String input) {
        assertThat(Calculator.parse(input)).isEqualTo(0);
    }


    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "10,10", "101,101"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    void parseNumber(String input, int output) {
        assertThat(Calculator.parse(input)).isEqualTo(output);
    }

    @Test
    @DisplayName("숫자와 문자가 포함된 문자열을 숫자로 변환했을 때 예외 발생")
    void parseNumber() {
        assertThatThrownBy(() -> Calculator.parse("abc123"))
                .isInstanceOf(NumberFormatException.class);
    }

}