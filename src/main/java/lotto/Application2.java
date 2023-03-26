package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Application2 {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        LottoGame lottoGame = new LottoGame();
        ResultView resultView = new ResultView();

        long purchaseAmount = inputView.purchaseAmount();
        int manualPurchaseCount = inputView.manualPurchaseCount();
        int autoPurchaseCount = lottoGame.getAutoPurchaseCount(purchaseAmount, manualPurchaseCount);
        String[] manualLottos = inputView.inputManualLotto(manualPurchaseCount);


        // 수동 번호 생성
        List<Lotto2> lotto2s = new ArrayList<>();
        for (int i = 0; i < manualLottos.length; i++) {
            Lotto2 lotto2 = lottoGame.createManualLotto(manualLottos[i]);
            lotto2s.add(lotto2);
        }

        resultView.purchaseLottoCount(manualPurchaseCount, autoPurchaseCount);

        // 자동 번호 생성
        if (autoPurchaseCount > 0) {
            for (int i = 0; i < autoPurchaseCount; i++) {
                Lotto2 lotto2 = lottoGame.createAutoLotto();
                resultView.printToAutoLotto(lotto2);
                lotto2s.add(lotto2);
            }
        }

        UserLotto userLotto = new UserLotto(lotto2s);


        // 지난 주 당첨 번호 입력
        String stringWinningNumbers = inputView.inputWinningNumber();
        Lotto2 winningNumber = lottoGame.createManualLotto(stringWinningNumbers);

        // 보너스 볼 입력
        int bonusNumber = inputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        // 당첨통계
        resultView.printToWinningStatistics2(userLotto, winningLotto, purchaseAmount);
    }
}
