package step2.controller;

import step2.domain.Lottos;
import step2.domain.WinningResult;
import step2.service.LottoService;

public class LottoMachine {

    private LottoService lottoService;

    private LottoMachine() {
        this.lottoService = new LottoService();
    }

    public static LottoMachine create() {
        return new LottoMachine();
    }

    public Lottos purchase(int price) {
        return lottoService.purchase(price);
    }

    public WinningResult winningResult(Lottos purchasedLottos, String winningNumbers) {
        return lottoService.winningResult(purchasedLottos, winningNumbers);
    }
}
