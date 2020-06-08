package lotto.domain.util;

import lotto.util.LottoUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoUtilTest {

    @Test
    void 구매장수를_계산한다() {
        int purchaseAmount = 14000;
        assertThat(LottoUtil.calculateLottoQuantity(purchaseAmount)).isEqualTo(14);
    }

}