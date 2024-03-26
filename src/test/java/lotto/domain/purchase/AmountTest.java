package lotto.domain.purchase;

import lotto.domain.purchase.Amount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class AmountTest {

    @DisplayName("수량은 음수를 필드로 가질 수 없다.")
    @Test
    void constructor() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Amount(-1));
    }
}
