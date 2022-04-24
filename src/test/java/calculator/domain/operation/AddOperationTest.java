package calculator.domain.operation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddOperationTest {

    @Test
    @DisplayName("1과 2 를 넣으면 3을 반환한다.")
    void add() {
        assertThat(new AddOperation().operate(1,2)).isEqualTo(3);
    }
}