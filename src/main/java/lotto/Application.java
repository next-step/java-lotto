package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.lang.ref.PhantomReference;
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

        // 유저 번호 생성
        List<Lotto> lottos = getUserLotto(manualLottos, lottoGame, manualPurchaseCount,
                autoPurchaseCount, resultView);

        UserLotto userLotto = new UserLotto(lottos);

        WinningLotto winningLotto = getWinningLotto(inputView, lottoGame);

        // 당첨통계
        resultView.printToWinningStatistics2(userLotto, winningLotto, purchaseAmount);
    }

    private static List<Lotto> getUserLotto(String[] manualLottos,
                                            LottoGame lottoGame,
                                            int manualPurchaseCount,
                                            int autoPurchaseCount,
                                            ResultView resultView) {
        List<Lotto> lottos = new ArrayList<>();

        setManualLotto(lottos, manualLottos, lottoGame);

        resultView.purchaseLottoCount(manualPurchaseCount, autoPurchaseCount);

        if (autoPurchaseCount > 0) {
            setAutoLotto(lottos, lottoGame, autoPurchaseCount, resultView);
        }

        return lottos;
    }
    private static void setManualLotto(List<Lotto> lottos,
                                       String[] manualLottos,
                                       LottoGame lottoGame) {
        for (int i = 0; i < manualLottos.length; i++) {
            Lotto lotto = lottoGame.createManualLotto(manualLottos[i]);
            lottos.add(lotto);
        }
    }
    private static void setAutoLotto(List<Lotto> lottos,
                                     LottoGame lottoGame,
                                     int autoPurchaseCount,
                                     ResultView resultView) {
        for (int i = 0; i < autoPurchaseCount; i++) {
            Lotto lotto = lottoGame.createAutoLotto();
            resultView.printToAutoLotto(lotto);
            lottos.add(lotto);
        }
    }

    private static WinningLotto getWinningLotto(InputView inputView, LottoGame lottoGame) {
        String stringWinningNumbers = inputView.inputWinningNumber();
        Lotto winningNumber = lottoGame.createManualLotto(stringWinningNumbers);
        int bonusNumber = inputView.inputBonusNumber();

        return new WinningLotto(winningNumber, bonusNumber);
    }
}
