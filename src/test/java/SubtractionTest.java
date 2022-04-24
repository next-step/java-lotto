import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionTest {

    @Test
    void 뺄셈() {
        Subtraction subtraction = new Subtraction();
        assertThat(subtraction.subtract(2, 1)).isEqualTo(1);
    }
}