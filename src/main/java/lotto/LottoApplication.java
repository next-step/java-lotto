package lotto;

import lotto.domain.*;
import lotto.strategy.LottoGeneratorAutoStrategy;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoApplication {
    public static void main(String[] args) {
        LottoAmount lottoAmount = new LottoAmount(askAmount());
        int lottoCount = lottoAmount.calcLottoCount();
        showLottoCount(lottoCount);

        LottoTicket lottoTicket = new LottoTicket(lottoCount, new LottoGeneratorAutoStrategy());
        showAutoLottoTicket(lottoTicket);

        WinningNumbers winningNumbers = new WinningNumbers(askWinningLottoNumbers(), askBonusNumber());
        LottoWinning winning = lottoTicket.result(winningNumbers);
        printWinning(winning);
        printWinningRate(winning, lottoAmount);
    }
}
