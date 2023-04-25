package calculator.operations;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinusTest {
    @Test
    void minus() {
        // given
        Minus minus = new Minus();

        //when
        int result = minus.apply(-1, 3);

        //then
        assertThat(result).isEqualTo(-4);
    }
}