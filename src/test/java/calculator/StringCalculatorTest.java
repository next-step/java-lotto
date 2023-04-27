package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {


    private StringCalculator stringCalculator;

    @BeforeEach
    public void beforeEach() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void isNullOrEmpty() {
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.isNullOrEmpty(null));
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.isNullOrEmpty(""));
    }

    @Test
    public void split() {
        assertThat(stringCalculator.split("1 + 2 / 3").size()).isEqualTo(5);
        assertThat(stringCalculator.split("1 + 2").size()).isEqualTo(3);
    }
}
