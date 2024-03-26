package lotto.domain.purchase;

import lotto.domain.lotto.AutoLottoGenerator;
import lotto.domain.lotto.Lottos;
import lotto.error.ErrorCode;

public class LotteryShop {
    public static final Cash LOTTO_PRICE = new Cash(1000L);

    private LotteryShop() {}

    public static Cash purchaseManualAndChange(Cash cash, Amount amount) {
        final Cash totalPrice = LOTTO_PRICE.multiply(amount);
        if (cash.smallerThan(totalPrice)) {
            throw new IllegalArgumentException(ErrorCode.CASH_NOT_ENOUGH.message());
        }

        return cash.subtract(totalPrice);
    }

    public static Lottos exchangeNumbersToLottos(String[][] manualNumbers) {
        if (manualNumbers == null || manualNumbers.length == 0) {
            return new Lottos();
        }
        return new Lottos(manualNumbers);
    }

    public static Lottos purchaseAuto(Cash cash) {
        return AutoLottoGenerator.tickets(
                cash.buyableAmount(LOTTO_PRICE));
    }
}
