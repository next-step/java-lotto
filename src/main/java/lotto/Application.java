package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoAutoGenerator;
import lotto.service.LottoRankingCalculator;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoAutoGenerator(),
            LottoRankingCalculator.getInstance());
        lottoController.run();
    }
}
