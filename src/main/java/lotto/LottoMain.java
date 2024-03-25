package lotto;

import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        int amount = InputView.inputAmount();

        LottoStore lottoStore = new LottoStore();
        Lottos lottos = lottoStore.buyAutoLotto(amount);

        ResultView.printResult(lottos);

    }
}
