package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculator {

    @Test
    void 덧셈() {
        // given
        StringCalculator stringCalculator = new StringCalculator()

        // when
        int result = stringCalculator.plus(1, 2);

        // then
        assertThat(result).isEqualTo(3);
    }
}
