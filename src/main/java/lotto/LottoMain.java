package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLottoTicket;
import lotto.view.LottoConsoleView;

import java.util.Arrays;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        LottoConsoleView lottoConsoleView = new LottoConsoleView();

        LottoMachine lottoMachine = buyLottos(lottoConsoleView);

        showPurchaseResult(lottoMachine, lottoConsoleView);

        inputWinnerLottoNumber(lottoConsoleView, lottoMachine);

        showStatistics(lottoConsoleView, lottoMachine);
    }

    private static LottoMachine buyLottos(LottoConsoleView lottoConsoleView) {

        int buyPrice = lottoConsoleView.inputBuyLottoPrice();

        int manualPurchaseCount = lottoConsoleView.inputManualPurchaseLotto();

        List<String> manualPurchaseLottoTickets = lottoConsoleView.inputManualPurchaseLottos(manualPurchaseCount);

        LottoMachine lottoMachine = new LottoMachine(buyPrice, manualPurchaseLottoTickets, manualPurchaseCount);

        return lottoMachine;
    }

    private static void showPurchaseResult(LottoMachine lottoMachine, LottoConsoleView lottoConsoleView) {

        int manualPurchaseCount = lottoMachine.getManualPurchaseCount();
        lottoConsoleView.showLottoCount(manualPurchaseCount, lottoMachine.lottoTotalCount() - manualPurchaseCount);

        lottoMachine.getLottoTickets().stream()
                .forEach(lottoTicket -> lottoConsoleView.showLottoNumber(lottoTicket.getLottoNumbers()));

        System.out.println();
    }


    private static void inputWinnerLottoNumber(LottoConsoleView lottoConsoleView, LottoMachine lottoMachine) {
        String winningNumber = lottoConsoleView.inputWinningNumber();
        int bonusNumber = lottoConsoleView.inputBonusNumber();

        lottoMachine.saveWinningNumber(new WinningLottoTicket(new LottoTicket(winningNumber), bonusNumber));
    }

    private static void showStatistics(LottoConsoleView lottoConsoleView, LottoMachine lottoMachine) {
        lottoConsoleView.showBeforeStatistics();

        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.NOTTING_PLACE)
                .forEach(
                        lottoRank -> lottoConsoleView.showMatch(lottoRank, lottoMachine.lottoRankMatchCount(lottoRank))
                );

        lottoConsoleView.showTotol(lottoMachine.getAggregationOfReturns());
    }


}
