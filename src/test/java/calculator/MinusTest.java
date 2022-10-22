package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinusTest {
    @Test
    void test_calculate() {
        assertThat(new Minus().calculate(1, 2)).isEqualTo(-1);
    }
}
