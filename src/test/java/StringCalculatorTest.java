import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator(new Splitter());

    @Test
    void 사칙연산의_계산_우선순위가_아닌_입력_값에_따라_계산할_수_있다() {
        // given
        String value = "2 + 3 * 4 / 2";
        int expectedResult = 10;

        // when
        int result = stringCalculator.calculate(value);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
