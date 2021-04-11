package lotto.domain.Dto;

import lotto.enums.WinningRank;

public class RankCountDto {
    private final int matchedCountStandard;
    private final boolean hasBonus;
    private final int prize;
    private final int matchedCountAfterComparison;

    public RankCountDto(WinningRank rank, Integer matchedCountAfterComparison) {
        this.matchedCountStandard = rank.matchedCount().matchedCount();
        this.hasBonus = rank.hasBonus();
        this.prize = rank.prize().prize();
        this.matchedCountAfterComparison = matchedCountAfterComparison;
    }

    public int matchedCountStandard() {
        return matchedCountStandard;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public int prize() {
        return prize;
    }

    public int matchedCountAfterComparison() {
        return matchedCountAfterComparison;
    }
}
