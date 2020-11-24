package lotto;

import lotto.controller.RoundController;
import lotto.domain.LottoConstraint;
import lotto.service.AutoPickService;
import lotto.service.LottoPrizePackager;
import lotto.service.LottoService;
import lotto.service.RoundService;

public class LottoApplication {
    private static RoundController roundController;

    public static void main(String[] args) {
        setUpDependency();
        roundController.buyView();
        roundController.checkWinningView();
        roundController.reportView();
    }

    private static void setUpDependency() {
        LottoService lottoService = new LottoService(1000, new LottoConstraint(6, 45), new LottoPrizePackager());
        AutoPickService autoPickService = new AutoPickService(lottoService);
        RoundService roundService = new RoundService(autoPickService, lottoService);
        roundController = new RoundController(roundService, lottoService);
    }
}
