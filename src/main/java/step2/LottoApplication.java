package step2;


import step2.controller.LottoController;
import step2.domain.Lotto;
import step2.domain.LottoGame;
import step2.service.LottoPrizeService;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        LottoController controller = new LottoController(new InputView(), new OutputView(), new LottoPrizeService());
        controller.game();
    }

}
