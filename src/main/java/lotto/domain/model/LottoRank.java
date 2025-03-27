package lotto.domain.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    FAIL_NONE(0, false, new Money(0)),
    FAIL_ONE(1, false, new Money(0)),
    FAIL_TWO(2, false, new Money(0)),
    FIFTH(3, false, new Money(5_000)),
    FOURTH(4, false, new Money(50_000)),
    THIRD(5, false, new Money(1_500_000)),
    SECOND(5, true, new Money(30_000_000)),
    FIRST(6, false, new Money(2_000_000_000));

    private final int numOfMatch;
    private final boolean isBonusMatched;
    private final Money amountOfPrize;

    private static final Map<Integer, List<LottoRank>> RANK_MAP = Stream.of(values())
            .collect(Collectors.groupingBy(LottoRank::getNumOfMatch));
    public static final List<LottoRank> RANK_WITH_PRIZE = Stream.of(values())
            .filter(rank -> rank.getPrize() != 0)
            .collect(Collectors.toList());

    LottoRank(int numOfMatch, boolean isBonusMatched, Money amountOfPrize) {
        this.numOfMatch = numOfMatch;
        this.isBonusMatched = isBonusMatched;
        this.amountOfPrize = amountOfPrize;
    }

    public int getNumOfMatch() {
        return numOfMatch;
    }

    public int getPrize() {
        return amountOfPrize.getAmount();
    }

    public static LottoRank of(int numOfMatch, boolean isBonusMatched) {
        if (!RANK_MAP.containsKey(numOfMatch)) throw new IllegalArgumentException("유효하지 않은 로또 당첨 번호 갯수입니다.");

        List<LottoRank> matchingRanks = RANK_MAP.get(numOfMatch);

        // 2, 3등의 경우 보너스 매치 여부 판정
        if (matchingRanks.size() > 1) {
            return matchingRanks.stream()
                    .filter(rank -> rank.isBonusMatched == isBonusMatched)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("일치하는 당첨 등수가 없습니다."));
        }

        return matchingRanks.get(0);
    }
}
