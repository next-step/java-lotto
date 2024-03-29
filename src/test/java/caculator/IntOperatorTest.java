package caculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import caculator.domain.IntOperator;

public class IntOperatorTest {
    @Test
    void plus() {
        IntOperator sut = IntOperator.PLUS;
        Assertions.assertThat(sut.calculate(10, 2)).isEqualTo(12);
    }

    @Test
    void minus() {
        IntOperator sut = IntOperator.MINUS;
        Assertions.assertThat(sut.calculate(10, 2)).isEqualTo(8);
    }

    @Test
    void divide() {
        IntOperator sut = IntOperator.DIVIDE;
        Assertions.assertThat(sut.calculate(10, 2)).isEqualTo(5);
    }

    @Test
    void multiple() {
        IntOperator sut = IntOperator.MULTIPLE;
        Assertions.assertThat(sut.calculate(10, 2)).isEqualTo(20);
    }
}
