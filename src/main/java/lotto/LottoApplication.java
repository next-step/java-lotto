package lotto;

import lotto.presentation.LottoInput;
import lotto.presentation.LottoOutput;
import lotto.presentation.LottoStore;

public final class LottoApplication {
    public static void main(final String[] args) {
        final LottoStore lottoStore = new LottoStore(new LottoInput(), new LottoOutput());
        lottoStore.trade();
    }
}
