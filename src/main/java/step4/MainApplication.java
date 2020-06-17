package step4;

import step4.domain.LottoGame;
import step4.domain.PurchaseInfo;
import step4.domain.lotto.WinningLotto;
import step4.view.InputView;

public class MainApplication {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        PurchaseInfo purchaseInfo = new PurchaseInfo(InputView.inputPayMoney(), LOTTO_PRICE);
        LottoGame lottoGame = new LottoGame(purchaseInfo.getBoughtLottoCount());
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
