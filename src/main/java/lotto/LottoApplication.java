package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        PurchasedAmount purchasedAmount = getPurchasedAmount();
        LottoTickets lottoTickets = issueLottoTickets(purchasedAmount);
        WinnerNumbers winnerNumbers = getWinnerNumbers();
        showCalculatedWinningStatistics(lottoTickets, winnerNumbers);
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

    private static WinnerNumbers getWinnerNumbers() {
        LottoNumbers winnerNumbers = getWinningNumbers();
        LottoNumber bonusBall = getBonusBall();
        return new WinnerNumbers(winnerNumbers, bonusBall);
    }

    private static LottoNumbers getWinningNumbers() {
        return LottoNumbers.ofTypeIntegerList(InputView.showLastWeekWinningNumbersConsole());
    }

    private static LottoNumber getBonusBall() {
        return new LottoNumber(InputView.showBonusBallConsole());
    }

    private static void showCalculatedWinningStatistics(LottoTickets lottoTickets, WinnerNumbers winnerNumbers) {
        WinnerStatistics winnerStatistics = winnerNumbers.getWinnerStatistics(lottoTickets);
        ResultView.showResult(winnerStatistics);
    }

}