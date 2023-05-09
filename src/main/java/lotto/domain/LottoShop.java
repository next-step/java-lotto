package lotto.domain;

import lotto.domain.exception.InvalidLottoMoneyException;
import lotto.domain.exception.InvalidLottoShopManualCountException;

public class LottoShop {
    public static final int LOTTO_PRICE = 1_000;
    private static final int MIN_MONEY_BOUND = 0;

    private final int money;
    private final Lottos manualLottos;

    public LottoShop(int money, Lottos manualLottos) {
        checkValidMoney(money);
        checkValidManualLottos(money, manualLottos);

        this.money = money;
        this.manualLottos = manualLottos;
    }

    private void checkValidMoney(int money) {
        if (money < MIN_MONEY_BOUND) {
            throw new InvalidLottoMoneyException("입력한 금액 : ", String.valueOf(money));
        }
    }

    private void checkValidManualLottos(int money, Lottos manualLottos) {
        if (manualLottos.getLottoQuantity() < 0 ||
                manualLottos.getLottoQuantity() > money / LOTTO_PRICE) {
            throw new InvalidLottoShopManualCountException("입력한 수동 로또 갯수 : ", String.valueOf(manualLottos));
        }
    }

    public Lottos sell() {
        return Lottos.concat(manualLottos, LottosFactory.createAuto(getAutoLottoQuantity()));
    }

    public int getAutoLottoQuantity() {
        return money / LOTTO_PRICE - manualLottos.getLottoQuantity();
    }

    public int getManualLottoQuantity() {
        return manualLottos.getLottoQuantity();
    }
}
