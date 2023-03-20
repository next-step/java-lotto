package lotto;

import lotto.domain.*;
import lotto.view.LottoConsoleView;

import java.util.Arrays;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        LottoConsoleView lottoConsoleView = new LottoConsoleView();

        LottoMachine lottoMachine = buyLottos(lottoConsoleView);

        showPurchaseResult(lottoMachine, lottoConsoleView);

        LottoStatistic lottoStatistic = inputWinnerLottoNumber(lottoConsoleView, lottoMachine);

        showStatistics(lottoConsoleView, lottoStatistic);
    }

    private static LottoMachine buyLottos(LottoConsoleView lottoConsoleView) {

        int buyPrice = lottoConsoleView.inputBuyLottoPrice();

        int manualPurchaseCount = lottoConsoleView.inputManualPurchaseLotto();

        List<String> manualPurchaseLottoTickets = lottoConsoleView.inputManualPurchaseLottos(manualPurchaseCount);

        return new LottoMachine(buyPrice, manualPurchaseLottoTickets, manualPurchaseCount);
    }

    private static void showPurchaseResult(LottoMachine lottoMachine, LottoConsoleView lottoConsoleView) {

        int manualPurchaseCount = lottoMachine.getManualPurchaseCount();
        lottoConsoleView.showLottoCount(manualPurchaseCount, lottoMachine.lottoTotalCount() - manualPurchaseCount);

        lottoMachine.getLottoTickets().stream()
                .forEach(lottoTicket -> lottoConsoleView.showLottoNumber(lottoTicket.getLottoNumbers()));

        System.out.println();
    }


    private static LottoStatistic inputWinnerLottoNumber(LottoConsoleView lottoConsoleView, LottoMachine lottoMachine) {
        String winningNumber = lottoConsoleView.inputWinningNumber();
        int bonusNumber = lottoConsoleView.inputBonusNumber();

        return lottoMachine.initLottoStatistic(new WinningLottoTicket(new LottoTicket(winningNumber), bonusNumber));
    }

    private static void showStatistics(LottoConsoleView lottoConsoleView, LottoStatistic lottoStatistic) {
        lottoConsoleView.showBeforeStatistics();

        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.NOTTING_PLACE)
                .forEach(
                        lottoRank -> lottoConsoleView.showMatch(lottoRank, lottoStatistic.getLottoRankMatchCount(lottoRank))
                );

        lottoConsoleView.showTotol(lottoStatistic.getAggregationOfReturn());
    }


}
