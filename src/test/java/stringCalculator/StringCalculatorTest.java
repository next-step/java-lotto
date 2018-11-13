package stringCalculator;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @Before
    public void setup() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void add_널_또는_빈값() {
        assertThat(0).isEqualTo(stringCalculator.add(null));
        assertThat(0).isEqualTo(stringCalculator.add(""));
    }

    @Test
    public void add_구분자_쉼표() {
        assertThat(1).isEqualTo(stringCalculator.add("1,"));
        assertThat(7).isEqualTo(stringCalculator.add("1,2,4"));
    }
}
