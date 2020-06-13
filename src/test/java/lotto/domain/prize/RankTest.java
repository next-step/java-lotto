package lotto.domain.prize;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @ParameterizedTest
    @CsvSource(value = {"6, true, FIRST", "5, true, SECOND", "5, false, THIRD",
            "3, true, FIFTH", "2, true, MISS", "1, false, MISS"})
    void 일치하는_수를_로또_등수로_변경한다(int countOfMatch, boolean matchBonus, Rank rank) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(rank);
    }


    @ParameterizedTest
    @CsvSource(value = {"FIRST, 0 ", "SECOND, 1", "THIRD, 2", "FOURTH, 3", "FIFTH, 1", "MISS, 3"})
    void 상금을_계산한다(Rank rank, int winningCount) {
        int prizeMoney = rank.calculateTotalPrice(winningCount);
        assertThat(prizeMoney).isEqualTo(rank.getWinningMoney() * winningCount);
    }

}
