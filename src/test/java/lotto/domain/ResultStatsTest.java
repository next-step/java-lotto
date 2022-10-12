package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultStatsTest {

    private final List<Integer> matchingCountsByTicket = Arrays.asList(0, 0, 0, 3, 6, 3, 4);
    private final ResultStats resultStats = new ResultStats(matchingCountsByTicket);

    @Test
    @DisplayName("로또 1등부터 낙첨까지 갯수별 당첨 이력 검증")
    void prizeCountsByRank() {
        List<Integer> ascendingOrderRank = Arrays.asList(1, 0, 1, 2, 3);
        assertThat(resultStats.countsOfPrizes()).isEqualTo(ascendingOrderRank);
    }

    @Test
    @DisplayName("로또 당첨금액 수익률 검증")
    void returnOnInvestment() {
        assertThat(resultStats.returnOnInvestment(100000)).isEqualTo(20000.6);
    }
}
