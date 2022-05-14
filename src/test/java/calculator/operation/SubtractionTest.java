package calculator.operation;

import calculator.domain.operation.Subtraction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionTest {

    @Test
    void 뺄셈_계산() {
        assertThat(new Subtraction(3, 4).getResult()).isEqualTo(-1);
    }

}