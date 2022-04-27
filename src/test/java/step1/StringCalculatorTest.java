package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("문자열 계산기")
class StringCalculatorTest {

    @Test
    void 사칙연산_테스트() {
        String input = "- 1 * 2 / 2 - 1";

        StringCalculator stringCalculator = new StringCalculator(input);

        assertThat(stringCalculator.calculate()).isEqualTo(new Number(-2));
    }
}