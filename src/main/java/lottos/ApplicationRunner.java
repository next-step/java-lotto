package lottos;


import lottos.controller.LottoConsoleController;
import lottos.domain.LottoGameStatistics;
import lottos.domain.LottoResult;
import lottos.domain.Lottos;
import lottos.domain.WinningLotto;
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
        String bonusNumberText = lottoConsoleInputView.enterBonusBall();

        WinningLotto lastWeekWiningLotto = lottoConsoleController.lastWeeksWinningLotto(lastWeeksNumbersText, bonusNumberText);
        List<LottoResult> lottoResults = lastWeekWiningLotto.match(purchaseLottos);
        lottoConsoleOutputView.printStatistics(new LottoGameStatistics(purchaseAmount, lottoResults));

        scanner.close();
    }
}
