package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivideTest {
    @Test
    void test_calculate() {
        assertThat(new Divide().calculate(3, 2)).isEqualTo(1);
    }
}
