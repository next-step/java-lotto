package step2;

import step2.domain.*;
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
        int manualCount = inputView.askManualCount();
        PurchaseMoney purchaseMoney = new PurchaseMoney(purchaseAmount, manualCount);

        List<String> manualNumbers = inputView.askManualNumbers(manualCount);

        List<Lotto> manualLottos = purchaseMoney.buyManual(manualNumbers);
        List<Lotto> autoLottos = purchaseMoney.buyAuto();
        outPutView.showPurchaseCount(manualLottos.size(), autoLottos.size());

        List<Lotto> collect = Stream.concat(manualLottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());
        PurchaseList purchaseList = new PurchaseList(collect);
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
