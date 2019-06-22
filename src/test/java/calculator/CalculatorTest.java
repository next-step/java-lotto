package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {

    @ParameterizedTest(name = "입력값이 null 또는 공백일 때 0을 리턴. inputValue=`{0}`")
    @NullAndEmptySource
    void empty(String inputValue) {

        int result = Calculator.process(inputValue);
        assertThat(result).isZero();
    }

    @ParameterizedTest(name = "입력값이 한 자리수 일 때 그대로 리턴. inputValue={0}")
    @ValueSource(strings = {"3", "0"})
    void single(String inputValue) {

        int result = Calculator.process(inputValue);
        assertThat(result).isEqualTo(Integer.parseInt(inputValue));
    }

    @Test
    @DisplayName("입력값이 두 자리수 일 때 더한 값을 리턴")
    void doubles() {

        int result = Calculator.process("4,5");
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("입력값이 세 자리수 일 때 더한 값을 리턴")
    void triple() {

        int result = Calculator.process("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("입력값에 콤마와 콜론이 있을 때 더한 값을 리턴")
    void commaAndColon() {

        int result = Calculator.process("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("입력값에 커스텀 구분자가 있을 때 더한 값을 리턴")
    void customDelimiters() {

        int result = Calculator.process("//;\\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest(name = "입력값에 문자가 있을 때 RuntimeException 발생")
    @ValueSource(strings = {"a", "word", "1,2,three"})
    void containsWord(String inputValue) {

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> Calculator.process(inputValue));
    }

    @ParameterizedTest(name = "입력값에 음수가 있을 때 RuntimeException 발생")
    @ValueSource(strings = {"-1", "1,2,-1"})
    void containsNegative(String inputValue) {

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> Calculator.process(inputValue));
    }
}
