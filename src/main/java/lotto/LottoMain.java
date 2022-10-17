package lotto;

import lotto.controller.lotto.LottoResultController;
import lotto.controller.lotto.LottoPurchaseController;
import lotto.controller.MoneyController;
import lotto.domain.Money.ImmutableMoney;
import lotto.domain.lotto.Lotto;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultService;

import java.util.Collections;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        LottoResultController lottoResultController = new LottoResultController(new LottoResultService());
        LottoPurchaseController lottoPurchaseController = new LottoPurchaseController(new LottoPurchaseService());
        MoneyController moneyController = new MoneyController();

        lottoResultController.draw(lottoPurchaseController.purchaseLotto(moneyController.purchaseMoney()));
    }
}
