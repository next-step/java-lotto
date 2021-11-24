package lotto.Controller;

import lotto.WinningLotto;
import lotto.Money;
import lotto.Wallet;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Client {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.getMoney();
        Wallet wallet = new Wallet(inputView.money());
        wallet.buyLotto(new Money(1000));
        inputView.showLottos(wallet.getLottos());

        inputView.getWinNumbers();
        inputView.getBonusNumber();
        WinningLotto winningLotto = new WinningLotto(inputView.winNumbers(), inputView.bonusNumber());

        resultView.showStatus(inputView.money(), wallet, winningLotto);
    }
}
