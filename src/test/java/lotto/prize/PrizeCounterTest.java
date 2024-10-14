package lotto.prize;

import lotto.game.LottoCount;
import lotto.game.LottoMachine;
import lotto.number.LottoBalls;
import lotto.number.LottoNumber;
import lotto.number.WinningNumbers;
import lotto.strategy.FixedLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeCounterTest {

    @DisplayName("1000원으로 로또 게임 1장을 사서 당첨 결과를 확인 할 수 있다.")
    @Test
    void countPrize() {
        LottoMachine lottoMachine = new LottoMachine(new FixedLottoNumberStrategy(List.of(1, 2, 3, 4, 5, 6)));
        LottoBalls winningNumber = new LottoBalls(List.of(1, 2, 3, 4, 5, 7));
        LottoNumber bonusNumber = new LottoNumber(6);

        List<LottoBalls> lottoTickets = lottoMachine.generateLottoTickets(new ArrayList<>(), new LottoCount(1));
        PrizeCounter prizeCounter = new PrizeCounter(lottoTickets, new WinningNumbers(winningNumber, bonusNumber));

        PrizeCountMap result = prizeCounter.countPrize();

        assertThat(result.getResults()).containsEntry(LottoPrize.SECOND, 1);
    }

}
