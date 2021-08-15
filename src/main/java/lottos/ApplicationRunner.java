package lottos;


import lottos.controller.LottoConsoleController;
import lottos.domain.*;
import lottos.view.LottoConsoleInputView;
import lottos.view.LottoConsoleOutputView;

import java.util.List;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LottoConsoleInputView lottoConsoleInputView = new LottoConsoleInputView(scanner);
        LottoConsoleOutputView lottoConsoleOutputView = new LottoConsoleOutputView();
        LottoConsoleController lottoConsoleController = new LottoConsoleController(new LottoRandomGenerator());

        int purchaseAmount = lottoConsoleInputView.enterPurchaseAmount();
        int manualLottoCount = lottoConsoleInputView.enterManualLottoCount();
        List<String> manualLottoNumberTexts = lottoConsoleInputView.enterManualLotto(manualLottoCount);

        Lottos manualPurchaseLottos = lottoConsoleController.buy(manualLottoNumberTexts);
        Lottos automaticPurchaseLottos = lottoConsoleController.buy(purchaseAmount, manualLottoCount);

        Lottos lottos = manualPurchaseLottos.merge(automaticPurchaseLottos);
        int automaticLottoCount = automaticPurchaseLottos.count();
        lottoConsoleOutputView.printPurchaseCount(manualLottoCount, automaticLottoCount);
        lottoConsoleOutputView.printLottos(lottos);

        String lastWeeksNumbersText = lottoConsoleInputView.enterLastWeeksNumbers();
        String bonusNumberText = lottoConsoleInputView.enterBonusBall();

        WinningLotto lastWeekWiningLotto = lottoConsoleController.lastWeeksWinningLotto(lastWeeksNumbersText, bonusNumberText);
        List<LottoResult> lottoResults = lastWeekWiningLotto.match(lottos);
        lottoConsoleOutputView.printStatistics(new LottoGameStatistics(purchaseAmount, lottoResults));

        scanner.close();
    }
}
