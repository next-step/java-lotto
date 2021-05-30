package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.LottoRank;
import study.lotto.domain.WinningResult;


import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @DisplayName("일치 개수가 주어졌을때 개수 증가 확인")
    @Test
    void WinningLottoTest() {
        WinningResult winningResult = new WinningResult();
        winningResult.addPrize(2, true);
        winningResult.addPrize(3, true);
        winningResult.addPrize(3, true);
        winningResult.addPrize(5, true);
        winningResult.addPrize(5, false);
        winningResult.addPrize(6, true);
        winningResult.addPrize(6, true);

        assertThat(winningResult.value().get(LottoRank.FIFTH)).isEqualTo(2);
        assertThat(winningResult.value().get(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(winningResult.value().get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(winningResult.value().get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(winningResult.value().get(LottoRank.FIRST)).isEqualTo(2);
    }

    @DisplayName("총 상금 확인")
    @Test
    void WinningLottoPrizeTest() {
        WinningResult winningResult = new WinningResult();
        winningResult.addPrize(5, false);
        winningResult.addPrize(5, true);

        BigDecimal totalPrize = LottoRank.THIRD.prize();
        totalPrize = totalPrize.add(LottoRank.SECOND.prize());

        assertThat(winningResult.totalPrize()).isEqualTo(totalPrize);
    }
}
