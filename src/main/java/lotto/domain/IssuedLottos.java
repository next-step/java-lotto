package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class IssuedLottos {

    private final List<Lotto> lottos;

    public IssuedLottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return this.lottos.size();
    }

    public MatchedNumbers checkNumbers(final List<Integer> winNumbers) {
        final int matchCount = winNumbers.size() + 1;
        MatchedNumbers matchedNumbers = new MatchedNumbers(matchCount);
        for (Lotto lotto : lottos) {
            final int matchedNumberCount = lotto.findMatchedNumberCount(winNumbers);
            matchedNumbers.add(matchedNumberCount);
        }
        return matchedNumbers;
    }

    public List<Lotto> findAllIssuedLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuedLottos that = (IssuedLottos) o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
