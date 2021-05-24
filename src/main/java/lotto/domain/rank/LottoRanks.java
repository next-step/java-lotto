package lotto.domain.rank;

import lotto.domain.PositiveNumber;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoRanks {
    private static final long EMPTY_COUNT = 0;
    private final Map<LottoRank, Long> countOfLottoRank;

    public LottoRanks(Map<LottoRank, Long> countOfLottoRank) {
        this.countOfLottoRank = Collections.unmodifiableMap(countOfLottoRank);
    }

    public static LottoRanks createByList(List<LottoRank> lottoRanks) {
        return new LottoRanks(lottoRanks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        );
    }

    public PositiveNumber sumReward() {
        PositiveNumber sumRewardOfRanks = PositiveNumber.ZERO;
        for (LottoRank lottoRank : LottoRank.values()) {
            sumRewardOfRanks = sumRewardOfRanks.plus(sumOfRank(lottoRank));
        }

        return sumRewardOfRanks;
    }

    private PositiveNumber sumOfRank(LottoRank rank) {
        return new PositiveNumber(countOf(rank) * rank.getAmount());
    }

    public long countOf(LottoRank lottoRank) {
        if (countOfLottoRank.containsKey(lottoRank)) {
            return countOfLottoRank.get(lottoRank);
        }

        return EMPTY_COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoRanks that = (LottoRanks) o;
        return Objects.equals(countOfLottoRank, that.countOfLottoRank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfLottoRank);
    }
}
