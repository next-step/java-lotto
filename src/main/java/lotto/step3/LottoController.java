package lotto.step3;

import lotto.step3.domain.Lotteries;
import lotto.step3.domain.LottoShop;
import lotto.step3.view.InputView;

public class LottoController {
    public static void main(String[] args) {
        int money = InputView.inputLottoPrice();
        LottoShop lottoShop = new LottoShop();
        Lotteries lotteries = lottoShop.receiveMoney(money);
    }
}
