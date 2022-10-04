package lotto.domain.enums;

import lotto.domain.entity.LottoTicket;
import lotto.domain.vo.LottoNumber;
import lotto.domain.vo.LottoResult;
import lotto.domain.vo.Money;

import java.util.Arrays;
import java.util.List;

public enum LottoGameRank {
    FIRST(new Money(2_000_000_000), 6),
    THIRD(new Money(1_500_000), 5),
    FOURTH(new Money(50_000), 4),
    FIFTH(new Money(5_000), 3),
    NONE(new Money(0), 0);

    private final Money reward;
    private final int rankConditionCount;


    LottoGameRank(Money reward, int rankConditionCount) {
        this.reward = reward;
        this.rankConditionCount = rankConditionCount;
    }

    public static LottoGameRank findRank(LottoTicket lottoTicket, LottoResult lottoResult) {
        int count = countSameNumbers(lottoTicket.getLottoNumbers(), lottoResult.getLottoNumbers());

        return Arrays.stream(values())
                .filter(rank -> rank.rankConditionCount == count)
                .findFirst()
                .orElse(LottoGameRank.NONE);
    }

    private static int countSameNumbers(List<LottoNumber> lottoNumbers, List<LottoNumber> resultNumbers) {
        return (int) resultNumbers.stream()
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
