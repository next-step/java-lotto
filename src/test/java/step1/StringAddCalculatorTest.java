package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAddCalculatorTest {
    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @DisplayName("stringAddCalculator 생성 테스트")
    @Test
    void stringAddCalculatorTest() {

    }

    @DisplayName("null, empty 확인")
    @ParameterizedTest
    @NullAndEmptySource
    void isBlankTest(String nullAndEmpty) {
        assertThat(stringAddCalculator.calculate(nullAndEmpty)).isEqualTo(0);
    }

    @DisplayName("숫자인지 검사")
    @Test
    void isNumberTest() {
        assertThat(stringAddCalculator.calculate("1")).isEqualTo(1);
        assertThat(stringAddCalculator.calculate("10")).isEqualTo(10);
    }

    @DisplayName("음수이면 Exception 발생")
    @Test
    void isNegativeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringAddCalculator.calculate("-1:3:4");
        });
    }

    @DisplayName("더하기")
    @Test
    void plusTest() {
        assertThat(stringAddCalculator.calculate("1:1:8")).isEqualTo(10);
    }

    @DisplayName("커스텀 구분자로 구분")
    @Test
    void plusByCustomDelimiterTest() {
        assertThat(stringAddCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("커스텀 쉼표로 구분")
    @Test
    void plusByCommaDelimiterTest() {
        assertThat(stringAddCalculator.calculate("1,2")).isEqualTo(3);
    }

    @DisplayName("커스텀 쉼표로 구분")
    @Test
    void plusByDefaultDelimiterTest() {
        assertThat(stringAddCalculator.calculate("1,2:3")).isEqualTo(6);
    }
}
