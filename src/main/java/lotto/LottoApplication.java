package lotto;

import lotto.controller.PriceController;
import lotto.controller.WinningInfoController;
import lotto.domain.Lotto;
import lotto.domain.Tickets;
import lotto.domain.WinningInfo;
import lotto.view.ErrorView;
import lotto.view.RequestView;

public class LottoApplication {

    private static final ErrorView errorView = new ErrorView();
    private static final RequestView requestView = new RequestView();

    private static final PriceController priceController = new PriceController(
        errorView, requestView
    );
    private static final WinningInfoController winningInfoController = new WinningInfoController(
        requestView, errorView
    );

    public static void main(String[] args) {
        Tickets tickets = priceController.getPriceAndGenerateTickets();
        WinningInfo winningInfo = winningInfoController.requestWinningNumberAndBonus();
        Lotto lotto = new Lotto(winningInfo, tickets);
        priceController.statisticsTotal(lotto);
    }

}
