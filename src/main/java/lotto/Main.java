package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.service.Shop;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InputView input = new InputView();

        int purchasedAmount = input.inputPurchaseAmount();

        List<Lotto> purchasedLotto = Shop.purchaseLotto(purchasedAmount);

        OutputView.showPurchasedLotto(purchasedLotto);

        WinningLotto winningLotto = new WinningLotto(input.inputWinningNumbers());

        Map<Integer, Integer> gameResult = LottoGame.getGameResult(purchasedLotto, winningLotto);

        OutputView.showResult(gameResult);
        OutputView.showROR(gameResult, purchasedAmount);
    }
}
