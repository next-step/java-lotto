package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }


    @Test
    void add_null_or_empty() {
        assertThat(stringCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(stringCalculator.splitAndSum("")).isEqualTo(0);
    }

}
