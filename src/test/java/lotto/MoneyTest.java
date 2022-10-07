package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("돈은 음수가 될 수 없다.")
    void create() {
        assertThatThrownBy(() -> new Money(-100))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
