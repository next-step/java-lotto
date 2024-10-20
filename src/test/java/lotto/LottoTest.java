package lotto;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTest {
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

    @Test
    void 당첨_통계_생성() {
        // given
        List<Integer> equalNumberCountList = List.of(3, 4);

        // when
        LottoStatistics statistics = Lotto.createStatistics(equalNumberCountList);

        // then
        Assertions.assertThat(statistics.getCount(LottoRank.FIRST)).isEqualTo(0);
        Assertions.assertThat(statistics.getCount(LottoRank.SECOND)).isEqualTo(0);
        Assertions.assertThat(statistics.getCount(LottoRank.THIRD)).isEqualTo(1);
        Assertions.assertThat(statistics.getCount(LottoRank.FOURTH)).isEqualTo(1);
    }
}
