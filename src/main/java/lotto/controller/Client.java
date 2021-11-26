package lotto.controller;

import lotto.Money;
import lotto.Wallet;
import lotto.WinLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Client {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.setMoney();
        Wallet wallet = new Wallet(inputView.getMoney());

        inputView.setManualLottoCount();
        inputView.buyLotto(wallet);

        inputView.showLottos(wallet.getLottos());

        inputView.setWinNumbers();
        inputView.setBonusNumber();

        WinLotto winLotto = new WinLotto(inputView.getWinNumbers(), inputView.getBonusNumber());

        ResultView resultView = new ResultView(wallet.lottoResult(winLotto));
        resultView.showResult();
    }
}
