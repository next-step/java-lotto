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
        LottoNumber bonus = InputView.inputBonusNumber();

        Lotto winningLotto = LottoGenerator.generate(winningNumbers);
        RankResult rankResult = lottoBuyer.checkWinning(winningLotto, bonus);
        ResultView.printWinningMatchCount(rankResult, buyAmount);
    }
}
