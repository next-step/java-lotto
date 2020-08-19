package cc.oakk.lotto.model;

import cc.oakk.lotto.util.ValidationAdapters;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos() {
        this.lottoList = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottoList) {
        lottoList.forEach(ValidationAdapters::throwIfNull);
        this.lottoList = lottoList;
    }

    public Lottos add(Lotto lotto) {
        lottoList.add(throwIfNull(lotto));
        return this;
    }

    public LottoResults getResults(Lotto comparingLotto) {
        throwIfNull(comparingLotto);
        return new LottoResults(lottoList.stream()
                .map(l -> LottoResult.of(l, comparingLotto))
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos = (Lottos) o;
        return Objects.equals(lottoList, lottos.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoList);
    }

}
