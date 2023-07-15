package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<List<LottoNumber>> getLottos() {
        return lottos.stream()
                .map(Lotto::getLottoNumbers)
                .collect(Collectors.toUnmodifiableList());
    }

    public long size() {
        return lottos.size();
    }

    public LottoResults matchWinningNumbers(WinningNumbers winningNumbers) {
        LottoResults lottoResults = new LottoResults();
        for (Lotto lotto : lottos) {
            lottoResults.add(winningNumbers.match(lotto), 1);
        }
        return lottoResults;
    }

    public Lottos combineLottos(Lottos lottos) {
        ArrayList<Lotto> combineLottos = new ArrayList<>(this.lottos);
        combineLottos.addAll(lottos.lottos);
        return new Lottos(Collections.unmodifiableList(combineLottos));
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

    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }
}
