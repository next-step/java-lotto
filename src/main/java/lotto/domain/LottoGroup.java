package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.vo.Money;
import lotto.domain.vo.Quantity;

public class LottoGroup {

    private static final Money LOTTO_PRICE = new Money(1000L);

    private final List<Lotto> lottos;
    private final Quantity randomLottoQuantity;

    public LottoGroup(final List<Lotto> manualLottos, final Quantity randomLottoQuantity) {
        List<Lotto> lottos = new ArrayList<>(manualLottos);
        for (int i = 0; i < randomLottoQuantity.getValue(); i++) {
            lottos.add(Lotto.createRandomLotto());
        }
        verify(lottos);
        this.lottos = Collections.unmodifiableList(lottos);
        this.randomLottoQuantity = randomLottoQuantity;
    }

    public static LottoGroup createRandomAndManualLottos(final Money money,
        final List<List<Integer>> manualLottoNumbers) {
        Quantity available = getQuantity(money);
        if (available.isUnderThan(manualLottoNumbers.size())) {
            throw new IllegalArgumentException("not enough money");
        }
        List<Lotto> manualLottos = manualLottoNumbers.stream()
            .map(Lotto::createSpecificLotto)
            .collect(Collectors.toList());
        return new LottoGroup(manualLottos, available.subtract(manualLottoNumbers.size()));
    }

    public static Money getSpentMoney(final Quantity quantity) {
        return LOTTO_PRICE.multiply(quantity.getValue());
    }

    private static Quantity getQuantity(final Money money) {
        Double divided = money.divide(LOTTO_PRICE);
        return new Quantity(divided.intValue());
    }

    public Quantity getRandomLottoQuantity() {
        return randomLottoQuantity;
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
