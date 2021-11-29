package lotto.controller;

import lotto.Wallet;
import lotto.WinLotto;
import lotto.view.LottoResultInputView;
import lotto.view.ManualCountInputView;
import lotto.view.MoneyInputView;
import lotto.view.ResultView;

public class Controller {
    public static void run() {
        MoneyInputView moneyInputView = new MoneyInputView();

        moneyInputView.setMoney();
        Wallet wallet = new Wallet(moneyInputView.getMoney());


        ManualCountInputView manualCountInputView = new ManualCountInputView();
        manualCountInputView.setManualLottoCount();
        manualCountInputView.buyLotto(wallet);

        manualCountInputView.showLottos(wallet.getLottos());

        LottoResultInputView lottoResultInputView = new LottoResultInputView();
        lottoResultInputView.setWinNumbers();
        lottoResultInputView.setBonusNumber();

        WinLotto winLotto = new WinLotto(lottoResultInputView.getWinNumbers(), lottoResultInputView.getBonusNumber());

        ResultView resultView = new ResultView(wallet.lottoResult(winLotto));
        resultView.showResult();
    }
}
