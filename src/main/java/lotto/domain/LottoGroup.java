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
        verify(lottos);
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static LottoGroup createRandomAndManualLottos(final Quantity randomQuantity,
        final List<List<Integer>> manualLottoNumbers) {
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

    public static Money getSpentMoney(final Quantity quantity) {
        return LOTTO_PRICE.multiply(quantity.getValue());
    }

    private static Quantity getQuantity(final Money money) {
        Double divided = money.divide(LOTTO_PRICE);
        return new Quantity(divided.intValue());
    }

    private static boolean canBuy(Money available, Quantity quantity) {
        Money required = getSpentMoney(quantity);
        return required.isUnderThan(available) || required.equals(available);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void verify(List<Lotto> lottos) {
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException("lotto size can't be zero");
        }
    }
}
