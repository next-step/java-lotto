package calculator.operation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinusOperationTest {

    @Test
    @DisplayName("1과 2 를 넣으면 -1을 반환한다.")
    void minus() {
        assertThat(new MinusOperation().operate(1,2)).isEqualTo(-1);
    }

}