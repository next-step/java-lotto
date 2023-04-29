package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {

    public static void main(String[] args) {
        PurchasedAmount purchasedAmount = getPurchasedAmount();
        LottoTickets maunualLottoTickets = getManualLottoTickets(purchasedAmount);
        LottoTickets autoLottoTickets = issueLottoTickets(purchasedAmount);
        LottoTickets mergedLottoTickets = mergeLottoTickets(maunualLottoTickets, autoLottoTickets);
        WinnerNumbers winnerNumbers = getWinnerNumbers();
        showCalculatedWinnerStatistics(mergedLottoTickets, winnerNumbers);
    }

    private static PurchasedAmount getPurchasedAmount() {
        return new PurchasedAmount(InputView.showPaymentConsole(), InputView.showManualLottoCountConsole());
    }

    private static LottoTickets getManualLottoTickets(PurchasedAmount purchasedAmount) {
        List<List<Integer>> manualNumbersList
                = InputView.showManualLottoConsole(purchasedAmount.getAvailableManualLottoCount());
        List<LottoNumbers> manualLottos = manualNumbersList.stream()
                .map(LottoNumbers::ofTypeIntegerList)
                .collect(Collectors.toUnmodifiableList());
        return new LottoTickets(manualLottos);
    }

    private static LottoTickets issueLottoTickets(PurchasedAmount purchasedAmount) {
        return LottoTickets.issue(purchasedAmount);
    }

    private static LottoTickets mergeLottoTickets(LottoTickets maunualLottoTickets, LottoTickets autoLottoTickets) {
        ResultView.showAvailableLottoCount(maunualLottoTickets, autoLottoTickets);
        LottoTickets mergedLottoTickets = maunualLottoTickets.merge(autoLottoTickets);
        ResultView.showIssuedLottoTickets(mergedLottoTickets);
        return mergedLottoTickets;
    }

    private static WinnerNumbers getWinnerNumbers() {
        LottoNumbers winnerLottoNumbers = getWinnerLottoNumbers();
        LottoNumber bonusBall = getBonusBall();
        return new WinnerNumbers(winnerLottoNumbers, bonusBall);
    }

    private static LottoNumbers getWinnerLottoNumbers() {
        return LottoNumbers.ofTypeIntegerList(InputView.showLastWeekWinnerNumbersConsole());
    }

    private static LottoNumber getBonusBall() {
        return new LottoNumber(InputView.showBonusBallConsole());
    }

    private static void showCalculatedWinnerStatistics(LottoTickets lottoTickets, WinnerNumbers winnerNumbers) {
        WinnerStatistics winnerStatistics = winnerNumbers.getWinnerStatistics(lottoTickets);
        ResultView.showResult(winnerStatistics);
    }

}