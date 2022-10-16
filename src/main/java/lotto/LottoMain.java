package lotto;

import lotto.controller.LottoController;
import lotto.controller.LottoPurchaseController;
import lotto.controller.MoneyController;
import lotto.domain.Money.ImmutableMoney;
import lotto.service.LottoService;

public class LottoMain {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoService());
        LottoPurchaseController lottoPurchaseController = new LottoPurchaseController(new LottoService());
        MoneyController moneyController = new MoneyController();

        ImmutableMoney purchaseMoney = moneyController.purchaseMoney();

        lottoController.draw(lottoPurchaseController.purchaseLotto(purchaseMoney), purchaseMoney);
    }
}
