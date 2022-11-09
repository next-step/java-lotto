package lotto.controller;

import lotto.application.LottoService;

public class LottoShop {

    private final LottoService lottoService;

    public LottoShop(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void purchase() {
        lottoService.purchase();
    }
}
