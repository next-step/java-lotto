package calculator.calculatableImpl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DividerTest {

    @Test
    @DisplayName("앞 수에서 뒷 수를 나눈 값을 반환한다.")
    void run() {
        Divider divider = new Divider();

        int actual = divider.run(6, 3);

        assertThat(actual).isEqualTo(2);
    }
}
