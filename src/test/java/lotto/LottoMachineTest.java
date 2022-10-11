package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    void 로또_고정_구매() {
        // given
        LottoMachine lottoMachine = new LottoMachine(new LottoTestCalculateStrategy());
        // when
        List<List<Lotto>> lottoes = lottoMachine.buyLottoes(null);
        // then
        assertThat(lottoes).hasSize(1);
        assertThat(lottoes.get(0)).hasSize(1);
        assertThat(lottoes.get(0).get(0)).isEqualTo(new Lotto(1));
    }

    @Test
    void 로또_고정_통계() {
        // given
        LottoMachine lottoMachine = new LottoMachine(new LottoTestCalculateStrategy());
        // when
        Statistics statistics = lottoMachine.calculateStatistics(null, null, null);
        // then
        assertThat(statistics.getEarningRate()).isEqualTo(0.0);
        assertThat(statistics.getWinningStats()).containsEntry(WinningPrize.THREE, 1);
    }
}
