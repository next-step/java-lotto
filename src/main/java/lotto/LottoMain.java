package lotto;

import lotto.controller.LottoController;
import lotto.controller.MoneyController;
import lotto.service.LottoService;

public class LottoMain {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoService());
        MoneyController moneyController = new MoneyController();
        lottoController.draw(moneyController.purchaseMoney());
    }
}
