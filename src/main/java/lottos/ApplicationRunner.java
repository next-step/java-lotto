package lottos;


import lottos.controller.ConsoleInputView;
import lottos.controller.ConsoleOutputView;
import lottos.domain.*;

import java.util.Arrays;
import java.util.List;

public class ApplicationRunner {

    public static void main(String[] args) {

        ConsoleInputView consoleInputView = new ConsoleInputView();
        int purchaseAmount = consoleInputView.buy();

        final int amountPerPiece = 1000;
        final WinningPrizes winningPrizes = new WinningPrizes(Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 2000000000));

        LottoGame lottoGame = new LottoGame(winningPrizes, amountPerPiece);
        Lottos purchaseLottos = lottoGame.start(purchaseAmount);

        ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        consoleOutputView.printLottos(purchaseLottos);

        Lotto lastWeekWiningLotto = new Lotto(consoleInputView.lastWeeksWinningNumbers());
        List<LottoResult> lottoResults = lottoGame.match(lastWeekWiningLotto, purchaseLottos);

        consoleOutputView.printStatistics(new Statistics(purchaseAmount, lottoResults));
    }
}
