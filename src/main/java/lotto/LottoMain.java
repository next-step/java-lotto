package lotto;

import lotto.domain.LottoStore;
import lotto.view.InputView;

public class LottoMain {

    public static void main(String[] args) {
        int amount = InputView.inputAmount();

        LottoStore lottoStore = new LottoStore();
        lottoStore.buyAutoLotto(amount);



    }
}
