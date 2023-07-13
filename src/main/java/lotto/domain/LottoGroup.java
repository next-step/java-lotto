package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.vo.Money;

public class LottoGroup {

    private static final Money LOTTO_PRICE = new Money(1000L);

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

    public static Money getSpentMoney(final Long quantity) {
        return LOTTO_PRICE.multiply(quantity);
    }

    private static void verify(Money money) {
        if (money.isUnderThan(LOTTO_PRICE)) {
            throw new IllegalArgumentException(
                "purchase money amount should greater than lotto price.");
        }
    }

    public static LottoGroup of(final Money money, final List<Lotto> manualLottos) {
        // 구매 가능한 로또 개수
        int quantity = LottoGroup.getQuantity(money);
        if (quantity < manualLottos.size()) {
            throw new IllegalArgumentException(
                "purchase money amount should greater than manual lotto counts");
        }
        // 자동 로또 생성
        List<Lotto> lottos = new ArrayList<>(manualLottos);
        for (int i = 0; i < quantity - manualLottos.size(); i++) {
            lottos.add(Lotto.createRandomLotto());
        }
        return new LottoGroup(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
