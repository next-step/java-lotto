package calculator.calculatableImpl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplierTest {

    @Test
    @DisplayName("두 수를 곱한 값을 반환한다.")
    void run() {
        Multiplier multiplier = new Multiplier();

        int actual = multiplier.run(2, 3);

        assertThat(actual).isEqualTo(6);
    }
}
