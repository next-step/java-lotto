package lotto.dto;

import lotto.domain.Rank;

import java.util.Objects;

public class LottoGameResultDto {

    private final Rank rank;
    private final long matchingCount;

    public LottoGameResultDto(Rank rank, long matchingCount) {
        this.rank = rank;
        this.matchingCount = matchingCount;
    }

    public Rank getRank() {
        return rank;
    }

    public long getMatchingCount() {
        return matchingCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGameResultDto that = (LottoGameResultDto) o;
        return matchingCount == that.matchingCount &&
                rank == that.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, matchingCount);
    }
}
