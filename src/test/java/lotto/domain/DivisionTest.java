package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DivisionTest {
    @DisplayName("로또 당첨 순위에 따른 당첨금 테스트")
    @Test
    void check_prize_by_division() {
        assertThat(Division.FIRST.getPrize()).isEqualTo(2000000000);
        assertThat(Division.THIRD.getPrize()).isEqualTo(1500000);
        assertThat(Division.FOURTH.getPrize()).isEqualTo(50000);
        assertThat(Division.FIFTH.getPrize()).isEqualTo(5000);
        assertThat(Division.LOSE.getPrize()).isEqualTo(0);
    }

    @DisplayName("로또 당첨 개수에 따른 Division 테스트")
    @ParameterizedTest
    @CsvSource(value = {"6,true,FIRST", "6,false,FIRST",
                        "5,true,SECOND", "5,false,THIRD",
                        "2,true,LOSE", "2,false,LOSE"})
    void check_division_by_match_count_bonus(int matchCount, boolean matchBonus, Division division) {
        assertThat(Division.valueOf(matchCount, matchBonus)).isEqualTo(division);
    }
}
