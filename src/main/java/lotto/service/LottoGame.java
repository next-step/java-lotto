package lotto.service;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    private int payLotto;

    public LottoGame(int payLotto) {
        this.payLotto = payLotto;
    }

    public void start() {
        Lottos lottos = new Lottos(payLotto, new NumbersGenerator());
        ResultView.printLottoNumber(lottos);
        Lotto winningLotto = new Lotto(new NumbersSelector(InputView.enterLastNumber()));
        Prize prize = new Prize(lottos, winningLotto);
        Stats stats = new Stats(prize);
        ResultView.printLottoResult(prize);
        ResultView.printLottoYield(stats, payLotto);
    }
}
