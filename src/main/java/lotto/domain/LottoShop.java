package lotto.domain;

import lotto.domain.exception.InvalidLottoMoneyException;
import lotto.domain.exception.InvalidLottoShopManualCountException;

import java.util.Collections;

public class LottoShop {
    public static final int LOTTO_PRICE = 1_000;
    private static final int MIN_MONEY_BOUND = 0;

    public static CombinedLottos sell(int money) {
        return sell(money, new Lottos(Collections.emptyList()));
    }

    public static CombinedLottos sell(int money, Lottos manualLottos) {
        checkValidMoney(money);
        checkValidManualLottos(money, manualLottos);

        int autoLottoQuantity = money / LOTTO_PRICE - manualLottos.getLottoQuantity();
        return new CombinedLottos(manualLottos, LottosFactory.createAuto(autoLottoQuantity));
    }

    private static void checkValidMoney(int money) {
        if (money < MIN_MONEY_BOUND) {
            throw new InvalidLottoMoneyException("입력한 금액 : ", String.valueOf(money));
        }
    }

    private static void checkValidManualLottos(int money, Lottos manualLottos) {
        if (manualLottos.getLottoQuantity() < 0 ||
                manualLottos.getLottoQuantity() > money / LOTTO_PRICE) {
            throw new InvalidLottoShopManualCountException("입력한 수동 로또 갯수 : ", String.valueOf(manualLottos));
        }
    }
}
