package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.settings.LottoSettings;
import lotto.util.UniqueRandomNumberProvider;

public class LottoStore {

    private static final Money BASE_AMOUNT = new Money(LottoSettings.DEFAULT_PRICE.value());

    public List<Lotto> buy(Money money) {
        if (isInvalidBaseUnit(money)) {
            throw new IllegalArgumentException("로또는 1000원 단위이여야 합니다.");
        }

        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < money.divide(BASE_AMOUNT); i++) {
            result.add(new Lotto(generateRandomNumbers()));
        }
        return result;
    }

    private boolean isInvalidBaseUnit(Money fee) {
        return !fee.change(BASE_AMOUNT).equals(Money.zero());
    }

    private List<Integer> generateRandomNumbers() {
        int min = LottoSettings.MIN.value();
        int max = LottoSettings.MAX.value();
        int size = LottoSettings.SIZE.value();
        return UniqueRandomNumberProvider.provideInRange(min, max, size);
    }

    public Rank check(Lotto lotto, WinningLotto winning) {
        return winning.match(lotto);
    }
}
