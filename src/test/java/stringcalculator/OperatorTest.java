package stringcalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    void noOperator() {
        Assertions.assertThatThrownBy(() -> Operator.findOperator("x"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사용할수 없는 연산자입니다.");
    }
}