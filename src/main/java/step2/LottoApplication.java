package step2;

import step2.domain.*;
import step2.domain.impl.AutoProvider;
import step2.domain.impl.ManualProvider;
import step2.view.InputView;
import step2.view.OutPutView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutPutView outPutView = new OutPutView();

        int purchaseAmount = inputView.askPurchaseAmount();
        PurchaseMoney purchaseMoney = new PurchaseMoney(purchaseAmount);

        PurchaseCount manualCount = new PurchaseCount(inputView.askManualCount());
        List<String> manualNumbers = inputView.askManualNumbers(manualCount);

        ManualProvider manualProvider = new ManualProvider(manualCount, manualNumbers);
        AutoProvider autoProvider = new AutoProvider();

        List<Lotto> manualLottos = manualProvider.generate();
        ChangeMoney changeMoney = purchaseMoney.buyManual(manualLottos.size());
        List<Lotto> autoLottos = autoProvider.generate(changeMoney);

        List<Lotto> merge = Stream.concat(manualLottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());

        PurchaseList purchaseList = new PurchaseList(merge);

        outPutView.showPurchaseCount(manualCount.getValue(), changeMoney.getRemainCount().getValue());
        outPutView.show(purchaseList.toString());

        String winnerInput = inputView.askWinnerInput();
        String bonusInput = inputView.askBonusInput();
        WinningLotto winningLotto = new WinningLotto(winnerInput, bonusInput);
        inputView.close();

        LottoGame lottoGame = new LottoGame(purchaseList, winningLotto);
        GameResult gameResult = lottoGame.calculateResult();
        ReturnRate returnRate = gameResult.calculateReturnRate(purchaseMoney);

        outPutView.showResultLine();
        outPutView.showGameResult(gameResult.getResult());
        outPutView.showReturnRate(returnRate.getValue(), returnRate.isProfitable());
        outPutView.showEnd();

    }
}
