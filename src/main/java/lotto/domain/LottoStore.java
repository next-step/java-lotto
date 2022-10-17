package lotto.domain;

import lotto.strategy.IssueLottoStrategy;

public class LottoStore {

    private static final LottoStore INSTANCE = new LottoStore();
    private static final int LOTTO_PRICE = 1_000;

    private LottoStore() {
    }

    public static LottoStore getInstance() {
        return INSTANCE;
    }

    public LottoStorage buyLotto(final Money money, final IssueLottoStrategy strategy) {
        int count = money.countMaxNumberOfItemToBuy(LOTTO_PRICE);
        if (count == 0) {
            throw new IllegalArgumentException("로또를 구매할 수 없습니다.");
        }

        return new LottoStorage(strategy.issue(count));
    }
}
