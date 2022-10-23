package lotto;

import lotto.domain.LottoAmount;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinning;
import lotto.domain.WinningNumbers;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoApplication {
    public static void main(String[] args) {
        LottoAmount lottoAmount = new LottoAmount(askAmount());
        int lottoCount = lottoAmount.calcLottoCount();
        showLottoCount(lottoCount);

        LottoTicket lottoTicket = new LottoTicket(lottoCount);
        showAutoLottoTicket(lottoTicket);

        WinningNumbers winningNumbers = new WinningNumbers(askWinningLottoNumbers(), askBonusNumber());
        LottoWinning winning = lottoTicket.result(winningNumbers);
        printWinning(winning);
        printWinningRate(winning, lottoAmount);
    }
}
