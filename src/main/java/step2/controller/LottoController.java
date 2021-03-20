package step2.controller;

import step2.service.LottoService;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void runAutoLotto() {
        lottoService.buyAutoLotto();
    }
}
