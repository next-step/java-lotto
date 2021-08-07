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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        LottoConsoleInputView lottoConsoleInputView = new LottoConsoleInputView(scanner);
        LottoConsoleOutputView lottoConsoleOutputView = new LottoConsoleOutputView();
        LottoConsoleController lottoConsoleController = new LottoConsoleController();

        int purchaseAmount = lottoConsoleInputView.enterPurchaseAmount();
        Lottos purchaseLottos = lottoConsoleController.buy(purchaseAmount);
        lottoConsoleOutputView.printPurchaseCount(purchaseLottos);
        lottoConsoleOutputView.printLottos(purchaseLottos);

        String lastWeeksNumbersText = lottoConsoleInputView.enterLastWeeksNumbers();
        Lotto lastWeekWiningLotto = lottoConsoleController.lastWeeksWinningLotto(lastWeeksNumbersText);
        List<LottoResult> lottoResults = purchaseLottos.match(lastWeekWiningLotto);
        lottoConsoleOutputView.printStatistics(new Statistics(purchaseAmount, lottoResults));

        scanner.close();
    }
}
