package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {
    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @Test
    @DisplayName("빈 문자열, null 값 입력 테스트")
    void emptyNullInput_ShouldBeZero() {
        assertThat(stringAddCalculator.calculate("")).isEqualTo(0);
        assertThat(stringAddCalculator.calculate(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 입력 테스트")
    void oneInput_shouldBeOneInput() {
        assertThat(stringAddCalculator.calculate("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("콤마 테스트")
    void commaDelimiter_shouldBeEachPlus() {
        assertThat(stringAddCalculator.calculate("1,2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론 테스트")
    void colonDelimiter_shouldBeEachPlus() {
        assertThat(stringAddCalculator.calculate("1:2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("콤마 또는 콜론 테스트")
    void commaORColonDelimiter_shouldBeEachPlus() {
        assertThat(stringAddCalculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void customDelimiter_shouldBeEachPlus() {
        assertThat(stringAddCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 입력 테스트")
    void negativeInput_shouldBeRuntimeException() {
        assertThatThrownBy(() -> stringAddCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
