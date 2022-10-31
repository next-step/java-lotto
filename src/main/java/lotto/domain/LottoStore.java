package lotto.domain;

import static lotto.exception.ExceptionMessage.ERROR_NOT_ENOUGH_MONEY;

import lotto.strategy.IssueLottoStrategy;

public class LottoStore {

    private static final LottoStore INSTANCE = new LottoStore();
    private static final int LOTTO_PRICE = 1_000;

    private LottoStore() {
    }

    public static LottoStore getInstance() {
        return INSTANCE;
    }

    public void buyLotto(final LottoStorage storage, final Money money, final IssueLottoStrategy strategy) {
        int count = money.countMaxNumberOfItemToBuy(LOTTO_PRICE);
        if (count == 0) {
            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_MONEY.getMessage());
        }

        storage.add(strategy.issue(count));
    }
}
