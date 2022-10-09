package lotto;

import lotto.domain.CanNotBuyLottoException;
import lotto.domain.Cashier;
import lotto.view.InputView;

public class Application {

    public static void main(String[] args) {
        Cashier cashier = createCashier();
    }

    private static Cashier createCashier() {
        try {
            return new Cashier(InputView.receiveMoney());
        } catch (CanNotBuyLottoException e) {
            System.out.println(e.getMessage());
            return createCashier();
        }
    }
}
