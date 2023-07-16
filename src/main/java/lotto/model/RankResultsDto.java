package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class RankResultsDto {

    private final List<Rank> ranks;

    public RankResultsDto(final List<Rank> ranks) {
        this.ranks = ranks;
    }

    public static RankResultsDto add(
            final RankResultsDto manualRankResultsDto,
            final RankResultsDto autoRankResultsDto) {
        List<Rank> ranks = new ArrayList<>(manualRankResultsDto.ranks);
        ranks.addAll(autoRankResultsDto.ranks);
        return new RankResultsDto(ranks);
    }

    public List<Rank> getRanks() {
        return new ArrayList<>(ranks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RankResultsDto that = (RankResultsDto) o;
        return Objects.equals(ranks, that.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }
}
