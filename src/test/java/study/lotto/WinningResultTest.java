package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @DisplayName("일치 개수가 주어졌을때 개수 증가 확인")
    @Test
    void WinningLottoTest() {
        WinningResult winningResult = new WinningResult();
        winningResult.addPrize(2);
        winningResult.addPrize(3);
        winningResult.addPrize(3);
        winningResult.addPrize(5);
        winningResult.addPrize(6);
        winningResult.addPrize(6);

        assertThat(winningResult.value().get(WinningPrize.FOURTH)).isEqualTo(2);
        assertThat(winningResult.value().get(WinningPrize.THIRD)).isEqualTo(0);
        assertThat(winningResult.value().get(WinningPrize.SECOND)).isEqualTo(1);
        assertThat(winningResult.value().get(WinningPrize.FIRST)).isEqualTo(2);
    }

    @DisplayName("총 상금 확인")
    @Test
    void WinningLottoPrizeTest() {
        WinningResult winningResult = new WinningResult();
        winningResult.addPrize(2);
        winningResult.addPrize(3);
        winningResult.addPrize(3);
        winningResult.addPrize(5);
        winningResult.addPrize(6);
        winningResult.addPrize(6);

        BigDecimal totalPrize = WinningPrize.FOURTH.prize();
        totalPrize = totalPrize.add(WinningPrize.FOURTH.prize());
        totalPrize = totalPrize.add(WinningPrize.SECOND.prize());
        totalPrize = totalPrize.add(WinningPrize.FIRST.prize());
        totalPrize = totalPrize.add(WinningPrize.FIRST.prize());

        assertThat(winningResult.totalPrize()).isEqualTo(totalPrize);
    }
}
