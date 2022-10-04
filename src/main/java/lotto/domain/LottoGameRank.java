package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum LottoGameRank {
    FIRST(new Money(2_000_000_000), 6, count -> count == 6),
    THIRD(new Money(1_500_000), 5, count -> count == 5),
    FOURTH(new Money(50_000), 4, count -> count == 4),
    FIFTH(new Money(5_000), 3, count -> count == 3),
    NONE(new Money(0), 0, count -> false);

    private final Money reward;
    private final int rankConditionCount;
    private final Function<Integer, Boolean> rankCondition;

    LottoGameRank(Money reward, int rankConditionCount, Function<Integer, Boolean> rankCondition) {
        this.reward = reward;
        this.rankConditionCount = rankConditionCount;
        this.rankCondition = rankCondition;
    }

    public static LottoGameRank findRank(LottoTicket lottoTicket, LottoResult lottoResult) {
        int count = countSameNumbers(lottoTicket.getLottoNumbers(), lottoResult.getLottoNumbers());

        return Arrays.stream(values())
            .filter(rank -> rank.rankCondition.apply(count))
            .findFirst()
            .orElse(LottoGameRank.NONE);
    }

    private static int countSameNumbers(List<LottoNumber> lottoNumbers, List<LottoNumber> resultNumbers) {
        return (int)resultNumbers.stream()
            .filter(lottoNumbers::contains)
            .count();
    }

    public Money getReward() {
        return reward;
    }

    public int getMinimumMatchNumberCount() {
        return rankConditionCount;
    }
}
