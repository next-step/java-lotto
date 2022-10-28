package lotto;

import lotto.domain.*;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoApplication {
    public static void main(String[] args) {
        LottoAmount lottoAmount = new LottoAmount(askAmount());
        LottoCount lottoCount = new LottoCount(lottoAmount.calcLottoCount());
        LottoCount manualCount = new LottoManualCount(askManualLottoCount()).validateCount(lottoCount);

        LottoTicket lottoTicket = new LottoTicket(lottoCount, askInputManualLottos(manualCount));
        showLottoCount(lottoCount, manualCount);
        showLottoTicket(lottoTicket);

        WinningNumbers winningNumbers = new WinningNumbers(askWinningLottoNumbers(), askBonusNumber());
        LottoWinning winning = lottoTicket.result(winningNumbers);
        printWinning(winning);
        printWinningRate(winning, lottoAmount);
    }
}
