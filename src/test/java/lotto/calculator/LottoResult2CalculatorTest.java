package lotto.calculator;

import lotto.game.LottoMachine;
import lotto.strategy.FixedLottoNumberStrategy;
import lotto.ticket.LottoTicket;
import lotto.winningnumber.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResult2CalculatorTest {

    @DisplayName("1000원으로 로또 게임 1장을 사서 당첨 결과를 확인 할 수 있다.")
    @Test
    void calculateResult() {
        LottoMachine lottoMachine = new LottoMachine(new FixedLottoNumberStrategy(List.of(1, 2, 3, 4, 5, 6)));
        WinningNumber winningNumber = WinningNumber.from(List.of(1, 2, 3, 4, 5, 7));
        List<LottoTicket> lottoTickets = lottoMachine.generateTickets(1000);
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(lottoTickets, winningNumber);

        Map<Integer, Integer> result = lottoResultCalculator.calculateResult();

        assertThat(result).containsEntry(5, 1);
    }
}
