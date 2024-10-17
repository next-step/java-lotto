package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.LottoGame;
import lotto.service.LottoService;
import lotto.strategy.AutoLottoGenerator;
import lotto.strategy.LottoGenerator;
import lotto.view.View;

public class Config {
    public static LottoController lottoController() {
        return new LottoController(view(), lottoService());
    }

    private static View view() {
        return new View();
    }

    private static LottoService lottoService() {
        return new LottoService(lottoGame());
    }

    private static LottoGame lottoGame() {
        return new LottoGame(lottoGenerator());
    }

    private static LottoGenerator lottoGenerator() {
        return new AutoLottoGenerator();
    }
}
