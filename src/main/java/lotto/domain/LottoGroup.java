package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGroup {

    public static final Long LOTTO_PRICE = 1000L;
    private final List<Lotto> lottos;

    public LottoGroup(final List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static LottoGroup from(final Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.calculateQuantity(new Money(LOTTO_PRICE)); i++) {
            lottos.add(Lotto.createRandomLotto());
        }
        return new LottoGroup(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
