package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinusTest {
    @Test
    void test_calculate() {
        assertThat(new Minus().calculate(new Number(1), new Number(2))).isEqualTo(new Number(-1));
    }
}
