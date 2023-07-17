package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.vo.Money;
import lotto.domain.vo.Quantity;

public class LottoGroup {

    private static final Money LOTTO_PRICE = new Money(1000L);

    private final List<Lotto> lottos;

    public LottoGroup(final List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static LottoGroup createRandomAndManualLottos(final Quantity randomQuantity,
        final List<List<Integer>> manualLottoNumbers) {
        if (randomQuantity.equals(new Quantity(0)) && manualLottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("lotto size can't be zero");
        }
        List<Lotto> manualLottos = manualLottoNumbers.stream()
            .map(Lotto::createSpecificLotto)
            .collect(Collectors.toList());
        for (int i = 0; i < randomQuantity.getValue(); i++) {
            manualLottos.add(Lotto.createRandomLotto());
        }
        return new LottoGroup(manualLottos);
    }

    public static Quantity calculateRandomLottoQuantity(Money money, Quantity manualLottoQuantity) {
        if (!canBuy(money, manualLottoQuantity)) {
            throw new IllegalArgumentException("not enough money");
        }
        return getQuantity(money).subtract(manualLottoQuantity);
    }

    public static Quantity getQuantity(final Money money) {
        Double divided = money.divide(LOTTO_PRICE);
        return new Quantity(divided.intValue());
    }

    public static Money getSpentMoney(final Quantity quantity) {
        return LOTTO_PRICE.multiply(quantity.getValue());
    }

    private static void verify(Money money) {
        if (money.isUnderThan(LOTTO_PRICE)) {
            throw new IllegalArgumentException(
                "purchase money amount should be greater than lotto price.");
        }
    }

    private static boolean canBuy(Money available, Quantity quantity) {
        Money required = getSpentMoney(quantity);
        return required.isUnderThan(available) || required.equals(available);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
