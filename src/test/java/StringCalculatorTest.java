import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @Test
    void 빈_문자열일_때는_예외가_발생한다() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculator(""))
                .withMessage("문자열을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "4 - 2:2", "9 / 3:3", "2 * 4:8"}, delimiter = ':')
    void 수_2개_사칙연산이_가능하다(String input, int expect) {

        // when
        int result = StringCalculator.calculator(input);

        // then
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 4 * 3 / 6:3", "6 - 4 * 5 / 2:5"}, delimiter = ':')
    void 수_여러_개_사칙연산이_가능하다(String input, int expect) {

        // when
        int result = StringCalculator.calculator(input);

        // then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 유효하지_않는_기호일_경우_예외가_발생한다() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculator("1 & 2"))
                .withMessage("유효한 사칙연산 기호를 입력해주세요.");
    }
}
