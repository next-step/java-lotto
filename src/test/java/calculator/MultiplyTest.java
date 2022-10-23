package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplyTest {
    @Test
    void test_calculate() {
        assertThat(new Multiply().calculate(new Number(3), new Number(2))).isEqualTo(new Number(6));
    }
}
