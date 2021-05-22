package lotto;

import lotto.presentation.LottoInput;
import lotto.presentation.LottoOutput;
import lotto.presentation.LottoStore;

public class LottoApplication {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore(new LottoInput(), new LottoOutput());
        lottoStore.trade();
    }
}
