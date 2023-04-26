package calculator.operations;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class PlusTest {

    @Test
    void plus() {
        // given
        Plus plus = new Plus();

        //when
        int result = plus.apply(-1, 3);

        //then
        assertThat(result).isEqualTo(2);
    }
}