package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;

public class LottoGameController {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.requestMoney());
        LottoNumbers buy = lottoGame.buy();
    }
}
