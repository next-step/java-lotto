package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoView;

public class LottoGameApplication {

    public static void main(String[] args) {
        LottoView lottoView = new LottoView();
        new LottoController(lottoView).run();
    }

}
