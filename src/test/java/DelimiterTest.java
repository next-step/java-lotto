import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterTest {

    @Test
    public void sumUtilTest() {
        String[] numbers = new String[] {"1", "2", "3"};
        int result = CalculatorUtils.sum(numbers);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void customDelimiterFindTest() {
        String input = "//;\n1;2;3";
        boolean result = CustomDelimiter.find(input);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void customDelimiterSumTest() {
        String input = "//;\n1;2;3";
        CustomDelimiter.find(input);

        int result = CustomDelimiter.sum();

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void defaultDelimiterSum() {
        String input = "1,2:3";
        int result = DefaultDelimiter.sum(input);
        assertThat(result).isEqualTo(6);
    }
}
