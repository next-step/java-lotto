package lotto.domain;

import lotto.domain.type.RankType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultTest {
    private MatchResult matchResult;

    @BeforeEach
    void setUP() {
        matchResult = new MatchResult();
    }

    @Test
    void addResult() {
        matchResult.addResult(RankType.RANK1);
        matchResult.addResult(RankType.RANK2);
    }

    @Test
    void getCount() {
        matchResult.addResult(RankType.RANK1);

        int rank1Count = matchResult.getCount(RankType.RANK1);
        int noRankCount = matchResult.getCount(RankType.NO_RANK);

        assertThat(rank1Count).isEqualTo(1);
        assertThat(noRankCount).isEqualTo(0);
    }

    @Test
    void getTotalReward() {
        matchResult.addResult(RankType.RANK5);
        matchResult.addResult(RankType.RANK4);

        int totalReward = matchResult.getTotalReward();

        assertThat(totalReward).isEqualTo(55000);
    }
}
