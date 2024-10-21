package lotto;

import lotto.domain.Lotteries;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LotteriesTest {
    @Test
    void 구매금액에_맞게_로또번호_리스트_생성() {
        // given
        int purchaseAmount = 14000;

        // when
        Lotteries lottoList = Lotteries.purchase(purchaseAmount);

        // then
        Assertions.assertThat(lottoList.size()).isEqualTo(14);
    }

    @Test
    void 구매금액이_1000_보다_낮으면_예외_발생() {
        // given
        int purchaseAmount = 999;

        // when, then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Lotteries.purchase(purchaseAmount))
                .withMessage("구입금액은 1000 이상이어야 합니다");
    }
}
