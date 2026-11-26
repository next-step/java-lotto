package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        Lottos lottos = new Lottos(InputView.readPurchaseAmount());
        ResultView.viewLottos(lottos);

        Lotto winningLotto = new Lotto(InputView.readWinningNumbers());
        ResultView.viewResult(new LottoResult(lottos, winningLotto));
    }
}
