package Lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivideTest {
    @Test
    void 나눗셈_연산() {
        assertThat(new Divide().operate(10, 3)).isEqualTo(3);
    }
}
