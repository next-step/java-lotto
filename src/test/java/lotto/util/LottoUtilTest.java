package lotto.util;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoUtilTest {
    @Test
    void 구매_장수를_계산한다(){
        int 구매금액 = 14000;
        int 구매장수 = LottoUtil.calculateLottoQuantity(구매금액);
        assertThat(구매장수).isEqualTo(14);
    }
}