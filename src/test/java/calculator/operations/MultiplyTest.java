package calculator.operations;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplyTest {
    @Test
    void multiply() {
        // given
        Multiply multiply = new Multiply();

        //when
        int result = multiply.apply(-1, 3);

        //then
        assertThat(result).isEqualTo(-3);
    }
}