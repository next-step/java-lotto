package lotto.prize;

import lotto.game.LottoMachine;
import lotto.number.LottoBalls;
import lotto.strategy.FixedLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeCounterTest {

    @DisplayName("1000원으로 로또 게임 1장을 사서 당첨 결과를 확인 할 수 있다.")
    @Test
    void countPrize() {
        LottoMachine lottoMachine = new LottoMachine(new FixedLottoNumberStrategy(List.of(1, 2, 3, 4, 5, 6)));
        LottoBalls winningNumber = new LottoBalls(List.of(1, 2, 3, 4, 5, 7));
        List<LottoBalls> lottoTickets = lottoMachine.generateTickets(1000);
        PrizeCounter prizeCounter = new PrizeCounter(lottoTickets, winningNumber);

        PrizeCount result = prizeCounter.countPrize();

        assertThat(result.getResults()).containsEntry(5, 1);
    }

    @DisplayName("로또의 수익률을 계산할 수 있다.")
    @Test
    void calculateProfitRate() {
        LottoMachine lottoMachine = new LottoMachine(new FixedLottoNumberStrategy(List.of(1, 2, 3, 4, 5, 6)));
        LottoBalls winningNumber = new LottoBalls(List.of(1, 2, 3, 33, 34, 35));
        List<LottoBalls> lottoTickets = lottoMachine.generateTickets(10000);

        PrizeCounter prizeCounter = new PrizeCounter(lottoTickets, winningNumber);
        PrizeCount prizeCount = prizeCounter.countPrize();

        double result = prizeCount.calculateProfitRate(lottoTickets.size());

        assertThat(result).isEqualTo(5.0);

    }
}
