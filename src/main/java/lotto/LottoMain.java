package lotto;

import lotto.controller.LottoResultController;
import lotto.controller.LottoPurchaseController;
import lotto.controller.MoneyController;
import lotto.domain.Money.ImmutableMoney;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultService;

public class LottoMain {

    public static void main(String[] args) {
        LottoResultController lottoResultController = new LottoResultController(new LottoResultService());
        LottoPurchaseController lottoPurchaseController = new LottoPurchaseController(new LottoPurchaseService());
        MoneyController moneyController = new MoneyController();

        ImmutableMoney purchaseMoney = moneyController.purchaseMoney();

        lottoResultController.draw(lottoPurchaseController.purchaseLotto(purchaseMoney), purchaseMoney);
    }
}
