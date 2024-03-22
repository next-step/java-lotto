package controller.lotto;

import controller.lotto.view.LottoInputView;
import domain.common.Money;
import domain.lotto.UserLotto;

public class LottoController {
    /**
     * 로또를 랜덤으로 구매한다.
     * @param args
     */
    public static void main(String[] args) {

        Money moneyViewThenGetMoney = LottoInputView.createMoneyViewThenGetMoney();

    }
}
