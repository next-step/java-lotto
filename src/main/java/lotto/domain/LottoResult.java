package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<Rank, Long> rankCount = new EnumMap<>(Rank.class);

    public LottoResult(final List<Rank> ranks) {
        ranks.forEach(this::increaseRankCount);
    }

    public Long getCount(final Rank rank) {
        return rankCount.getOrDefault(rank, 0L);
    }

    public double calculateRatio(final LottoMoney lottoMoney) {
        return calculateTotalPrize().ratio(lottoMoney);
    }

    private LottoMoney calculateTotalPrize() {
        List<LottoMoney> prizes = Arrays.stream(Rank.values())
                .map(rank -> rank.calculatePrize(getCount(rank)))
                .collect(Collectors.toList());

        return LottoMoney.sum(prizes);
    }

    private void increaseRankCount(final Rank rank) {
        rankCount.put(rank, getCount(rank) + 1);
    }
}
