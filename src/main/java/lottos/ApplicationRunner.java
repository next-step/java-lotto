package lottos;


import lottos.controller.LottoConsoleController;
import lottos.domain.Lotto;
import lottos.domain.Result;
import lottos.domain.Statistics;
import lottos.view.LottoConsoleView;

import java.util.List;

public class ApplicationRunner {

    private static final int AMOUNT_PER_PIECE = 1000;

    public static void main(String[] args) {

        LottoConsoleController lottoConsoleController = new LottoConsoleController();

        List<Lotto> purchaseLottos = lottoConsoleController.buy(AMOUNT_PER_PIECE);

        LottoConsoleView lottoConsoleView = new LottoConsoleView();
        lottoConsoleView.printLottos(purchaseLottos);

        Lotto lastWeekWiningLotto = lottoConsoleController.lastWeeksWinningLotto();

        final int purchaseAmount = purchaseLottos.size() * AMOUNT_PER_PIECE;
        List<Result> results = lastWeekWiningLotto.match(purchaseLottos);

        lottoConsoleView.printStatistics(new Statistics(purchaseAmount, results));
    }
}
