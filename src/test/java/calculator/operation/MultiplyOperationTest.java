package calculator.operation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplyOperationTest {

    @Test
    @DisplayName("1과 2 를 넣으면 2를 반환한다.")
    void multiply() {
        assertThat(new MultiplyOperation().operate(1,2)).isEqualTo(2);
    }

}