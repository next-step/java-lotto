package calculator.calculatableImpl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractorTest {

    @Test
    @DisplayName("앞 수에서 뒷 수를 뺀 값을 반환한다.")
    void run() {
        Subtractor subtractor = new Subtractor();

        int actual = subtractor.run(2, 1);

        assertThat(actual).isEqualTo(1);
    }
}
