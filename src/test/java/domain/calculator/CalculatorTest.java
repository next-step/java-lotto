package domain.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @DisplayName("문자열을 입력을 안할시 0을 반환한다.")
    @Test
    public void invalidatedNumber() {
        assertThat(calculator.add("")).isEqualTo(0);
    }

    @DisplayName("쉼표(,) 을 구분자로 가지는 문자열을 전달하는 경우 합을 반환한다.")
    @Test
    public void gubun1sum() {
        assertThat(calculator.add("9,9,9")).isEqualTo(27);
    }

    @DisplayName("콜론(:) 을 구분자로 가지는 문자열을 전달하는 경우 합을 반환한다.")
    @Test
    public void gubun2sum() {
        assertThat(calculator.add("9:9:9")).isEqualTo(27);
    }

    @DisplayName("쉼표(,) 또는 콜론(:) 을 구분자로 가지는 문자열을 전달하는 경우 합을 반환한다.")
    @Test
    public void gubun3sum() {
        assertThat(calculator.add("9:9,9")).isEqualTo(27);
    }

    @DisplayName("앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.")
    @Test
    public void gubunsum() {
        assertThat(calculator.add("//%\n9%9%9")).isEqualTo(27);
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.")
    @Test
    public void runtimeError() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> calculator.add("-1"));

    }
}
