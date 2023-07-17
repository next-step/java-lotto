package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.vo.Money;
import lotto.domain.vo.Quantity;

public class LottoGroup {

    private static final Money LOTTO_PRICE = new Money(1000L);

    private final List<Lotto> lottos;

    public LottoGroup(final List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static LottoGroup createRandomLottos(final Money money) {
        verify(money);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < getQuantity(money).getValue(); i++) {
            lottos.add(Lotto.createRandomLotto());
        }
        return new LottoGroup(lottos);
    }

    public static LottoGroup createRandomAndManualLottos(final Quantity randomQuantity,
        final List<Lotto> manualLottos) {
        List<Lotto> lottos = new ArrayList<>(manualLottos);
        for (int i = 0; i < randomQuantity.getValue(); i++) {
            lottos.add(Lotto.createRandomLotto());
        }
        return new LottoGroup(lottos);
    }

    public static Quantity getQuantity(final Money money) {
        Double divided = money.divide(LOTTO_PRICE);
        return new Quantity(divided.intValue());
    }

    public static Money getSpentMoney(final Quantity quantity) {
        return LOTTO_PRICE.multiply(quantity.getValue());
    }

    public static void verify(Money money) {
        if (money.isUnderThan(LOTTO_PRICE)) {
            throw new IllegalArgumentException(
                "purchase money amount should be greater than lotto price.");
        }
    }

    public static boolean canBuy(Money available, Quantity quantity) {
        Money required = getSpentMoney(quantity);
        return required.isUnderThan(available) || required.equals(available);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
