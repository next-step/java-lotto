package lotto;

import lotto.domain.LottoStore;

public final class LottoApplication {

    public static void main(String[] args) {
        LottoStore noahStore = new LottoStore();
        LottoController lottoController = new LottoController(noahStore);
        lottoController.start();
    }
}
