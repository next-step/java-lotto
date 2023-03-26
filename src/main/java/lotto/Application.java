package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        LottoGame lottoGame = new LottoGame();
        ResultView resultView = new ResultView();

        long purchaseAmount = inputView.purchaseAmount();
        int manualPurchaseCount = inputView.manualPurchaseCount();
        int autoPurchaseCount = lottoGame.getAutoPurchaseCount(purchaseAmount, manualPurchaseCount);
        String[] manualLottos = inputView.inputManualLotto(manualPurchaseCount);


        // 수동 번호 생성
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualLottos.length; i++) {
            Lotto lotto = lottoGame.createManualLotto(manualLottos[i]);
            lottos.add(lotto);
        }

        resultView.purchaseLottoCount(manualPurchaseCount, autoPurchaseCount);

        // 자동 번호 생성
        if (autoPurchaseCount > 0) {
            for (int i = 0; i < autoPurchaseCount; i++) {
                Lotto lotto = lottoGame.createAutoLotto();
                resultView.printToAutoLotto(lotto);
                lottos.add(lotto);
            }
        }

        UserLotto userLotto = new UserLotto(lottos);


        // 지난 주 당첨 번호 입력
        String stringWinningNumbers = inputView.inputWinningNumber();
        Lotto winningNumber = lottoGame.createManualLotto(stringWinningNumbers);
        int bonusNumber = inputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        // 당첨통계
        resultView.printToWinningStatistics2(userLotto, winningLotto, purchaseAmount);
    }
}
