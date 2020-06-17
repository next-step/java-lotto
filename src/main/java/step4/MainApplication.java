package step4;

import step4.domain.LottoGame;
import step4.domain.PurchaseInfo;
import step4.domain.lotto.Lotto;
import step4.domain.lotto.WinningLotto;
import step4.view.InputView;

import java.util.List;

public class MainApplication {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        String payMoney = InputView.inputPayMoney();
        String countForSelf = InputView.inputCountForSelf();
        PurchaseInfo purchaseInfo = new PurchaseInfo(payMoney, countForSelf, LOTTO_PRICE);

        List<Lotto> selfChosenLottos = InputView.inputChooseNumbersForSelf(purchaseInfo);
        LottoGame lottoGame = LottoGame.create(purchaseInfo, selfChosenLottos);

        // get Wining Number
        String winingNumber = InputView.inputWiningNumber();
        String bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = WinningLotto.of(winingNumber, bonusNumber);
        // matching numbers
        lottoGame.matchingWinningNumbers(winningLotto);
        // total result
        lottoGame.totalResult();
    }

}
