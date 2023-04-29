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
        WinningLotto winningLotto = getWinningLotto();
        showCalculatedWinningStatistics(mergedLottoTickets, winningLotto);
    }

    private static PurchasedAmount getPurchasedAmount() {
        return new PurchasedAmount(InputView.showPaymentConsole(), InputView.showManualLottoCountConsole());
    }

    private static LottoTickets getManualLottoTickets(PurchasedAmount purchasedAmount) {
        List<List<Integer>> manualNumbersList
                = InputView.showManualLottoConsole(purchasedAmount.getAvailableManualLottoCount());
        List<Lotto> manualLottos = manualNumbersList.stream()
                .map(Lotto::ofTypeIntegerList)
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

    private static WinningLotto getWinningLotto() {
        Lotto lastWeekWinningLotto = getLastWeekWinningLotto();
        LottoNumber bonusBall = getBonusBall();
        return new WinningLotto(lastWeekWinningLotto, bonusBall);
    }

    private static Lotto getLastWeekWinningLotto() {
        return Lotto.ofTypeIntegerList(InputView.showLastWeekWinningNumbersConsole());
    }

    private static LottoNumber getBonusBall() {
        return new LottoNumber(InputView.showBonusBallConsole());
    }

    private static void showCalculatedWinningStatistics(LottoTickets lottoTickets, WinningLotto winningLotto) {
        WinningStatistics winningStatistics = winningLotto.getWinningStatistics(lottoTickets);
        ResultView.showResult(winningStatistics);
    }

}