package calculator.operation;

import calculator.domain.operation.Addition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AdditionTest {

    @Test
    void 덧셈_계산() {
        Assertions.assertThat(new Addition(3, 4).getResult()).isEqualTo(7);
    }

}