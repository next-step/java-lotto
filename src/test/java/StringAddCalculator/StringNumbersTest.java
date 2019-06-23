package StringAddCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringNumbersTest {

    @Test
    @DisplayName("숫자들의 총 합계")
    public void sum() {
        String[] numbers = {"1", "2", "20"};
        StringNumbers stringNumbers = new StringNumbers(numbers);
        StringNumber number = stringNumbers.sum();
        assertThat(number).isEqualTo(new StringNumber("23"));
    }
}
