package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoStatisticTest {

    @DisplayName("통계 카운트")
    @Test
    void setRankCount() {
        List<MatchResult> matchResults = new ArrayList<>();
        matchResults.add(new MatchResult(3, true));
        matchResults.add(new MatchResult(3, true));
        matchResults.add(new MatchResult(3, true));
        matchResults.add(new MatchResult(4, true));
        matchResults.add(new MatchResult(5, true));
        matchResults.add(new MatchResult(6, true));
        LottoStatistic statistic = new LottoStatistic(matchResults, new LottoCount("15000"));
        System.out.println(statistic.rankCount());
    }
}
