package step1_caculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step1_caculator.domain.Operation;

public class OperationTest {
    @Test
    void plus() {
        Operation sut = new Operation(10);
        Assertions.assertThat(sut.plus(2)).isEqualTo(12);
    }

    @Test
    void minus() {
        Operation sut = new Operation(10);
        Assertions.assertThat(sut.minus(2)).isEqualTo(8);
    }

    @Test
    void divide() {
        Operation sut = new Operation(10);
        Assertions.assertThat(sut.divide(2)).isEqualTo(5);
    }

    @Test
    void multiple() {
        Operation sut = new Operation(10);
        Assertions.assertThat(sut.multiple(2)).isEqualTo(20);
    }
}
