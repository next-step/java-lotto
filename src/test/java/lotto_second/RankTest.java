package lotto_second;

import lotto_second.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("일치하는 번호 수와 보너스볼 일치 여부에 따른 등수 확인")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, MISS"
    })
    void valueOf(int countOfMatch, boolean matchBonus, Rank expected) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(expected);
    }

    @DisplayName("등수에 따른 일치하는 번호 수 확인")
    @ParameterizedTest
    @CsvSource({
            "FIRST, 6",
            "SECOND, 5",
            "THIRD, 5",
            "FOURTH, 4",
            "FIFTH, 3"
    })
    void getCountOfMatch(Rank rank, int expected) {
        assertThat(rank.getCountOfMatch()).isEqualTo(expected);
    }

    @DisplayName("등수에 따른 상금 확인")
    @ParameterizedTest
    @CsvSource({
            "FIRST, 2000000000",
            "SECOND, 30000000",
            "THIRD, 1500000",
            "FOURTH, 50000",
            "FIFTH, 5000"
    })
    void getWinningMoney(Rank rank, int expected) {
        assertThat(rank.getWinningMoney()).isEqualTo(expected);
    }
}
