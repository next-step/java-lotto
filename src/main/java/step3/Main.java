package step3;

import step3.lotto.Lotto;
import step3.lotto.LottoCount;
import step3.view.InputView;
import step3.view.ResultView;
import step3.winning.WinningNumbers;
import step3.winning.WinningStatistics;

public class Main {
    public static void main(String[] args) {
        LottoCount lottoCount = new LottoCount(InputView.inputPurchasePrice());
        InputView.printPurchasePrice(lottoCount);
        Lotto lotto = new Lotto(lottoCount);
        ResultView.printLotto(lotto);
        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers());
        WinningStatistics winningStatistics = new WinningStatistics(lotto, winningNumbers, lottoCount);
        ResultView.printStatistics(winningStatistics);
    }
}
