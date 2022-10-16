import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void init() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @Order(1)
    public void 덧셈() {
        long expected = 5L;
        assertThat(stringCalculator.calculate("1 + 2 + 2")).isEqualTo(expected);
    }

    @Test
    @Order(2)
    public void 뺄셈() {
        long expected = -4L;
        assertThat(stringCalculator.calculate("1 - 2 - 3")).isEqualTo(expected);
    }

    @Test
    @Order(3)
    public void 나눗셈() {
        long expected = 1L;
        assertThat(stringCalculator.calculate("10 / 2 / 5")).isEqualTo(expected);
    }

    @Test
    @Order(4)
    public void 곱셈() {
        long expected = 100L;
        assertThat(stringCalculator.calculate("10 * 2 * 5")).isEqualTo(expected);
    }

    @Test
    @Order(5)
    public void 사칙연산() {
        long expected = 0L;
        assertThat(stringCalculator.calculate("10 / 2 - 5 * 3")).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @Order(6)
    public void 문자열_입력값_빈값_혹은_null(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> stringCalculator.calculate(input)
        ).withMessageContaining("유효하지 않은 문자열입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "+ -", "2 + 4 -"})
    @Order(7)
    public void 문자열_입력값_숫자_없음(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> stringCalculator.calculate(input)
        ).withMessageContaining("유효하지 않은 문자열입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 2 2", "3 1", "2 + 4 1"})
    @Order(8)
    public void 문자열_입력값_사칙연산_없음(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> stringCalculator.calculate(input)
        ).withMessageContaining("유효하지 않은 문자열입니다.");
    }
}
