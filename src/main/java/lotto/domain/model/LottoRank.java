package lotto.domain.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    FAIL_NONE(0, new Money(0)),
    FAIL_ONE(1, new Money(0)),
    FAIL_TWO(2, new Money(0)),
    FOURTH(3, new Money(5_000)),
    THIRD(4, new Money(50_000)),
    SECOND(5, new Money(1_500_000)),
    FIRST(6, new Money(2_000_000_000));

    private final int numOfMatch;
    private final Money amountOfPrize;

    private static final Map<Integer, LottoRank> RANK_MAP = Stream.of(values())
            .collect(Collectors.toMap(LottoRank::getNumOfMatch, rank -> rank));
    public static final List<LottoRank> RANK_WITH_PRIZE = Stream.of(values())
            .filter(rank -> rank.getPrize() != 0)
            .collect(Collectors.toList());

    LottoRank(int numOfMatch, Money amountOfPrize) {
        this.numOfMatch = numOfMatch;
        this.amountOfPrize = amountOfPrize;
    }

    public int getNumOfMatch() {
        return numOfMatch;
    }

    public int getPrize() {
        return amountOfPrize.getAmount();
    }

    public static LottoRank fromMatchedNum(int numOfMatch) {
        if (!RANK_MAP.containsKey(numOfMatch)) throw new IllegalArgumentException("유효하지 않은 로또 당첨 번호 갯수입니다.");
        return RANK_MAP.get(numOfMatch);
    }
}
