package lotto;

import lotto.application.LottoService;
import lotto.controller.LottoShop;

public class LottoApplication {
    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop(new LottoService());
        lottoShop.purchase();
    }
}
