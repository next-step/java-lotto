package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int money = InputView.getPurchaseMoney();
        Lottos lottos = LottoShop.sellLotto(money);
        ResultView.showLottos(lottos);

        Lotto lastWinningLotto = Lotto.from(InputView.getLastWinningLotto());
        LottoResult lottoResult = new LottoResult(lottos, lastWinningLotto);
        ResultView.showResult(lottoResult);
    }
}
