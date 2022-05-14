package lotto.dto;

import lotto.domain.constant.Rank;

public class MatchRankDto {

    private final int count;
    private final Rank rank;

    public MatchRankDto(int count, Rank rank) {
        this.count = count;
        this.rank = rank;
    }
}
