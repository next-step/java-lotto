package lotto;

import lotto.config.Config;
import lotto.controller.LottoController;
import lotto.domain.Lotto;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoController lottoController = Config.lottoController();

        List<Lotto> lottos = lottoController.create();
        lottoController.winning(lottos);
    }
}
