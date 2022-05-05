package autolotto.domain;

import autolotto.constant.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {
    private Results results;

    @BeforeEach
    void setUp() {
        results = new Results();
    }

    @Test
    void ReturnPrize() {
        results.plusWinners(Rank.FIRST);
        results.plusWinners(Rank.SECOND);
        assertThat(results.profit()).isEqualTo(2_030_000_000L);
    }

    @Test
    void rankGiven_ReturnIncreasedWinners() {
        assertThat(results.plusWinners(Rank.FIRST)).isEqualTo(1);
        assertThat(results.plusWinners(Rank.FIRST)).isEqualTo(2);
        assertThat(results.plusWinners(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    void rankGiven_ReturnWinners() {
        results.plusWinners(Rank.FIRST);
        results.plusWinners(Rank.SECOND);
        assertThat(results.countOfWinners(Rank.FIRST)).isEqualTo(1);
        assertThat(results.countOfWinners(Rank.SECOND)).isEqualTo(1);
        assertThat(results.countOfWinners(Rank.THIRD)).isEqualTo(0);
    }

    @Test
    void roi() {
        results.plusWinners(Rank.FIFTH);
        assertThat(results.roi(5000)).isEqualTo(100);
    }
}
