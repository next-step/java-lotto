import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @Test
    public void splitString() {
        String str = "1 + 2 * 3 - 1";

        assertThat(StringCalculator.splitString(str))
                .containsExactly("1", "+", "2", "*", "3", "-", "1");
    }

    @Test
    public void calculate() {
        String[] strs = {"1", "+", "2", "*", "3", "-", "1", "/", "2"};

        assertThat(StringCalculator.calculate(strs))
                .isEqualTo(4);
    }





}
