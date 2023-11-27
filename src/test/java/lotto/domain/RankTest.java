package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

    @ParameterizedTest
    @DisplayName("로또의 번호가 일치하는 갯수와 보너스 숫자 여부로 등수를 알려준다.")
    @CsvSource(value = {"0, false, NOTHING", "2, true, NOTHING","3, false, FIFTH", "4, false, FOURTH", "5, false, THIRD","5, true, SECOND", "6, false, FIRST"})
    void inform_rank_by_count_of_match(int countOfMatch, boolean containsBonus, Rank expected) {
        // when
        Rank result = Rank.valeOf(countOfMatch, containsBonus);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("등수 당 총 당첨금을 계산한다.")
    void calculate_total_prize_per_rank() {
        // given
        Rank rank = Rank.THIRD;

        // when
        long result = rank.calculateTotalPrizePerRank(3);

        // then
        assertThat(result).isEqualTo(4500000);
    }
}
