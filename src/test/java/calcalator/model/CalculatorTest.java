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

    @Test
    @DisplayName("숫자 두개를 컴마(,)로 구분")
    void split() {
        assertThat(Calculator.split("1,2,3")).contains("1", "2", "3");
    }

    @Test
    @DisplayName("입력값을 여러 구분자로 구분")
    void multiSplit() {
        String regex = "[,:]";
        assertThat("1,2:3".split(regex)).contains("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void customDelimiter() {
        assertThat(Calculator.split("//;\n1;2;3")).contains("1", "2", "3");
    }

    @ParameterizedTest
    @CsvSource(value = {"2,4:6", "10,12:22", "30,2:32", "101,123:224"}, delimiter = ':')
    @DisplayName("숫자 두개를 컴마(,)로 구분자로 입력헀을 경우 두 숫자의 합을 반환")
    void plusNumbers(String input, int output) {
        assertThat(Calculator.plus(input, ",")).isEqualTo(output);
    }

    @Test
    @DisplayName("커스텀 구분자를 입력헀을 경우 두 숫자의 합을 반환")
    void plusNumbers() {
        assertThat(Calculator.plus("//;\n1;2;3")).isEqualTo(6);
    }


    @Test
    @DisplayName("입력값이 음수일 때 parse시 RuntimeException 발생")
    void isNegative() {
        assertThatThrownBy(() -> Calculator.parse("-1"))
                .isInstanceOf(RuntimeException.class);

    }

    @Test
    @DisplayName("입력값이 음수일 때 pluse시 RuntimeException 발생")
    void plusWithNegative() {
        assertThatThrownBy(() -> Calculator.plus("-1,-2,1"))
                .isInstanceOf(RuntimeException.class);
    }
}