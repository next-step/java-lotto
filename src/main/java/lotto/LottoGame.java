package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    private final LottoBuyer lottoBuyer;

    public LottoGame(LottoBuyer lottoBuyer) {
        this.lottoBuyer = lottoBuyer;
    }

    public void start() {
        Money buyAmount = InputView.inputBuyAmount();
        Lottos lottos = lottoBuyer.buyLottos(buyAmount);
        ResultView.printLottos(lottos);

        String winningNumbers = InputView.inputWinningNumbers();
        Lotto winningLotto = LottoGenerator.generate(winningNumbers);
        Matchs matchs = lottoBuyer.checkWinning(winningLotto);
        ResultView.printWinningMatchCount(matchs, buyAmount);
    }
}
