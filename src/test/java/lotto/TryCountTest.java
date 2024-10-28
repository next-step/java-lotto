package lotto;

import lotto.domain.TryCount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TryCountTest {


    @Test
    void 금액_개수변환테스트() {
        final int PURCHASE_AMOUNT = 5000;
        final int TRY_COUNT = 5;

        TryCount tryCount = TryCount.initTryCount(PURCHASE_AMOUNT);
        assertThat(tryCount).isEqualTo(new TryCount(TRY_COUNT));
    }


}