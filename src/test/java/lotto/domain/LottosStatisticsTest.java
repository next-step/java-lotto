package lotto.domain;

import lotto.domain.data.Lotto;
import lotto.domain.data.LottoRank;
import lotto.domain.data.PriceLotto;
import lotto.domain.data.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosStatisticsTest {
    private final WinningLotto winningLotto = new WinningLotto(LottoNumberPool.get(1,2,3,4,5,6), LottoNumberPool.get(7));
    private final List<Lotto> Lottos = List.of(
            Lotto.of(LottoNumberPool.get(1, 2, 3, 4, 5, 8)), // 5개 일치, 1500000원
            Lotto.of(LottoNumberPool.get(1, 2, 3, 9, 10, 8)), // 3개 일치, 5000원
            Lotto.of(LottoNumberPool.get(7, 8, 9, 12, 10, 11)), // 0개 일치,
            Lotto.of(LottoNumberPool.get(1, 10, 3, 9, 5, 8)), // 3개 일치, 5000원
            Lotto.of(LottoNumberPool.get(1, 2, 3, 4, 5, 7))); // 5개 일치 & 보너스 일치, 30000000원

    private final int buyMoney = Lottos.size() * 1000;

    private final LottosStatistics statistics =
            new LottosStatistics(Lottos, PriceLotto.of(buyMoney), winningLotto);

    @DisplayName("로또들에 대한 각 당첨된 등수별 개수를 가져올 수 있다.")
    @Test
    public void getCountTest() {
        int countRank1 = statistics.getWinningCount(LottoRank.RANK1);
        int countRank2 = statistics.getWinningCount(LottoRank.RANK2);
        int countRank3 = statistics.getWinningCount(LottoRank.RANK3);
        int countRank4 = statistics.getWinningCount(LottoRank.RANK4);
        int countRank5 = statistics.getWinningCount(LottoRank.RANK5);

        assertThat(countRank1).isEqualTo(0);
        assertThat(countRank2).isEqualTo(1);
        assertThat(countRank3).isEqualTo(1);
        assertThat(countRank4).isEqualTo(0);
        assertThat(countRank5).isEqualTo(2);
    }

    @DisplayName("수익률(총당첨금 / 구입금액) 을 구한다.")
    @Test
    void getRateOfReturnAmount() {
        BigDecimal totalAmount =  BigDecimal.ZERO
                .add(BigDecimal.valueOf(30000000))
                .add(BigDecimal.valueOf(5000 * 2))
                .add(BigDecimal.valueOf(1500000));

        assertThat(statistics.getRateOfReturnAmount())
                .isEqualTo(totalAmount.divide(BigDecimal.valueOf(buyMoney), 2, RoundingMode.HALF_UP).floatValue());
    }
}
