package stringcalcaulator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

public class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

    @Test
    void addTest() {
        int actual = calculator.calculate("1 + 2");

        assertThat(actual).isEqualTo(3);
    }

    @Test
    void subTest() {
        int actual = calculator.calculate(" 1 - 2 ");

        assertThat(actual).isEqualTo(-1);
    }

    @Test
    void mulTest() {
        int actual = calculator.calculate("1 * 2");

        assertThat(actual).isEqualTo(2);
    }

    @Test
    void divTest() {
        int actual = calculator.calculate("3 / 2");

        assertThat(actual).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({
        "2 + 3 * 4 / 2, 10",
        "2 + 3 * 4 / 2 - 1, 9",
        "2 + 3 * 4 / 2 - 1 - 9 + 10000, 10000"})
    void 복잡한_연산도_정상동작_한다(String expression, int expected) {
         int actual = calculator.calculate(expression);

         assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 입력_값이_null이거나_빈_공백_문자일_경우_throw한다(String input) {
        IllegalArgumentException e = catchThrowableOfType(
            () -> calculator.calculate(input), IllegalArgumentException.class);

        assertThat(e).hasMessage("입력값이 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 $ 2", "3 % 1", "4 @ 2", "1 < 5"})
    void 사칙연산_기호가_아닌_경우_throw한다(String input) {
        IllegalArgumentException e = catchThrowableOfType(
            () -> calculator.calculate(input), IllegalArgumentException.class);

        assertThat(e).hasMessage("숫자 또는 연산자만 입력이 가능합니다.");
    }

}
