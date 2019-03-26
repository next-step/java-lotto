package lotto;

import lotto.web.LottoController;
import lotto.web.LottoService;

public class WebMain {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        LottoController racingGameController = new LottoController(lottoService);

        racingGameController.start(8080);
    }
}
