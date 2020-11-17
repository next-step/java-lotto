package step3.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }


    public List<String> lottoNumbersToStringList() {
        return lottos.stream()
                .map(Lotto::getLottoNumbersToStringList)
                .collect(Collectors.toList());
    }

    public List<LottoRank> matchLastWeekLotto(LastWeekLotto lastWeekLotto) {
        return lottos.stream()
                .map(lastWeekLotto::getRanking)
                .collect(Collectors.toList());
    }

    public int getLottoCount() {
        return lottos.size();
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
