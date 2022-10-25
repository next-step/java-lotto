package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoResult getResult(WinnerNumbers winnerNumbers) {
        return lottos.stream()
            .map(lotto -> lotto.checkRank(winnerNumbers))
            .collect(Collectors.collectingAndThen(Collectors.toUnmodifiableList(), LottoResult::new));
    }

    public long getAutoQuantity() {
        return lottos.stream()
            .filter(Lotto::isAuto)
            .count();
    }

    public long getManualQuantity() {
        return lottos.stream()
            .filter(Lotto::isManual)
            .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
