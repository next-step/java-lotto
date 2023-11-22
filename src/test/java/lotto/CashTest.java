package lotto;

import lotto.domain.Cash;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CashTest {

    @Test
    void 구매_숫자() {
        Cash cash = new Cash(10000);
        int count = cash.count();

        assertThat(count).isEqualTo(10);
    }

    @Test
    void 천원_이하_예외() {
        int cash = 500;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cash(cash));
    }
}