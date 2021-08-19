package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("덧셈이 잘 되는지 테스트")
    void sum() {
        int result = StringCalculator.sum("1,2,3");
        assertThat(result).isEqualTo(6);

        result = StringCalculator.sum("2,4:6");
        assertThat(result).isEqualTo(12);

        result = StringCalculator.sum("3:6:9");
        assertThat(result).isEqualTo(18);

        result = StringCalculator.sum("//#\n5#10#15");
        assertThat(result).isEqualTo(30);

        result = StringCalculator.sum("7");
        assertThat(result).isEqualTo(7);
    }
}

