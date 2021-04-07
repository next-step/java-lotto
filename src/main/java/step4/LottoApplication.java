package step4;

import step4.domain.count.PassiveCount;
import step4.domain.lotto.Lotto;
import step4.domain.money.Money;
import step4.domain.shop.LottoShop;
import step4.strategy.LottoRandomShuffleStrategy;
import step4.strategy.LottoShuffleStrategy;
import step4.view.InputView;

public final class LottoApplication {
    private static final InputView INPUT_VIEW = InputView.getInstance();
    private static final LottoShuffleStrategy STRATEGY = LottoRandomShuffleStrategy.getInstance();
    public static void main(String[] args) {
        Money money = getInputMoney();
        PassiveCount count = getPassiveCount(money);
        int availablePurchaseCount = money.availablePurchaseCount(Lotto.AMOUNT, count);
        LottoShop lottoShop = LottoShop.getInstance();
        lottoShop.purchaseLotto(availablePurchaseCount, STRATEGY);
    }

    private static PassiveCount getPassiveCount(Money money) {
        try {
            return getPassiveCountWithValidate(money);
        } catch (Exception e) {
            return getPassiveCountWithValidate(money);
        }
    }

    private static final PassiveCount getPassiveCountWithValidate(Money money) {
        int count = INPUT_VIEW.inputPassiveCountByClient();
        validateCount(money, count);
        return PassiveCount.valueOf(count);
    }

    private static final void validateCount(Money money, int count) {
        if (money.isAvailablePurchase(Lotto.AMOUNT, count)) {
            throw new IllegalArgumentException();
        }
    }

    private static final Money getInputMoney() {
         try {
            return Money.valueOf(INPUT_VIEW.inputMoneyByClient());
         } catch (Exception e){
             System.out.println(e.getMessage());
             return Money.valueOf(INPUT_VIEW.inputMoneyByClient());
         }
    }
}
