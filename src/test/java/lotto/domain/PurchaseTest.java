package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PurchaseTest {
    @Test
    void 구매_수_계산() {
        int value = 14000;
        assertThat(new Purchase().calculate(value)).isEqualTo(14);
    }

    @Test
    void 구매_금액_하한선() {
        int value = 999;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Purchase().calculate(value))
                .withMessageMatching("구매 금액은 1000원 이상이어야 합니다.");
    }
}
