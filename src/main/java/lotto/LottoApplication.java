package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        Store store = new LottoStore();
        LottoBuyer lottoBuyer = new LottoBuyer(store);

        Money buyAmount = InputView.inputBuyAmount();

        Lottos lottos = lottoBuyer.buyLottos(buyAmount);
        ResultView.printLottos(lottos.toDto());

        String winningNumbers = InputView.inputWinningNumbers();
        LottoNumber bonus = InputView.inputBonusNumber();

        Lotto winningLotto = LottoGenerator.generate(winningNumbers);
        RankResult rankResult = lottoBuyer.checkWinning(new WinningLotto(winningLotto, bonus));
        ResultView.printWinningMatchCount(rankResult.toDto());
        ResultView.printRateOfEarning(rankResult.calculateRateOfEarning(buyAmount));
    }
}
