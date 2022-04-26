package me.devyonghee.lotto.view.dto;

import me.devyonghee.lotto.model.Rank;

public class RankResponse {

    private final int prize;
    private final int matchCount;
    private final boolean matchedBonus;
    private final int count;

    public RankResponse(int prize, int matchCount, boolean matchedBonus, int count) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.matchedBonus = matchedBonus;
        this.count = count;
    }

    public static RankResponse of(Rank rank, int count) {
        return new RankResponse(rank.prize(), rank.matchCount(), rank.matchedBonus(), count);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchedBonus() {
        return matchedBonus;
    }

    public int getCount() {
        return count;
    }
}
