package lotto.domain;

import java.util.ArrayList;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private static final String MIN_PURCHASE_EXCEPTION_MESSAGE = "최소 1000원이어야 합니다.";
    private static final LottoShop INSTANCE = new LottoShop();

    private LottoShop() {
    }

    public static LottoShop getInstance() {
        return INSTANCE;
    }

    public int countPossibleLottoAmount(final Money money) {
        validatePrice(money);
        return money.divideByThousand();
    }

    private void validatePrice(final Money money) {
        if (money.getMoney() < LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_PURCHASE_EXCEPTION_MESSAGE);
        }
    }

    public Lottos buyLotto(final int lottoAmount) {
        Lottos lottos = new Lottos(new ArrayList<>());
        for (int amount = ZERO; amount < lottoAmount; amount++) {
            lottos.storeLotto(new Lotto());
        }
        return lottos;
    }

}
