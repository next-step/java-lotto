package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import lotto.domain.PrizeSummary;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

public class PrizeSummaryTest {
    @Test
    void calculatePrizeAmount() {
        PrizeSummary prizeSummary = new PrizeSummary(
                Map.of(Rank.MISS, 1, Rank.FIRST, 2, Rank.FOURTH, 0, Rank.FIFTH, 1));
        assertThat(prizeSummary.calculatePrizeAmount()).isEqualTo(4000005000L);
    }
}
