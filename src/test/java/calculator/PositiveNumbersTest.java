package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumbersTest {
    @Test
    void 입력값에서_음수를_포함하고_있으면_예외를_던진다() {
        assertThatThrownBy(() -> new PositiveNumbers(new int[]{1, 2, -1}))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 양수만을_입력으로_받으면_합을_반환한다() {
        assertThat(new PositiveNumbers(new int[] {1, 3, 5}).sum()).isEqualTo(9);
    }
}
