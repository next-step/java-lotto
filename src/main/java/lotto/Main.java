package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int money = InputView.getPurchaseMoney();
        Lottos lottos = new LottoShop(money, new Lottos(Collections.emptyList())).sell();
        ResultView.showLottos(lottos);

        Lotto lastWinningLotto = Lotto.from(InputView.getLastWinningLotto());
        LottoNumber bonusNumber = new LottoNumber(InputView.getBonusNumber());
        WinningLotto winningLotto = new WinningLotto(lastWinningLotto, bonusNumber);
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        ResultView.showResult(lottoResult);
    }
}
