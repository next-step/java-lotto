package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {
    @Test
    @DisplayName("로또 1장의 금액보다 낮은 금액은 받을 수 없다.")
    void shouldRejectAmountLessThanLottoPrice() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Money(999));
    }
}
