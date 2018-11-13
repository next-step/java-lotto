package stringCalculator;

import org.junit.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @Test
    public void add_널_또는_빈값() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(0).isEqualTo(stringCalculator.add(null));
        assertThat(0).isEqualTo(stringCalculator.add(""));
    }
}
