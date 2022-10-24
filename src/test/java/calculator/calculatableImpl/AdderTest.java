package calculator.calculatableImpl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AdderTest {

    @Test
    @DisplayName("두 수를 더한 값을 반환한다.")
    void run() {
        Adder adder = new Adder();

        int actual = adder.run(1, 2);

        assertThat(actual).isEqualTo(3);
    }
}
