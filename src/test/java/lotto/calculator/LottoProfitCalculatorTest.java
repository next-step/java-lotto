package lotto.calculator;

import lotto.game.LottoMachine;
import lotto.winningnumber.WinningNumber;
import lotto.prize.LottoPrize;
import lotto.result.LottoResult;
import lotto.strategy.FixedLottoNumberStrategy;
import lotto.ticket.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitCalculatorTest {

    @DisplayName("로또의 수익률을 계산할 수 있다.")
    @Test
    void calculateLottoProfit() {
        LottoMachine lottoMachine = new LottoMachine(new FixedLottoNumberStrategy(List.of(1, 2, 3, 4, 5, 6)));
        WinningNumber winningNumber = WinningNumber.from(List.of(1, 2, 3, 4, 5, 7));
        List<LottoTicket> lottoTickets = lottoMachine.generateTickets(1000);

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(lottoTickets, winningNumber);
        Map<LottoResult, Integer> lottoResult = lottoResultCalculator.calculateResult();
        LottoProfitCalculator lottoProfitCalculator = new LottoProfitCalculator(lottoResult, new LottoPrize());

        double result = lottoProfitCalculator.calculateProfitRate(lottoTickets.size());

        assertThat(result).isEqualTo(1500.0);

    }

    @DisplayName("로또의 수익률을 계산할 수 있다.")
    @Test
    void calculateLottoProfit2() {
        LottoMachine lottoMachine = new LottoMachine(new FixedLottoNumberStrategy(List.of(1, 2, 3, 4, 5, 6)));
        WinningNumber winningNumber = WinningNumber.from(List.of(1, 2, 3, 33, 34, 35));
        List<LottoTicket> lottoTickets = lottoMachine.generateTickets(10000);

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(lottoTickets, winningNumber);
        Map<LottoResult, Integer> lottoResult = lottoResultCalculator.calculateResult();
        LottoProfitCalculator lottoProfitCalculator = new LottoProfitCalculator(lottoResult, new LottoPrize());

        double result = lottoProfitCalculator.calculateProfitRate(lottoTickets.size());

        assertThat(result).isEqualTo(5.0);

    }
}
