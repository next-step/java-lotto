package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RanksTest {

    private Ranks ranks;
    private List<MatchInfo> matchInfos;
    private Map<Rank, Integer> totalRanks;

    @BeforeEach
    void setUp() {
        ranks = new Ranks();
        matchInfos = Arrays.asList(
            new MatchInfo(0, false),
            new MatchInfo(1, false),
            new MatchInfo(5, true),
            new MatchInfo(3, false),
            new MatchInfo(4, false)
        );
        totalRanks = ranks.updateRanks(matchInfos);
    }

    @DisplayName("랭킹을 업데이트 한다")
    @Test
    void updateRanks() {
        assertAll(
            () -> assertThat(totalRanks.get(Rank.SECOND)).isEqualTo(1),
            () -> assertThat(totalRanks.get(Rank.FIFTH)).isEqualTo(1),
            () -> assertThat(totalRanks.get(Rank.FOURTH)).isEqualTo(1),
            () -> assertThat(totalRanks.get(Rank.MISS)).isEqualTo(2)
        );
    }

    @DisplayName("결과를 순회하며 총 로또 개수를 구한다")
    @Test
    void calculateTotalLottoCount() {
        int totalLottoCount = ranks.calculateTotalLottoCount();
        assertThat(totalLottoCount).isEqualTo(5);
    }

    @DisplayName("결과를 순회하며 총 상금 액수를 구한다")
    @Test
    void calcultaeTotalPrize() {
        int totalPrize = ranks.calculateTotalPrize();
        assertThat(totalPrize).isEqualTo(30055000);
    }
}
