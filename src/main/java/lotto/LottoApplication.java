package lotto;

import lotto.application.LottoService;
import lotto.controller.LottoShop;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop(new LottoService(new InputView(), new ResultView()));
        lottoShop.purchase();
    }
}
