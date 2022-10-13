package number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import operator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveIntTest {

    @Test
    @DisplayName("calculate 메소드는 주어진 연산자로 다른 PositiveInt 객체와 계산한다.")
    void calculate() {
        PositiveInt x = new PositiveInt(2);
        PositiveInt y = new PositiveInt(3);
        assertThat(x.calculate(y, Operator.MULTIPLY)).isEqualTo(new PositiveInt(6));
    }
}