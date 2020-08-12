package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("기본 구분자로 문자열 덧셈")
    void calculate_defaultDelimiter() {
        assertThat(StringAddCalculator.calculate("1:1")).isEqualTo(2);
        assertThat(StringAddCalculator.calculate("1,1")).isEqualTo(2);
        assertThat(StringAddCalculator.calculate("1,1:1")).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 하나 일때 입력값을 리턴")
    void calculate_oneNumber() {
        assertThat(StringAddCalculator.calculate("1")).isEqualTo(1);
        assertThat(StringAddCalculator.calculate("100")).isEqualTo(100);
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열 덧셈")
    void calculate_customDelimiter() {
        assertThat(StringAddCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("빈 문자열 혹은 Null 입력시 0 리턴")
    void calculate_emptyOrNull() {
        assertThat(StringAddCalculator.calculate("")).isZero();
        assertThat(StringAddCalculator.calculate(null)).isZero();
    }

    @Test
    @DisplayName("음수 입력시 runtime exception 발생")
    void calculate_negative() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("-1,1,2")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 이외 값 입력시 runtime exception 발생")
    void calculate_invalidNumber() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("a,1,2")).isInstanceOf(RuntimeException.class);
    }
}
