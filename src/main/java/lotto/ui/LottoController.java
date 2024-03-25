package lotto.ui;

import lotto.ui.LottoShop;

public class LottoController {

    private final LottoShop lottoShop;

    public LottoController(LottoShop lottoShop) {
        this.lottoShop = lottoShop;
    }

    public void startLotto() {
        lottoShop.enter();
    }
}
