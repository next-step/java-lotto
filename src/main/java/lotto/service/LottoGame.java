package lotto.service;

import lotto.domain.*;
import lotto.domain.Number;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    private int payLotto;

    public LottoGame(int payLotto) {
        this.payLotto = payLotto;
    }

    public void start() {
        List<Number> lottoLastNumber;
        Number bonusNumber;
        Lottos lottos = new Lottos(new LottoGenerator(payLotto));
        ResultView.printLottoNumber(lottos);

        lottoLastNumber = InputView.enterLastNumber();
        bonusNumber = InputView.enterBonusNumber();

        Lotto lastLottoNumber = new Lotto(lottoLastNumber, bonusNumber);
        Prize prize = new Prize(lottos, lastLottoNumber);
        ResultView.printLottoResult(prize);
        ResultView.printLottoYield(prize, payLotto);
    }
}
