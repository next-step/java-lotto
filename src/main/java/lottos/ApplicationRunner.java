package lottos;


import lottos.controller.LottoConsoleController;
import lottos.domain.Lotto;
import lottos.domain.LottoResult;
import lottos.domain.Lottos;
import lottos.domain.Statistics;
import lottos.view.LottoConsoleInputView;
import lottos.view.LottoConsoleOutputView;

import java.util.List;
import java.util.Scanner;

public class ApplicationRunner {

    private static final int AMOUNT_PER_PIECE = 1000;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LottoConsoleInputView lottoConsoleInputView = new LottoConsoleInputView();
        LottoConsoleOutputView lottoConsoleOutputView = new LottoConsoleOutputView();
        LottoConsoleController lottoConsoleController = new LottoConsoleController();

        int purchaseAmount = lottoConsoleInputView.enterPurchaseAmount(scanner, AMOUNT_PER_PIECE);
        Lottos purchaseLottos = lottoConsoleController.buy(purchaseAmount, AMOUNT_PER_PIECE);
        lottoConsoleOutputView.printLottos(purchaseLottos);

        String lastWeeksNumberText = lottoConsoleInputView.enterLastWeeksNumbers(scanner);
        Lotto lastWeekWiningLotto = lottoConsoleController.lastWeeksWinningLotto(lastWeeksNumberText);
        List<LottoResult> lottoResults = purchaseLottos.match(lastWeekWiningLotto);
        lottoConsoleOutputView.printStatistics(new Statistics(purchaseAmount, lottoResults));

        scanner.close();
    }
}
