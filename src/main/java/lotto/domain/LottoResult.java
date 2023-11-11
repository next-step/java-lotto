package lotto.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoResult {
    private final WinningLotto winningLotto;
    private final Lottos lottos;

    public LottoResult(WinningLotto winningLotto, Lottos lottos) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;
    }

    public List<Rank> findWinningRanks() {
        return this.lottos.getLottos()
                .stream()
                .map(this.winningLotto::match)
                .filter(result -> result >= Rank.getMinMatchCount())
                .map(Rank::findRank)
                .collect(Collectors.toUnmodifiableList());
    }

    public Money calcTotalWinningPrice(List<Rank> ranks) {
        long totalWinningPrice = ranks.stream()
                .mapToLong(Rank::getWinningPrice)
                .sum();

        return new Money(BigDecimal.valueOf(totalWinningPrice));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(winningLotto, that.winningLotto) && Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, lottos);
    }
}
