package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.strategy.AutomaticStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void main(String[] args) {
        final LottoMachine lottoMachine = new LottoMachine(InputView.purchaseAmount(), new AutomaticStrategy());

        OutputView.printLottoCount(lottoMachine.countNumberOfLottoTickets());
        OutputView.printLottoNumber(lottoMachine.lottoNumbersDto());

        final String winningNumbers = InputView.winningNumbers();
        lottoMachine.conclusionWinningNumbers(winningNumbers);

        OutputView.printWinningStat(lottoMachine.winningStat());
    }
}
