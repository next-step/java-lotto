package me.devyonghee.lotto.view.dto;

import me.devyonghee.lotto.model.Rank;

public class RankResponse {

    private final int prize;
    private final int matchCount;
    private final int count;

    public RankResponse(int prize, int matchCount, int count) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.count = count;
    }


    public static RankResponse of(Rank rank, int count) {
        return new RankResponse(rank.prize(), rank.matchCount(), count);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getCount() {
        return count;
    }
}
