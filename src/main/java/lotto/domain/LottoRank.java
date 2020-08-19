package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND_BONUS(5, 30_000_000, true),
    SECOND(5, 1_500_000, false),
    THIRD(4, 50_000, false),
    FOURTH(3, 5_000, false),
    DROP(0, 0, false);

    private int matchCount;
    private int prize;
    private boolean matchBonus;

    LottoRank(int matchCount, int prize, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }

    public static LottoRank of(long matchCount, boolean matchBonus) {
        return Stream.of(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == matchCount)
                .filter(lottoRank -> !lottoRank.matchBonus || matchBonus)
                .findFirst()
                .orElse(LottoRank.DROP);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static List<LottoRank> getLowPrizeOrderedLottoRanks() {
        return Stream.of(LottoRank.values())
                .sorted(Comparator.comparingInt(rank -> rank.matchCount))
                .collect(Collectors.toList());
    }

}
