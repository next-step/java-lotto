package step5;

import step5.lotto.Lotto;
import step5.view.InputView;
import step5.view.ResultView;
import step5.winning.WinningNumbers;
import step5.winning.WinningStatistics;

public class Main {
    public static void main(String[] args) {
        Lotto lotto = new Lotto(InputView.inputPurchasePrice(), InputView.inputLottoManualCount());
        InputView.inputLottoManualNumbers(lotto);
        lotto.addAutoLottoTicket();

        ResultView.printPurchaseResult(lotto.getLottoCount());
        ResultView.printLotto(lotto.getLottoTickets());

        String inputWinningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers, bonusNumber);

        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.calculateWinningResult(lotto.getLottoTickets(), winningNumbers);
        winningStatistics.calculateYield(lotto.getPurchasePrice());
        ResultView.printStatistics(winningStatistics);
    }
}
