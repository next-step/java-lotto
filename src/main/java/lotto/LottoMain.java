package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoGenerator;
import lotto.view.LottoReader;
import lotto.view.LottoWriter;

public class LottoMain {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new LottoReader(),
                new LottoWriter(),
                LottoGenerator.getInstance()
        );

        lottoController.startLotto();
    }
}
