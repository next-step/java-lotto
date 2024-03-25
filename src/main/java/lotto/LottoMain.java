package lotto;

import lotto.domain.LottoStore;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        int amount = InputView.inputAmount();

        LottoStore lottoStore = new LottoStore();
        Lotto lotto = lottoStore.buyAutoLotto(amount);

        ResultView.printBuyLotto(lotto);

        String[] lastWinningLotto = InputView.inputWinningLotto().split(",");

    }
}
