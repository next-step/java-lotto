package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final List<LottoRank> lottoRanks = List.of(LottoRank.FOUR, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return this.lottos.size();
    }

    public void foreach(Consumer consumer) {
        for (Lotto lotto : lottos) {
            consumer.accept(lotto);
        }
    }

    public long match(Lotto winningLotto, long count) {
        return this.lottos.stream()
                .filter((o) -> o.match(winningLotto, count))
                .count();
    }

    public List<Long> calculateMatchingCounts(Lotto lotto) {
        return lottoRanks.stream()
                .map(rank -> match(lotto, rank.getMatchCount()))
                .collect(Collectors.toList());
    }

    public long calculateProfit(Lotto winningLotto) {
        return IntStream.range(0, lottoRanks.size())
        .mapToLong(i -> match(winningLotto, lottoRanks.get(i).getMatchCount()) * lottoRanks.get(i).getPrizeMoney())
        .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lottos)) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottos);
    }
}
