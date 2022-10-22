package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlusTest {
    @Test
    void test_calculate() {
        assertThat(new Plus().calculate(1, 2)).isEqualTo(3);
    }
}
