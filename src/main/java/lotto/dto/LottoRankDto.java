package lotto.dto;

import lotto.domain.constant.Rank;

public class LottoRankDto {
    private final Rank rank;
    private final int count;

    public LottoRankDto(Rank rank, int count) {
        this.rank = rank;
        this.count = count;
    }

    public Rank getRank() {
        return rank;
    }

    public int getCount() {
        return count;
    }
}
