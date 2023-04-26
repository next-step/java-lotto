package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTickets;
import lotto.domain.PurchasedAmount;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        PurchasedAmount purchasedAmount = getPurchasedAmount();
        LottoTickets lottoTickets = issueLottoTickets(purchasedAmount);
        LottoNumbers winningNumbers = getWinningNumbers();
        showCalculatedWinningStatistics(lottoTickets, winningNumbers);
    }

    private static PurchasedAmount getPurchasedAmount() {
        PurchasedAmount purchasedAmount = new PurchasedAmount(InputView.showPaymentConsole());
        ResultView.showAvailableLottoCount(purchasedAmount);
        return purchasedAmount;
    }

    private static LottoTickets issueLottoTickets(PurchasedAmount purchasedAmount) {
        LottoTickets lottoTickets = LottoTickets.issue(purchasedAmount);
        ResultView.showIssuedLottoTickets(lottoTickets);
        return lottoTickets;
    }

    private static LottoNumbers getWinningNumbers() {
        return LottoNumbers.ofTypeIntegerList(InputView.showLastWeekWinningNumbersConsole());
    }

    private static void showCalculatedWinningStatistics(LottoTickets lottoTickets, LottoNumbers winningNumbers) {
        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers, lottoTickets);
        winningStatistics.calculate();
        ResultView.showResult(winningStatistics);
    }

}