package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoStatistics {

    private final Map<LottoRank, Integer> statistics
        = new EnumMap<>(LottoRank.class);

    public LottoStatistics(WinningLotto winningLotto, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            LottoRank rank = winningLotto.getRank(lotto);
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }
    }

    public int getCountByRank(LottoRank rank) {
        return statistics.getOrDefault(rank, 0);
    }

    public Money getTotalPrize() {
        return statistics.entrySet().stream()
            .map(entry -> entry.getKey().getPrize().mul(new Money(entry.getValue())))
            .reduce(Money.ZERO, Money::add);
    }

}
