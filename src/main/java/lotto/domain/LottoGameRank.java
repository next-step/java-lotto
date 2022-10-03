package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum LottoGameRank {
    FIRST(new Money(2_000_000_000), 6L, count -> count == 6L),
    SECOND(new Money(1_500_000), 5L, count -> count == 5L),
    THIRD(new Money(50_000), 4L, count -> count == 4L),
    FOURTH(new Money(5_000), 3L, count -> count == 3L),
    NONE(new Money(0), 0L, count -> false);

    private final Money reward;
    private final Long rankConditionCount;
    private final Function<Long, Boolean> rankCondition;

    LottoGameRank(Money reward, Long rankConditionCount, Function<Long, Boolean> rankCondition) {
        this.reward = reward;
        this.rankConditionCount = rankConditionCount;
        this.rankCondition = rankCondition;
    }

    public static LottoGameRank findRank(LottoTicket lottoTicket, LottoResult lottoResult) {
        long count = countSameNumbers(lottoTicket.getLottoNumbers(), lottoResult.getLottoNumbers());

        return Arrays.stream(values())
            .filter(rank -> rank.rankCondition.apply(count))
            .findFirst()
            .orElse(LottoGameRank.NONE);
    }

    private static long countSameNumbers(List<LottoNumber> lottoNumbers, List<LottoNumber> resultNumbers) {
        return resultNumbers.stream()
            .filter(lottoNumbers::contains)
            .count();
    }

    public Money getReward() {
        return reward;
    }

    public long getMinimumMatchNumberCount() {
        return rankConditionCount;
    }
}
