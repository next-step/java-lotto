package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @Test
    @DisplayName("null 또는 빈 문자 입력")
    void calculate_null_blank() {
        // given
        StringAddCalculator calculator = new StringAddCalculator();

        // when
        int nullResult = calculator.calculate(null);
        int emptyResult = calculator.calculate("");
        int blankResult = calculator.calculate("   ");

        // then
        assertThat(0).isEqualTo(nullResult);
        assertThat(0).isEqualTo(emptyResult);
        assertThat(0).isEqualTo(blankResult);
    }

    @Test
    @DisplayName("숫자 하나 입력")
    void calculate_justOneNumber() {
        // given
        StringAddCalculator calculator = new StringAddCalculator();

        // when
        int result = calculator.calculate("10");

        // then
        assertThat(10).isEqualTo(result);
    }

    @Test
    @DisplayName("기본 동작 테스트 - 기본 구분자")
    void calculate() {
        // given
        String target = "1,2:3";
        StringAddCalculator calculator = new StringAddCalculator();

        // when
        int sum = calculator.calculate(target);

        // then
        assertThat(6).isEqualTo(sum);
    }

    @Test
    @DisplayName("기본 동작 테스트 - 커스텀 구분자")
    void calculate_customDelimiter() {
        // given
        String target = "//;\n1;2;3";
        StringAddCalculator calculator = new StringAddCalculator();

        // when
        int sum = calculator.calculate(target);

        // then
        assertThat(6).isEqualTo(sum);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "//;\n-1;2;3"})
    @DisplayName("기본 동작 테스트 - 음수 입력")
    void calculate_negativeNum(String param) {
        // given
        StringAddCalculator calculator = new StringAddCalculator();

        // when then
        assertThatThrownBy(() -> calculator.calculate(param))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "2,3,a", "//;\n+;2;b"})
    @DisplayName("기본 동작 테스트 - 임의의 문자 입력")
    void calculate_nonNumber() {
        // given
        StringAddCalculator calculator = new StringAddCalculator();

        // when then
        assertThatThrownBy(() -> calculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}