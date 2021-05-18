package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @DisplayName("separator를 통한 String split 테스트")
    @Test
    void split() {
        String separator = ",|:";

        assertThat(StringCalculator.split("", separator)).containsExactly("");
        assertThat(StringCalculator.split("1,2", separator)).containsExactly("1", "2");
        assertThat(StringCalculator.split("1,2,3", separator)).containsExactly("1", "2", "3");
        assertThat(StringCalculator.split("1,2:3", separator)).containsExactly("1", "2", "3");
    }
}
