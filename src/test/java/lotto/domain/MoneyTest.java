package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("돈은 음수가 될 수 없다.")
    void create() {
        assertThatThrownBy(() -> Money.from(-100))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
