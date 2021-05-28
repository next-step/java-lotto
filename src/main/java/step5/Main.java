package step5;

import step5.lotto.Lotto;
import step5.lotto.LottoCount;
import step5.lotto.LottoNumber;
import step5.view.InputView;
import step5.view.ResultView;
import step5.winning.WinningNumbers;
import step5.winning.WinningStatistics;

public class Main {
    public static void main(String[] args) {
        LottoCount lottoCount = new LottoCount(InputView.inputPurchasePrice());
        InputView.printPurchasePrice(lottoCount);
        Lotto lotto = new Lotto(lottoCount);
        ResultView.printLotto(lotto.getLottoTickets());
        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());
        WinningStatistics winningStatistics = new WinningStatistics(lotto, winningNumbers, lottoCount, bonusNumber);
        ResultView.printStatistics(winningStatistics);
    }
}
