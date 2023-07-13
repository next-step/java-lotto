package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGroup {

    public static final Money LOTTO_PRICE = new Money(1000L);

    private final List<Lotto> lottos;

    public LottoGroup(final List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static LottoGroup from(final Money money) {
        verify(money);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < getQuantity(money); i++) {
            lottos.add(Lotto.createRandomLotto());
        }
        return new LottoGroup(lottos);
    }

    public static int getQuantity(final Money money) {
        return money.divide(LOTTO_PRICE).intValue();
    }

    private static void verify(Money money) {
        if (money.isUnderThan(LOTTO_PRICE)) {
            throw new IllegalArgumentException(
                "purchase money amount should greater than lotto price.");
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
