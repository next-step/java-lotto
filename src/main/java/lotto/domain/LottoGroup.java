package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGroup {
    public static final long LOTTO_PRICE = 1000;
    private final List<Lotto> lottos;

    public LottoGroup(final List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static LottoGroup from(final Quantity quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity.getQuantity(); i++) {
            lottos.add(Lotto.createAutomaticLotto());
        }
        return new LottoGroup(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoGroup merge(final LottoGroup other) {
        return new LottoGroup(Stream.concat(this.lottos.stream(), other.lottos.stream())
                .collect(Collectors.toList()));
    }
}
