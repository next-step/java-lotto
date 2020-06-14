package step4;

import step4.domain.LottoGame;
import step4.domain.Money;
import step4.domain.lotto.WinningLotto;
import step4.view.InputView;

public class MainApplication {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        Money money = new Money(InputView.inputPayMoney(), LOTTO_PRICE);
        LottoGame lottoGame = new LottoGame(money.getBoughtLottoCount());
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
