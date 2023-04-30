package study.lotto.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SoldLottos {
    private final List<Lotto> lottos;

    public SoldLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<String> selectedNumbers() {
        return lottos.stream()
                .map(this::selectedNumberOf)
                .collect(Collectors.toList());
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int numberOfPurchase() {
        return lottos.size();
    }

    private String selectedNumberOf(Lotto lotto) {
        return lotto.selectedNumbers().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SoldLottos)) return false;
        SoldLottos that = (SoldLottos) o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
