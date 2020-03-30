package lotto.domain;

import lotto.type.RankType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultTest {
    private MatchResult matchResult;

    @BeforeEach
    void setUP() {
        matchResult = new MatchResult();
        matchResult.addResult(RankType.RANK4);
        matchResult.addResult(RankType.RANK3);
        matchResult.addResult(RankType.NO_RANK);
    }

    @Test
    void addResult() {
        matchResult.addResult(RankType.RANK1);
        matchResult.addResult(RankType.RANK2);
    }

    @Test
    void getCount() {
        int rank1Count = matchResult.getCount(RankType.RANK1);
        int rank2Count = matchResult.getCount(RankType.RANK2);
        int rank3Count = matchResult.getCount(RankType.RANK3);
        int rank4Count = matchResult.getCount(RankType.RANK4);

        assertThat(rank1Count).isEqualTo(0);
        assertThat(rank2Count).isEqualTo(0);
        assertThat(rank3Count).isEqualTo(1);
        assertThat(rank4Count).isEqualTo(1);
    }

    @Test
    void getTotalReward() {
        int totalReward = matchResult.getTotalReward();

        assertThat(totalReward).isEqualTo(55000);
    }
}
