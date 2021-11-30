package lotto.controller;

import lotto.Lotto;
import lotto.LottoResult;
import lotto.Wallet;
import lotto.WinLotto;
import lotto.view.LottoResultInputView;
import lotto.view.ManualCountInputView;
import lotto.view.MoneyInputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoSimulator {
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

        ResultView resultView = new ResultView(lottoResult(wallet.getLottos(), winLotto));
        resultView.showResult();
    }

    public static LottoResult lottoResult(List<Lotto> lottos, WinLotto winLotto) {
        return new LottoResult(lottos, winLotto);
    }
}
