package lotto;

import lotto.config.Config;
import lotto.controller.LottoController;

public class LottoApplication {
    public static void main(String[] args) {
        LottoController lottoController = Config.lottoController();
        lottoController.play();
    }
}
